package com.yangrd.today.commons.core.security;

import com.yangrd.today.commons.core.security.jwt.JwtTokenFilterConfigurer;
import com.yangrd.today.commons.core.security.jwt.JwtTokenProvider;
import com.yangrd.today.commons.core.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * WebSecurityConfig
 *
 * @author yangrd
 * @date 2019/04/20
 */

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MultiHttpSecurityConfig {

    @Configuration
    @Order(1)
    public static class JwtTokenWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {

        @Autowired
        private JwtTokenProvider jwtTokenProvider;

        @Autowired
        private UserRepository repository;

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            // Disable CSRF (cross site request forgery)
            http.csrf().disable().cors();

            // No session will be created or used by spring security
            http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

            http
                    .authorizeRequests()
                    .antMatchers("/token/**").permitAll();

            // Apply JWT
            http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));
        }

        @Bean
        @Override
        public AuthenticationManager authenticationManager() throws Exception {
            return super.authenticationManager();
        }

        @Bean
        @Override
        public UserDetailsService userDetailsService() {
            return username -> repository.findUserByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("[" + username + "]用户没有发现"));
        }
    }

    @Configuration
    @Order(3)
    public static class LogWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/log/**").permitAll().anyRequest().authenticated();
        }
    }


    /**
     * createDelegatingPasswordEncoder 加密
     *
     * @return PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


}

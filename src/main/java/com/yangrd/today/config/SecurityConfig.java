package com.yangrd.today.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

/**
 * SecurityConfig
 *
 * @author yangrd
 * @date 2019/10/11
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Configuration
    class FormPageMvcConfig implements WebMvcConfigurer {
        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/login").setViewName("login");
            registry.addViewController("/logout").setViewName("logout");
        }
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.withUserDetails(new User("user", passwordEncoder().encode("password"), Arrays.asList(new SimpleGrantedAuthority("user")))).build());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout().logoutUrl("/logout").deleteCookies("JSESSIONID").and().httpBasic();
    }
}

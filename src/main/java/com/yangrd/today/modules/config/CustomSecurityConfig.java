package com.yangrd.today.modules.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * CustomSecurityConfig
 *
 * @author yangrd
 * @date 2019/10/12
 */
@Configuration
@Order(5)
public class CustomSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/articles/**", "/sites/**").permitAll().anyRequest().authenticated();
    }
}

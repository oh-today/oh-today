package com.yangrd.today.commons.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * UserNameAuditorBean
 *
 * @author yangrd
 * @date 2019/06/19
 */
@EnableJpaAuditing
@Configuration
public class UserNameAuditorBean implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        if (ctx == null) {
            return Optional.empty();
        }
        if (ctx.getAuthentication() == null) {
            return Optional.empty();
        }
        if (ctx.getAuthentication().getPrincipal() == null) {
            return Optional.empty();
        }
        return Optional.of(ctx.getAuthentication().getName());
    }
}

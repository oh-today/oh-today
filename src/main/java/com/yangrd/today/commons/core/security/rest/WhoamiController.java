package com.yangrd.today.commons.core.security.rest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * WhoamiController
 *
 * @author yangrd
 * @date 2019/06/19
 */
@RestController
public class WhoamiController {

    @GetMapping("/me")
    public UserDetails whoami(Principal principal) {
        return (UserDetails) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
    }
}

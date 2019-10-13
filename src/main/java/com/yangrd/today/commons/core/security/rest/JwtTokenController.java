package com.yangrd.today.commons.core.security.rest;

import com.yangrd.today.commons.core.security.jwt.JwtTokenService;
import com.yangrd.today.commons.core.user.service.UserRegisterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * TokenController
 *
 * @author yangrd
 * @date 2019/04/24
 */
@AllArgsConstructor

@RestController
@RequestMapping("token")
public class JwtTokenController {

    private JwtTokenService userTokenService;

    private UserRegisterService userRegisterService;

    @PostMapping("/reg")
    public void register(String username, String password) {
        userRegisterService.register(username, password);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLoginDTO loginDTO) {
        return userTokenService.signIn(loginDTO.getUsername(), loginDTO.getPassword());
    }

    @GetMapping("/refresh")
    public String refresh(HttpServletRequest request) {
        return userTokenService.refresh(request.getRemoteUser());
    }

}

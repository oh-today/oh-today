package com.yangrd.today.commons.core.user.service;

import com.yangrd.today.commons.core.user.User;
import com.yangrd.today.commons.core.user.UserFactory;
import com.yangrd.today.commons.core.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * UserService
 *
 * @author yangrd
 * @date 2019/06/18
 */
@AllArgsConstructor

@Service
public class UserRegisterService {

    private PasswordEncoder passwordEncoder;

    private UserRepository userRepository;

    public User register(String username, String password, String... roles) {
        String encodePwd = passwordEncoder.encode(password);
        User regUser = UserFactory.create(username, encodePwd, roles);
        return userRepository.save(regUser);
    }
}

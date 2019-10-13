package com.yangrd.today.commons.core.user;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * UserFactory
 *
 * @author yangrd
 * @date 2019/06/18
 */
public class UserFactory {

    public static User create(String username, String password, String... roles) {
        User user = new User();
        user.setUsername(username);
        user.setNickname(username);
        user.setPassword(password);
        if (roles.length > 0) {
            user.setRoles(Arrays.asList(roles).stream().collect(Collectors.joining(",")));
        }
        return user;
    }
}

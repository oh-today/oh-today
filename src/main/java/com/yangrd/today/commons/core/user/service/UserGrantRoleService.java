package com.yangrd.today.commons.core.user.service;

import com.yangrd.today.commons.core.user.User;
import org.springframework.util.Assert;

/**
 * UserGrantRoleService
 *
 * @author yangrd
 * @date 2019/06/22
 */
public class UserGrantRoleService {

    /**
     * 　为用户授权
     *
     * @param role
     */
    public void grantRole(User user, String role) {
        Assert.notNull(role, "角色不能为空");
        user.setRoles(user.getRoles() + "," + role);
    }
}

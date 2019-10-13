package com.yangrd.today.commons.core.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * UserRepository
 *
 * @author yangrd
 * @date 2019/05/13
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    Optional<User> findUserByUsername(String username);
}

package com.hxh.repository;


import com.hxh.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author: hxh
 * @date: create in 2018/2/28
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * 查询
     *
     * @param name
     * @return
     */
    @Query("select u from User u where u.loginName=?1")
    User findByLoginName(String name);

    /**
     * 查询
     * @param loginName
     * @param pageable
     * @return
     */
    Page<User> findByLoginName(String loginName, Pageable pageable);
}

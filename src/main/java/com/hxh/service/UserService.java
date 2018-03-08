package com.hxh.service;

import com.hxh.entity.User;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author: hxh
 * @date: create in 2018/2/28
 */
public interface UserService {
    /**
     * 查询
     *
     * @param name
     * @return
     */
    User getUserByLoginName(String name);

    /**
     * 查询
     *
     * @param loginName
     * @param pageIndex
     * @return
     */
    List<User> findByLoginNameAndPage(String loginName, int pageIndex);

    /**
     * 保存和更新
     *
     * @param user
     * @return
     */
    @Transactional
    User saveUser(User user);

    /**
     * 删除
     *
     * @param userIds ','(逗号隔开)
     */
    @Transactional
    void deleteUsers(List<String> userIds);
}

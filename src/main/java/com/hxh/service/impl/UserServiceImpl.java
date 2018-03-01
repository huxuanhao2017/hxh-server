package com.hxh.service.impl;

import com.hxh.common.Constant;
import com.hxh.entity.User;
import com.hxh.repository.UserRepository;
import com.hxh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: hxh
 * @date: create in 2018/2/28
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByLoginName(String name) {
        return userRepository.findByLoginName(name);
    }

    @Override
    public List<User> findByLoginNameAndPage(String loginName, int pageIndex) {
        Pageable pageable = new PageRequest(pageIndex - 1, Constant.PAGE_SIZE);
        return userRepository.findByLoginName(loginName, pageable).getContent();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUsers(String userIds) {
        String[] split = userIds.split(",");
        for (String userId : split) {
            userRepository.delete(Integer.parseInt(userId));
        }
    }
}

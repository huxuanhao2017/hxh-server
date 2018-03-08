package com.hxh.service.impl;

import com.hxh.common.Constant;
import com.hxh.entity.User;
import com.hxh.repository.UserRepository;
import com.hxh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.beans.Transient;
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
        if (StringUtils.isEmpty(loginName)) {
            return userRepository.findAll(pageable).getContent();
        }
        return userRepository.findByLoginName(loginName, pageable).getContent();
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUsers(List<String> userIds) {
        for (String userId : userIds) {
            userRepository.deleteById(Integer.parseInt(userId));
        }
    }
}

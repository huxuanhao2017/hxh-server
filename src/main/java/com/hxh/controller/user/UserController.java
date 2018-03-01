package com.hxh.controller.user;

import com.hxh.common.ApiResult;
import com.hxh.common.enums.ApiCode;
import com.hxh.entity.User;
import com.hxh.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: hxh
 * @date: create in 2018/2/28
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping("/getUser/{loginName}")
    public ApiResult getUser(@PathVariable String loginName) {
        User user = userService.getUserByLoginName(loginName);
        return ApiResult.resultWith(ApiCode.SUCCESS, user);
    }

    /**
     * 获取user表数据
     *
     * @param loginName
     * @param page
     * @return
     */
    @GetMapping("/getUserList")
    public ApiResult getUsersList(String loginName, int page) {
        List<User> userList = userService.findByLoginNameAndPage(loginName, page);
        return ApiResult.resultWith(ApiCode.SUCCESS, userList);
    }

    /**
     * 新建更新用户信息
     *
     * @param user
     * @return
     */
    @PostMapping("/save")
    public ApiResult insertUser(User user) {
        User saveUser = userService.saveUser(user);
        return ApiResult.resultWith(ApiCode.SUCCESS, saveUser);
    }

    /**
     * 删除用户信息
     *
     * @param userIds
     * @return
     */
    @GetMapping("/delete")
    public ApiResult deleteUsers(String userIds) {
        userService.deleteUsers(userIds);
        return ApiResult.resultWith(ApiCode.SUCCESS);
    }
}

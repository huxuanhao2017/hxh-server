package com.hxh.controller.menu;

import com.hxh.common.ApiResult;
import com.hxh.common.enums.ApiCode;
import com.hxh.entity.Menu;
import com.hxh.entity.User;
import com.hxh.service.MenuService;
import com.hxh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: hxh
 * @date: create in 2018/2/28
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;

    /**
     * 获取该用户的菜单权限
     *
     * @param loginName
     * @return
     */
    @GetMapping("/getMenus/{loginName}")
    public ApiResult menuList(@PathVariable String loginName) {
        User user = userService.getUserByLoginName(loginName);
        List<Menu> menuList = menuService.getMenuList(user.getId());
        return ApiResult.resultWith(ApiCode.SUCCESS, menuList);
    }
}

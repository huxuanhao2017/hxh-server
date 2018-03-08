package com.hxh.controller.menu;

import com.hxh.common.ApiResult;
import com.hxh.common.enums.ApiCode;
import com.hxh.entity.Menu;
import com.hxh.entity.User;
import com.hxh.service.MenuService;
import com.hxh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 通过parentId得到menus列表
     *
     * @param parentId
     * @return
     */
    @GetMapping("/parentId")
    public ApiResult menusByParentId(int parentId) {
        return ApiResult.resultWith(ApiCode.SUCCESS, menuService.getByParentId(parentId));
    }

    /**
     * 获取menus表数据
     *
     * @param page
     * @return
     */
    @GetMapping("/getAllMenus")
    public ApiResult menusList(int page, String menuId) {
        return ApiResult.resultWith(ApiCode.SUCCESS, menuService.getAllMenus(menuId, page));
    }

    /**
     * 保存
     *
     * @param menu
     * @return
     */
    @PostMapping("/save")
    public ApiResult saveMenu(@RequestBody Menu menu) {
        menuService.saveMenu(menu);
        return ApiResult.resultWith(ApiCode.SUCCESS);
    }

    /**
     * 删除菜单信息
     *
     * @param groupId
     * @return
     */
    @DeleteMapping("/delete")
    public ApiResult deleteMenus(@RequestBody List<String> groupId) {
        menuService.deleteMenus(groupId);
        return ApiResult.resultWith(ApiCode.SUCCESS);
    }

    /**
     * 获取二级菜单
     *
     * @return
     */
    @GetMapping("/submenus")
    public ApiResult getSubmenus() {
        return ApiResult.resultWith(ApiCode.SUCCESS, menuService.getSubmenus());
    }
}

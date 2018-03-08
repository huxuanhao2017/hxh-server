package com.hxh.controller.role;

import com.hxh.common.ApiResult;
import com.hxh.common.enums.ApiCode;
import com.hxh.entity.Role;
import com.hxh.service.RoleService;
import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: hxh
 * @date: create in 2018/2/28
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 获取role表数据
     *
     * @param page
     * @return
     */
    @GetMapping("/getRoles")
    public ApiResult rolesList(int page) {
        List<Role> roleList = roleService.findByPage(page);
        return ApiResult.resultWith(ApiCode.SUCCESS, roleList);
    }

    /**
     * 新建更新角色信息
     *
     * @param
     * @return
     */
    @PostMapping("/save")
    public ApiResult insertRole(@RequestBody Role role) {
        Role saveRole = roleService.save(role);
        return ApiResult.resultWith(ApiCode.SUCCESS, saveRole);
    }

    /**
     * 删除角色信息
     *
     * @param roleIds
     * @return
     */
    @GetMapping("/delete")
    public ApiResult deleteRoles(String roleIds) {
        roleService.deleteRoles(roleIds);
        return ApiResult.resultWith(ApiCode.SUCCESS);
    }

    /**
     * 得到角色全部数据
     *
     * @return
     */
    @GetMapping("/all")
    public ApiResult allRoles() {
        return ApiResult.resultWith(ApiCode.SUCCESS, roleService.getAll());
    }
}

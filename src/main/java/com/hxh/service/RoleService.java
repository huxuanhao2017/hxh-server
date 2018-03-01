package com.hxh.service;

import com.hxh.entity.Role;

import java.util.List;

/**
 * @author: hxh
 * @date: create in 2018/2/28
 */
public interface RoleService {
    /**
     * 查询
     *
     * @param page
     * @return
     */
    List<Role> findByPage(int page);

    /**
     * 保存更新
     *
     * @param role
     * @return
     */
    Role save(Role role);

    /**
     * 删除
     *
     * @param roleIds ','(逗号隔开)
     */
    void deleteRoles(String roleIds);
}

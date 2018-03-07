package com.hxh.service.impl;

import com.hxh.common.Constant;
import com.hxh.entity.Role;
import com.hxh.repository.RoleRepository;
import com.hxh.service.RoleService;
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
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findByPage(int page) {
        Pageable pageable = new PageRequest(page - 1, Constant.PAGE_SIZE);
        return roleRepository.findAll(pageable).getContent();
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteRoles(String roleIds) {
        String[] split = roleIds.split(",");
        for (String roleId : split) {
            roleRepository.deleteById(Integer.parseInt(roleId));
        }
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }
}

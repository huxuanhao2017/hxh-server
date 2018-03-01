package com.hxh.service.impl;

import com.hxh.entity.Menu;
import com.hxh.entity.Relation;
import com.hxh.entity.Role;
import com.hxh.repository.MenuRepository;
import com.hxh.repository.RelationRepository;
import com.hxh.repository.RoleRepository;
import com.hxh.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hxh
 * @date: create in 2018/2/28
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RelationRepository relationRepository;
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<Menu> getMenuList(Integer userId) {
        //根据userId查询对应用户的角色列表
        List<Integer> roleIdList = relationRepository.findByUserId(userId);
        //根据角色列表查询对应的菜单列表
        List<String> modulesList = roleRepository.findModules(roleIdList);
        List<Integer> menuIdList = new ArrayList<>();
        for (String modules : modulesList) {
            String[] split = modules.split(";");
            for (String menuId : split) {
                if (!StringUtils.isEmpty(menuId)) {
                    menuIdList.add(Integer.parseInt(menuId));
                }
            }
        }
        //先查询父级菜单
        List<Integer> parentIdList = menuRepository.findParentId(menuIdList);
        List<Menu> parentMenuList = menuRepository.findParentMenus(parentIdList);
        //查询自己菜单
        List<Menu> childrenMenuList = menuRepository.findParentMenus(menuIdList);
        List<Menu> menuList = new ArrayList<>();
        parentMenuList.forEach(p -> {
            List<Menu> childrenMen = new ArrayList<>();
            childrenMenuList.forEach(h -> {
                if (p.getId().equals(h.getParentId())) {
                    childrenMen.add(h);
                }
            });
            p.setChildren(childrenMen);
            menuList.add(p);
        });
        return menuList;
    }
}

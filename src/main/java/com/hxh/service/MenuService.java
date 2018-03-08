package com.hxh.service;

import com.hxh.entity.Menu;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author: hxh
 * @date: create in 2018/2/28
 */
public interface MenuService {
    /**
     * 查询
     *
     * @param userId
     * @return
     */
    List<Menu> getMenuList(Integer userId);

    /**
     * 查询
     *
     * @param parentId
     * @return
     */
    List<Menu> getByParentId(int parentId);

    /**
     * 查询
     *
     * @param menuId
     * @param page
     * @return
     */
    List<Menu> getAllMenus(String menuId, int page);

    /**
     * 保存
     *
     * @param menu
     */
    @Transactional
    void saveMenu(Menu menu);

    /**
     * 删除
     *
     * @param groupId
     */
    @Transactional
    void deleteMenus(List<String> groupId);

    /**
     * 查询二级菜单
     *
     * @return
     */
    List<Menu> getSubmenus();
}

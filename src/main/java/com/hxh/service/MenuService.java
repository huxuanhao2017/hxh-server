package com.hxh.service;

import com.hxh.entity.Menu;

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
}

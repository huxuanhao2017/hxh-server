package com.hxh.repository;

import com.hxh.entity.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * @author hxh
 */
public interface MenuRepository extends JpaRepository<Menu, Integer>, JpaSpecificationExecutor {
    /**
     * 查询父级菜单
     *
     * @param menuIdList
     * @return
     */
    @Query("select distinct u.parentId from Menu u where u.id in ?1")
    List<Integer> findParentId(List<Integer> menuIdList);

    /**
     * 根据父级菜单ID查询菜单
     *
     * @param parentIdList
     * @return
     */
    @Query("select u from Menu u where u.id in ?1 order by u.sort")
    List<Menu> findParentMenus(List<Integer> parentIdList);

    /**
     * 查询
     *
     * @param parentId
     * @return
     */
    List<Menu> findByParentId(int parentId);

    /**
     * 查询
     *
     * @param id
     * @param parentId
     * @param pageable
     * @return
     */
    Page<Menu> findByIdOrParentId(Integer id, int parentId, Pageable pageable);

    /**
     * 查询二级菜单
     *
     * @return
     */
    List<Menu> findByUrlIsNotNull();
}

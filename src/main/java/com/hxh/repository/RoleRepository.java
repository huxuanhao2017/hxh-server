package com.hxh.repository;

import com.hxh.entity.Menu;
import com.hxh.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * @author: hxh
 * @date: create in 2018/2/28
 */
public interface RoleRepository extends JpaRepository<Role, Integer>, JpaSpecificationExecutor<Role> {

    /**
     * 查询
     *
     * @param roleIdList
     * @return
     */
    @Query("select u.modules from Role u where u.id in (?1)")
    List<String> findModules(List<Integer> roleIdList);
}

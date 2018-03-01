package com.hxh.repository;

import com.hxh.entity.Relation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author: hxh
 * @date: create in 2018/2/28
 */
public interface RelationRepository extends JpaRepository<Relation, Integer> {
    /**
     * 查询
     *
     * @param userId
     * @return
     */
    @Query("select distinct u.roleId from Relation u where u.userId=?1")
    List<Integer> findByUserId(Integer userId);
}

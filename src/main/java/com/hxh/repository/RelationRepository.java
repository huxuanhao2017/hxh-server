package com.hxh.repository;

import com.hxh.entity.Relation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
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

    /**
     * 查询
     *
     * @param user
     * @return
     */
    @Query("select u from Relation u where u.userId=?1")
    List<Relation> findRelationByUserId(Integer user);

    /**
     * 删除
     *
     * @param userId
     */
    @Modifying
    @Query("delete from Relation u where u.userId = ?1")
    @Transactional
    void deleteByUserId(Integer userId);
}

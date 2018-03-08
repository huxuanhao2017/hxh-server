package com.hxh.service;

import com.hxh.entity.Relation;
import com.hxh.entity.Role;

import java.util.List;

/**
 * @author: hxh
 * @date: create in 2018/3/8
 */
public interface RelationService {
    /**
     * 通过userId得到关系List
     *
     * @param userId
     * @return
     */
    List<Relation> getRelationByUserId(int userId);

    /**
     * 保存
     *
     * @param relationList
     */
    void saveRelations(List<Relation> relationList);
}

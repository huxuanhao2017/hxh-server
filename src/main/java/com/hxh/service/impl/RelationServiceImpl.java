package com.hxh.service.impl;

import com.hxh.entity.Relation;
import com.hxh.repository.RelationRepository;
import com.hxh.repository.RoleRepository;
import com.hxh.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: hxh
 * @date: create in 2018/3/8
 */
@Service
public class RelationServiceImpl implements RelationService {
    @Autowired
    private RelationRepository relationRepository;

    @Override
    public List<Relation> getRelationByUserId(int userId) {
        return relationRepository.findRelationByUserId(userId);
    }

    @Override
    public void saveRelations(List<Relation> relationList) {
        relationRepository.deleteByUserId(relationList.get(0).getUserId());
        relationList.forEach(relation -> {
            relationRepository.save(relation);
        });
    }
}

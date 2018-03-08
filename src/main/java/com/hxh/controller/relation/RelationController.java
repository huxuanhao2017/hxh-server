package com.hxh.controller.relation;

import com.hxh.common.ApiResult;
import com.hxh.common.enums.ApiCode;
import com.hxh.entity.Relation;
import com.hxh.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: hxh
 * @date: create in 2018/3/8
 */
@RestController
@RequestMapping("/relations")
public class RelationController {
    @Autowired
    private RelationService relationService;

    /**
     * 通过userId得到关系List
     *
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    public ApiResult getRelationByUserId(@PathVariable int userId) {
        return ApiResult.resultWith(ApiCode.SUCCESS, relationService.getRelationByUserId(userId));
    }

    @PostMapping("/save")
    public ApiResult saveRelations(@RequestBody() List<Relation> relationList) {
        relationService.saveRelations(relationList);
        return ApiResult.resultWith(ApiCode.SUCCESS, relationList);
    }
}

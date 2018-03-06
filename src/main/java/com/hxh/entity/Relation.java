package com.hxh.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author: hxh
 * @date: create in 2018/2/27
 */
@Entity
@Table(name = "r_user_role")
@Getter
@Setter
public class Relation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;
    /**
     * 角色ID
     */
    @Column(name = "role_id")
    private Integer roleId;
}

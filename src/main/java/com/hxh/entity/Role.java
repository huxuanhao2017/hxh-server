package com.hxh.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author: hxh
 * @date: create in 2018/2/27
 */
@Entity
@Table(name = "role")
@Getter
@Setter
public class Role {
    /**
     * id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 角色
     */
    @Column(name = "role")
    private String role;
    /**
     * 角色名称
     */
    @Column(name = "name")
    private String name;
    /**
     * 权限
     */
    @Column(name = "modules")
    private String modules;
    /**
     * 描述
     */
    @Column(name = "des")
    private String des;
}

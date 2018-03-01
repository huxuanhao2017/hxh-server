package com.hxh.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author hxh
 */
@Entity
@Table(name = "menu")
@Getter
@Setter
public class Menu {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    /**
     * 菜单名
     */
    @Column(name = "name")
    private String name;
    /**
     * url
     */
    @Column(name = "url")
    private String url;
    /**
     * 父类id
     */
    @Column(name = "parentId")
    private int parentId;
    /**
     * 排序
     */
    @Column(name = "sort")
    private int sort;
    /**
     * 描述
     */
    @Column(name = "remark")
    private String remark;
    /**
     * 图标
     */
    @Column(name = "icon")
    private String icon;
    /**
     * a
     * 二级菜单
     */
    @Transient
    List<Menu> children;

}

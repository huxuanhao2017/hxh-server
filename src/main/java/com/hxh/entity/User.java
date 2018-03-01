package com.hxh.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author hxh
 */
@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
    /**
     * id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 姓名
     */
    @Column(name = "loginName")
    private String loginName;
    /**
     * 登录名
     */
    @Column(name = "name")
    private String name;
    /**
     * 密码
     */
    @Column(name = "password")
    private String password;
    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;
}

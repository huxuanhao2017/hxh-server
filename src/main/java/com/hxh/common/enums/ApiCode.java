package com.hxh.common.enums;

import com.hxh.common.ICommonEnum;
import lombok.AllArgsConstructor;

/**
 * @author: hxh
 * @date: create in 2018/2/28
 */
@AllArgsConstructor
public enum ApiCode implements ICommonEnum {
    /**
     * 枚举
     */
    SUCCESS(2000, "操作成功");
    private int value;

    private String name;

    @Override
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

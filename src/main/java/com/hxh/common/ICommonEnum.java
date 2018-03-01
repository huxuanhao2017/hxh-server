/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2016-2017. All rights reserved.
 */

package com.hxh.common;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/**
 * 常规枚举类
 * 对app来说 这些信息都会以name,value为key的json展示
 * @author guomw
 */
@JsonSerialize(converter = EnumJsonSerializer.class)
public interface ICommonEnum {
	/**
	 * code
	 * @return
	 */
	int getValue();

	/**
	 * name
	 * @return
	 */
	String getName();

}



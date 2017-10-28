package com.msj.product.util;

//字符创相关的工具类
public class StringUtils {

	//构造器私有化,防止外界通过调用构造器创建对象
	private StringUtils() {
	}

	public static boolean hasLength(String value) {
		return value != null && !"".equals(value.trim());
	}
}

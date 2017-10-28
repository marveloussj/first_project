package com.method;

import java.lang.reflect.Modifier;

public final class OtherAPIDemo {
	public static void main(String[] args) {
		Class clz=OtherAPIDemo.class;
		int mod=clz.getModifiers();
		String m=Modifier.toString(mod);
		System.out.println(m);
		System.out.println(OtherAPIDemo.class.getName());
	}

}

package com.object;

import java.io.Serializable;

public class Usera implements Serializable {
	private String name;
	private String sex;
	private int age;
	public Usera(String name, String sex, int age) {
	
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	public String toString() {
		return "Usera [name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}

}

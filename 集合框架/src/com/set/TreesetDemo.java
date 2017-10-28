package com.set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Person implements Comparable<Person> {
	 String name;
	 int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	public int compareTo(Person o) {
		if(this.age>o.age){
			return 1;
		}else if(this.age<o.age){
			return -1;
		}
		
		return 0;
	}
	}
	class Namelengthcomparetor implements Comparator<Person>{

		
		public int compare(Person o1, Person o2) {
			if(o1.name.length()>o2.name.length()){
				return 1;
			}else if(o1.name.length()<o2.name.length()){
				return -1;
			}
			else{
				if(o1.age>o2.age){
					return 1;
				}else if(o1.age<o2.age){
					return -1;
				}
				return 0;
			}
			
		}
		
	}
	

public class TreesetDemo {
	
	public static void main(String[] args) {
		Set<Person> set =new TreeSet<>();
		set.add(new Person("…ÚΩ‹", 18));
		set.add(new Person("…Ú", 19));
		set.add(new Person("…ÚΩ‹Ω‹", 22));
		set.add(new Person("…ÚΩ‹Ω‹Ω‹", 21));
		System.out.println(set);
		System.out.println("----------------------------------");
		Set<Person> set2 =new TreeSet<>(new Namelengthcomparetor());
		set2.add(new Person("…ÚΩ‹", 18));
		set2.add(new Person("…Ú“ª", 19));
		set2.add(new Person("…ÚΩ‹Ω‹", 22));
		set2.add(new Person("…ÚΩ‹Ω‹Ω‹", 21));
		System.out.println(set2);
	}
}

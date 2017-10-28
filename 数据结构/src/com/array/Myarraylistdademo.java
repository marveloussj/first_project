package com.array;

public class Myarraylistdademo {
	public static void main(String[] args) {
		 Myarraylist sj=new Myarraylist();
	System.out.println(sj.isEmpty());
		 sj.add("m");
		 sj.add("a");
		 sj.add("r");
		 sj.add("v");
		 sj.add("e");
		 sj.add("l");
		 sj.add("o");
		 sj.add("u");
		 sj.add("s");
		 sj.delete(5);
		 System.out.println(sj.isEmpty());
		 System.out.println(sj);
		 System.out.println(sj.size());
		 sj.clear();
		 System.out.println(sj);
	}
 
}

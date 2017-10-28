package com.simplefactory;

public class CapFactory {
 public static CreateCap createBlueCap(){
	 return new BlueCap();
 }
 public static CreateCap createRedCap(){
	 return new RedCap();
 }
}

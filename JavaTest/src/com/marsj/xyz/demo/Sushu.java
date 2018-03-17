package com.marsj.xyz.demo;

public class Sushu {
	public static void main(String[] args){ 
		int flag,i,j;
		for(i=2;i<=100;i++){ 
			flag=1; 
			for(j=2;j<i;j++){
				if(i%j==0){
			flag=0;
			break;
			} 
		} 
		if(flag==1)System.out.println(i);}}
}

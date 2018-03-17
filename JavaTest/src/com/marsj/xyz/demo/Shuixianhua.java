package com.marsj.xyz.demo;

public class Shuixianhua {
	public static void main(String[] args) {
		int i,j,k,n;
		  
		 for(i=1;i<10;i++)
		  for(j=0;j<10;j++)
		   for(k=0;k<10;k++)
		   {
		    n=i*100+j*10+k;
		    if((i*100+j*10+k)==((i*i*i)+(j*j*j)+(k*k*k)))
		  System.out.println(n);
	}

}}

package com.array;

import java.util.Arrays;

public class Myarraylist {
	private Object[] elements =null;
	private  int size=0;
	private static final int zongshu=10;
public Myarraylist() {
	this(10);
}

		public   Myarraylist (int chushizhi){
			if(chushizhi<0){ 
				throw new IllegalArgumentException("初始容量不能小于0");
			}
			elements = new Object[chushizhi];
		}



		public  void add(Object playersnum){
			if(size==elements.length){
				elements=Arrays.copyOf(elements, elements.length*2);
			}
			
			
			elements[size]=playersnum;
			size++;
		}
		//查找索引，给出对应的球衣号
		public  Object get(int i) {
			if(i<0||i>size){
				throw new IllegalArgumentException("越界");
			}
		return elements[i];
		}
		  //反得到
		public  int fanget(Object i) {
			for (int j = 0; j < size; j++) {
				if(elements[j].equals(i)){
					return j;
				}
				
			}
			return -1;
		}

		public  void set(int i, Object j) {
			if(i<0||i>size){
				throw new IllegalArgumentException("越界");
			}
			// TODO Auto-generated method stub
			elements[i]=j;
		}


		public  void update(Object i, Object j) {
			// TODO Auto-generated method stub
			/*for (int j2 = 0; j2 < size; j2++) {
				if(players[j2]==i){
					players[j2]=j;
				}}*/
				int a=fanget(i);
				if(a>=0){
					set(a,j);
					
			}
			
		}

		public  void delete(int i) {
			if(i<0||i>size){
				throw new IllegalArgumentException("越界");
			}
			// TODO Auto-generated method stub
			for (int j = i; j < size-1; j++) {
				elements[j]=elements[j+1];
				}
			elements[size-1]=null;
				size--;
		}

		public  String toString() {
			if(elements ==null)
			{
				return "null";
			}
			if(size==0){
				return "[]";
			}
			StringBuilder sj=new StringBuilder(size*3-1);
			sj.append("[");
			for (int i = 0; i < size; i++) {
				sj.append(elements[i]);
				if(i != size-1){
					sj.append(",");
				}
				else{
					sj.append("]");
				}
			}
			
			return sj.toString();
		}

		public int size() {
			// TODO Auto-generated method stub
			return size;
		}

		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return size==0;
		}

		public void clear() {
			// TODO Auto-generated method stub
			elements= new Object[zongshu];
			size=0; 	
			
		}
}

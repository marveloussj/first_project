package com.array;

import java.util.Arrays;
public class Playerslist {
	
		
	public static Integer[] players =null;
	public static int size=0;


		public static void chushihua(int chushizhi){
			if(chushizhi<0){
				throw new IllegalArgumentException("初始容量不能小于0");
			}
			players = new Integer[chushizhi];
		}



		public static void add(Integer playersnum){
			if(size==players.length){
				players=Arrays.copyOf(players, players.length*2);
			}
			
			
			players[size]=playersnum;
			size++;
		}
		//查找索引，给出对应的球衣号
		public static Integer get(int i) {
			if(i<0||i>size){
				throw new IllegalArgumentException("越界");
			}
		return players[i];
		}
		  //反得到
		public static int fanget(int i) {
			for (int j = 0; j < size; j++) {
				if(players[j].equals(i)){
					return j;
				}
				
			}
			return -1;
		}

		public static void set(int i, Integer j) {
			if(i<0||i>size){
				throw new IllegalArgumentException("越界");
			}
			// TODO Auto-generated method stub
			players[i]=j;
		}


		private static void update(Integer i, Integer j) {
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

		private static void delete(int i) {
			if(i<0||i>size){
				throw new IllegalArgumentException("越界");
			}
			// TODO Auto-generated method stub
			for (int j = i; j < size-1; j++) {
				players[j]=players[j+1];
				}
			players[size-1]=null;
				size--;
		}

		public static void printf(){
			if(players ==null)
			{
				System.out.println("null");
			}
			if(size==0){
				System.out.println("[]");
			}
			StringBuilder sj=new StringBuilder(size*3-1);
			sj.append("[");
			for (int i = 0; i < size; i++) {
				sj.append(players[i]);
				if(i != size-1){
					sj.append(",");
				}
				else{
					sj.append("]");
				}
			}
			
			System.out.println(sj.toString());
		}
}

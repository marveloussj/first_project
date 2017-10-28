package com.arraycopy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCopyDemo {
	public static void main(String[] args) {
		int[] one =new int[]{4,4,6,4,5,4,3,8,4};
		int[] two =new int[10];
		System.out.println(Arrays.toString(two));
		arraycopy(one,6,two,3,3);
		System.out.println(Arrays.toString(two));
	}
	

	private static void arraycopy(int[] one, int i, int[] two, int j, int length) {
	for (int index = i; index < i+length; index++) {
		Object a=Array.get(one, index);
		Array.set(two, j, a);
		j++;
	}
	}

	
}
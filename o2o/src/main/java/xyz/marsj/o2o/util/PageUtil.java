package xyz.marsj.o2o.util;

public class PageUtil {
	public static int calculateRowIndex(int pageIndex,int pageSize){
		return (pageIndex>0)?(pageIndex-1)*pageSize:0;
	}
}

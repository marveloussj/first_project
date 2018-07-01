package interview.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {
public void combinations(List<Integer> selected,List<Integer> data,int n){
	if(n==0){
		for (Integer i : selected) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
		return;
	}
	if(data.isEmpty()){
		return;
	}
	//选取
	selected.add(data.get(0));
	combinations(selected,data.subList(1, data.size()),n-1);
	//未选取
	selected.remove(selected.remove(selected.size()-1));
	combinations(selected,data.subList(1, data.size()),n);
}
	
public static void main(String[] args) {
	Combinations c=new Combinations();
	c.combinations(new ArrayList<>(), Arrays.asList(1,2,3,4), 2);
}
}

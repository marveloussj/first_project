package interview.opp.linkedlist;

public class Tester {
public static void main(String[] args) {
	LinkedList<Integer> list=LinkedList.createEmptyList();
	for(int i=0;i<100;i++){
		list.add(i);
	}
	for (Integer i : list) {
	System.out.println(i);	
	}
	
	LinkedList<String> stringList=LinkedList.createEmptyList();
	StringBuilder sb=new StringBuilder();
	for(int i=0;i<100;i++){
		sb.append("a");
		stringList.add(sb.toString());
	}
	for (String i : stringList) {
	System.out.println(i);	
	}
}
}

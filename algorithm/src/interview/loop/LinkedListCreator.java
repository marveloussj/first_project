package interview.loop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedListCreator {
	public Node createLinkedList(List<Integer> data){
		if(data.isEmpty()){
			return null;
		}
		Node firstNode=new Node(data.get(0));
		Node nextNode = createLinkedList(data.subList(1, data.size()));
		firstNode.setNext(nextNode);
		return firstNode;
		
	}
	public static void printNode(Node head){
		while(head!=null){
			System.out.print(head.getValue());
			head=head.getNext();
		}
		System.out.println();
	}
public static void main(String[] args) {
	LinkedListCreator creator=new LinkedListCreator();
	printNode(creator.createLinkedList(new ArrayList<>()));
	printNode(creator.createLinkedList(Arrays.asList(1)));
	printNode(creator.createLinkedList(Arrays.asList(1,2,3,4,5)));
}
}

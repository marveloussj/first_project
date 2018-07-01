package interview.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class LinkedListReverser {
	public Node reverseLinkedList(Node head){
		if(head==null||head.getNext()==null){
			return head;
		}
		Node newHead = reverseLinkedList(head.getNext());
		head.getNext().setNext(head);
		head.setNext(null);
		return newHead;
	}
	public static void printNode(Node head){
		while(head!=null){
			System.out.print(head.getValue());
			head=head.getNext();
		}
		System.out.println();
	}
public static void main(String[] args) {
	LinkedListReverser reverser=new LinkedListReverser();
	LinkedListCreator creator=new LinkedListCreator();
	Node node1=creator.createLinkedList(new ArrayList<>());
	Node node2=creator.createLinkedList(Arrays.asList(1));
	Node node3=creator.createLinkedList(Arrays.asList(1,2,3,4,5));
	printNode(reverser.reverseLinkedList(node1));
	printNode(reverser.reverseLinkedList(node2));
	printNode(reverser.reverseLinkedList(node3));
}
}

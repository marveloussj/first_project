package interview.loop;

import java.util.Arrays;

public class LinkedListDelete {
	public Node deleteIfLinkedList(Node head,int value){
			Node currentNode=head;
			Node preNode=new Node(-1);
			Node virtualNode=preNode;
			preNode.setNext(currentNode);
			while(currentNode!=null){
				Node next=currentNode.getNext();
				if(currentNode.getValue()==value){
					preNode.setNext(next);
					currentNode=next;
				}else{
					preNode=currentNode;
				currentNode=next;
				}
			}
			return virtualNode.getNext();
	}
	public static void printNode(Node head){
		while(head!=null){
			System.out.print(head.getValue());
			head=head.getNext();
		}
		System.out.println();
	}
public static void main(String[] args) {
	LinkedListDelete reverser=new LinkedListDelete();
	LinkedListCreator creator=new LinkedListCreator();
	Node node1=creator.createLinkedList(Arrays.asList(2,2,1,2,4,6));
	Node node2=creator.createLinkedList(Arrays.asList(1,2,1,2,1,1));
	Node node3=creator.createLinkedList(Arrays.asList(1,2,3,4,4));
	printNode(reverser.deleteIfLinkedList(node1,2));
	printNode(reverser.deleteIfLinkedList(node2,1));
	printNode(reverser.deleteIfLinkedList(node3,4));
}
}

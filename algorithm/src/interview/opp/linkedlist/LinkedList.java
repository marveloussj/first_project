package interview.opp.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class  LinkedList<T> implements Iterable<T>{
	private Node<T> head;
	private Node<T> tail;
	public static <T> LinkedList<T> createEmptyList(){
		return new LinkedList<>();
	}
	
	private LinkedList() { 
		this.head=null;
		this.tail=null;
	}
	
	public void add(T value) {
		Node<T> node=new Node<T>(value);
		if(tail==null){
			head=node;
		}else{
			tail.setNext(node);
		}
		tail=node;		
	}
	
	class ListIterator implements Iterator<T>{
		Node<T> currentNode;
		public ListIterator(Node<T> node) {
			currentNode=node;
		}
		@Override
		public boolean hasNext() {
			return currentNode!=null;
		}

		@Override
		public T next() {
			if(currentNode==null){
				throw new NoSuchElementException();
			}
			T value = currentNode.getValue();
			currentNode=currentNode.getNext();
			return value;
		}	
	}
	@Override
	public Iterator<T> iterator() {
		ListIterator listIterator=new ListIterator(head);
		return listIterator;
	}



}

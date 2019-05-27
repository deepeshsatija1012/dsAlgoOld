package linkedlist;

import java.util.Iterator;

public class LinkedList<V> implements Iterable<V>{
	
	private static class Node<V>{
		V value;
		Node<V> next;
		
		public Node(V value){
			this.value = value;
		}
	}
	
	private Node<V> head;
	
	public LinkedList(LinkedList<V> list){
		for(V value : list){
			this.addNode(value);
		}
	}
	
	public LinkedList(LinkedList<V> list, int len){
		int count = 0;
		Iterator<V> it = list.iterator();
		while(it.hasNext() && count<len){
			this.addNode(it.next());
			count++;
		}
	}
	
	public LinkedList() {
	}

	public void addNode(V value){
		head = addNode(head, value);
	}
	
	private Node<V> addNode(Node<V> node, V value){
		if(node==null){
			return new Node<V>(value);
		}
		node = addNode(node.next, value);
		return node;
	}
	
	public LinkedList<V> reversedList(Node<V> head){
		LinkedList<V> l = new LinkedList<V>();
		reverseList(l, head);
		return l;
	}
	
	private void reverseList(LinkedList<V> src, Node<V> node){
		if(node==null){
			return;
		}
		reverseList(src, node.next);
		src.addNode(node.value);
	}

	@Override
	public Iterator<V> iterator() {
		return new ListIterator<V>(head);
	}
	
	private static class ListIterator<V> implements Iterator<V>{

		private Node<V> root;
		
		public ListIterator(Node<V> root){
			this.root = root;
		}
		
		@Override
		public boolean hasNext() {
			return root!=null;
		}

		@Override
		public V next() {
			V value = root.value;
			root = root.next;
			return value;
		}

		@Override
		public void remove() {
			
		}
		
	}
}
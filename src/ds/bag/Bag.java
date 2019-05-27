package ds.bag;

import java.util.Arrays;
import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
	public String toString(){
		StringBuilder builder = new StringBuilder();
		for(Item i : this){
			builder.append(i.toString()+ "  ");
		}
		return builder.toString();
	}
	private static class Node<Item>{
		Item item;
		Node<Item> next;
	}
	
	private Node<Item> head;
	private int count = 0;
	
	public void add(Item x){
		if(head==null){
			head = new Node<>();
			head.item = x;
		}else{
			Node<Item> tempHead = head;
			Node<Item> t = new Node<>();
			t.item = x;
			t.next = tempHead;
			head = t;
		}
		increamentCount();
	}
	
	private void increamentCount(){
		count++;
	}

	@Override
	public Iterator<Item> iterator() {
		Node<Item> tempHead = head;
		return new BagIterator<Item>(tempHead);
	}
	
	private static class BagIterator<Item> implements Iterator<Item>{
		private Node<Item> head;
		
		public BagIterator(Node<Item> head){
			this.head = head;
		}
		
		
		@Override
		public boolean hasNext() {
			return head!=null;
		}

		@Override
		public Item next() {
			Node<Item> t = head;
			head = head.next;
			return t.item;
		}

		@Override
		public void remove() {
			
		}
	}
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[]{1,2,3,4,5};
		System.out.println(Arrays.toString(arr));
		Bag<Integer> bag = new Bag<>();
		for(Integer i : arr){
			bag.add(i);
		}
		
		for(Integer i : bag){
			System.out.print(i+" ");
		}
		
		
	}
}

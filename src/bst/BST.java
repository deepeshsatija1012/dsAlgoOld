package bst;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BST<Key extends Comparable<Key>, Value> {
	private Node<Key, Value> root;
	
	/**
	 * Insert key and value in BST
	 * @param k
	 * @param v
	 */
	public void put(Key k, Value v){
		put(root, k, v);
	}
	
	private Node<Key, Value> put(Node<Key, Value> x, Key k, Value v){
		if(x==null) return new Node<Key, Value>(k, v, 1);
		int cmp = k.compareTo(x.key);
		
		if(cmp<0) x.left = put(x.left, k, v);
		else if(cmp>0) x.right = put(x.right, k ,v);
		else x.value = v;
		
		x.count = 1+size(x.left)+size(x.right);
		
		return x;
	}
	
	public boolean contains(Key key){
		return contains(root, key);
	}
	
	private boolean contains(Node<Key, Value> x, Key key){
		if(x==null) return false;
		int cmp = key.compareTo(x.key);
		if(cmp<0) return contains(x.left, key);
		else if(cmp>0) return contains(x.right, key);
		else return true;
	}
	
	/**
	 * Search number of keys in range lo to high
	 * 
	 *  Printing the keys is easy 
	 *  1. Search in left subtree if any of them could fall in range
	 *  2. Check key in current node
	 *  3. Search in right subtree if any of them could fall in range
	 * @param lo
	 * @param hi
	 * @return
	 */
	public int size(Key lo, Key hi){
		if(contains(hi)) return rank(hi) - rank(lo) + 1;
		else return rank(hi) - rank(lo);
	}
	
	/**
	 * Return number of keys less than K
	 * @param k
	 * @return
	 */
	public int rank(Key k){
		return rank(root, k); 
	}
	
	public int rank(Node<Key, Value> x, Key k){
		if(x==null) return 0;
		
		int cmp = k.compareTo(x.key);
		
		if(cmp<0) return rank(x.left, k);
		else if(cmp>0) return 1+size(x.left)+rank(x.right, k);
		else return size(x.left);
	}
	
	
	/**
	 * returns size of BST
	 * @return
	 */
	public int size(){
		return size(root);
	}
	
	/**
	 * return size of node x
	 * @param x
	 * @return
	 */
	public int size(Node<Key, Value> x){
		if(x==null) return 0;
		return x.count;
	}
	
	public Node<Key, Value> min(Node<Key, Value> x){
		while(x.left!=null){
			x = x.left;
		}
		return x;
	}
	
	
	/**
	 * retrieve value
	 * @param k
	 * @return
	 */
	public Value get(Key k){
		Node<Key, Value> x = root;
		while(x!=null){
			int cmp = k.compareTo(x.key);
			
			if(cmp<0) x = x.left;
			else if(cmp>0) x = x.right;
			else return x.value;
		}
		return null;
	}
	
	/**
	 * return key less than or equal to k
	 * @param k
	 * @return
	 */
	public Key floor(Key k){
		Node<Key, Value> x = floor(root, k);
		if(x!=null) return x.key;
		else return null;
	}
	
	private Node<Key, Value> floor(Node<Key, Value> x , Key k){
		if(x==null) return null;
		
		int cmp = k.compareTo(x.key);
		
		if(cmp==0){
			return x;
		}
		
		if(cmp<0){
			return floor(x.left, k);
		}
		
		Node<Key, Value> t = floor(x.right, k);
		if(t!=null) return t;
		else return null;
		
		
	}
	
	public void deleteMin(){
		root = deleteMin(root);
	}
	
	private Node<Key, Value> deleteMin(Node<Key, Value> x){
		if(x.left==null) return x.right;
		x.left = deleteMin(x.left);
		x.count = 1+size(x.left) + size(x.right);
		return x;
	}
	
	public Node<Key, Value> delete(Key k){
		return delete(root, k);
	}
	
	private Node<Key, Value> delete(Node<Key, Value> x, Key k){
		if(x==null) return null;
		int cmp = k.compareTo(x.key);
		if(cmp<0) x.left = delete(x.left, k);
		else if(cmp>0) x.right = delete(x.right, k);
		else{
			if(x.right==null) return x.left;
			
			Node<Key, Value> t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.right;
		}
		x.count = size(x.left)+size(x.right)+1;
		return x;
	}
	
	public Iterable<Key> iterator(){
		List<Key> queue = new ArrayList<>();
		inorder(root, queue);
		return queue;
	}
	
	private void inorder(Node<Key, Value> x, Collection<Key> queue){
		if(x==null) return;
		inorder(x.left, queue);
		queue.add(x.key);
		inorder(x.right, queue);
	}
}

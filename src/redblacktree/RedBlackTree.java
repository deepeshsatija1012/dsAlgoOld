package redblacktree;

import bst.BST;

public class RedBlackTree<Key extends Comparable<Key>, Value> extends BST<Key, Value> {
	
	private Node<Key, Value> root;
	
	public boolean isRed(Node<Key, Value> node){
		if(node==null) return false;
		return node.color == Color.BLACK;
	}
	
	public void put(Key key, Value value){
		put(root, key, value);
	}
	
	private Node<Key, Value> put(Node<Key, Value> node, Key key, Value value){
		if(node==null) return new Node<Key, Value>(key, value);
		
		int cmp = key.compareTo(node.k);
		if(cmp<0) node.left = put(node.left, key, value);
		else if(cmp>0) node.right = put(node.right, key, value);
		else node.v = value;
		
		
		if(isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);
		if(isRed(node.left) && isRed(node.left.left)) node = rortateRight(node);
		if(isRed(node.left) && isRed(node.right)) flipColor(node);
		
		return node;
	}
	
	
	private Node<Key, Value> rotateLeft(Node<Key, Value> h){
		Node<Key, Value> x = h.right;
		h.right = x.left;
		x.color = h.color;
		h.color = Color.RED;
		return x;
	}
	
	private Node<Key, Value> rortateRight(Node<Key, Value> h){
		Node<Key, Value> x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = Color.RED;
		return x;
	}
	
	private void flipColor(Node<Key, Value> h){
		h.color=Color.RED;
		h.left.color=Color.BLACK;h.right.color=Color.BLACK;
	}

}

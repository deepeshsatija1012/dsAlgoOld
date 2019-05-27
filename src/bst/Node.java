package bst;

public class Node<Key extends Comparable<Key>, Value> {
	Key key;
	Value value;
	int count;
	Node<Key, Value> left, right;
	public Node(Key k, Value v, int c){
		key = k;
		value = v;
		count = c;
	}

}

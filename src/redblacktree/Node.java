package redblacktree;

public class Node<Key extends Comparable<Key>, Value> {
	Key k;
	Value v;
	Color color;
	Node<Key, Value> left, right;
	public Node(Key k, Value v){
		this.k = k;
		this.v = v;
		this.color = Color.RED;
	}
	
}

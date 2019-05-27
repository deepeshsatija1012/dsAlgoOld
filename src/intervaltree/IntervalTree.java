package intervaltree;

public class IntervalTree<Key extends Comparable<Key>, Value> {
	private static class Node<Key extends Comparable<Key>, Value>{
		Key lo, hi;
		Value value;
		Key maxEndPoint; //Max high in the subtree
		Node<Key, Value> left, right;
	}
	Node<Key, Value> root;
	
	public void put(Key lo, Key hi, Value value){
		put(root, lo, hi, value);
	}
	
	private Node<Key, Value> createNode(Key lo, Key hi, Value val){
		Node<Key, Value> n = new Node<>();
		n.hi = hi; n.lo = lo; n.value=val; n.maxEndPoint = hi;
		return n;
	}
	
	private Node<Key, Value> put(Node<Key, Value> node, Key lo, Key hi, Value val){
		if(node==null) return node = createNode(lo, hi, val);
		if(lo.compareTo(node.lo)<0) node.left = put(node.left, lo, hi, val);
		else if(lo.compareTo(node.lo)>0) node.right = put(node.right, lo, hi, val);
		
		return node;
	}
	
}

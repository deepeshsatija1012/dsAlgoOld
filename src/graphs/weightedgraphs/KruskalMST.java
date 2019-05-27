package graphs.weightedgraphs;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

import unionfind.QuickUnionUF;

public class KruskalMST{

	private Queue<Edge> mst = new ArrayDeque<>();
	
	/**
	 * Algorithm :
	 * Sort the edges on Weights
	 * then check if there is a cycle by checking if the UnionFind says that U and V are connected
	 * if they are not connected , i.e., they don't form a cycle add o MST  
	 * @param G
	 */
	public KruskalMST(EdgeWeightedGraph G) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for(Edge e : G.edges()){
			pq.add(e);
		}
		
		//Used for finding cycles
		QuickUnionUF uf = new QuickUnionUF(G.V());
		while(!pq.isEmpty() && mst.size()<G.V()-1){
			Edge e  = pq.poll();
			int v = e.either(); int w = e.other(v);
			if(!uf.connected(v, w)){
				uf.union(v, w);
				mst.add(e);
			}
		}
	}
	
	public Iterable<Edge> edges(){
		return mst;
	}

}

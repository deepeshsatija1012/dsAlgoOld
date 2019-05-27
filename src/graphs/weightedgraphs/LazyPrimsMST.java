package graphs.weightedgraphs;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class LazyPrimsMST {
	private boolean[] marked;
	private Queue<Edge> mst = new ArrayDeque<>();
	PriorityQueue<Edge> pq = new PriorityQueue<>();

	public LazyPrimsMST(EdgeWeightedGraph G) {
		marked = new boolean[G.V()];
		for(int i =0;i<G.V();i++){
			marked[i] = false;
		}
		
		for(int i=0;i<G.V();i++){
			if(!marked[i]) prim(G, i);
		}
	}
	
	private void prim(EdgeWeightedGraph G, int s){
		visit(G, s);
		
		while(!pq.isEmpty()){
			Edge e = pq.remove();
			int v = e.either(); int w = e.other(v);
			if(marked[v] && marked[w]) continue;
			mst.add(e);
			if(!marked[v]) visit(G, v);
			if(!marked[w]) visit(G, w);
		}
		
	}
	
	private void visit(EdgeWeightedGraph G, int v){
		marked[v] = true;
		for(Edge e : G.adj(v)){
			if(!marked[e.either()]){
				pq.add(e);
			}
		}
	}
	
	public Iterable<Edge> edges(){
		return mst ;
	}

}

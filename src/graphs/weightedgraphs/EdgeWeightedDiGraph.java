package graphs.weightedgraphs;

import java.util.ArrayList;
import java.util.List;

import ds.bag.Bag;

public class EdgeWeightedDiGraph {
	
	protected int V, E;
	protected Bag<DirectedEdge>[] adj;
	protected List<DirectedEdge> edgeList = new ArrayList<>();
	
	@SuppressWarnings("unchecked")
	public EdgeWeightedDiGraph(int V){
		this.V = V;
		adj = (Bag<DirectedEdge>[])new Bag[V];
		for(int i=0;i<V;i++){
			adj[i] = new Bag<>();
		}
	}

	public void addEdge(DirectedEdge e){
		int v = e.either(); int w = e.other(v);
		this.edgeList.add(e);
		adj[v].add(e);
	}

	public Iterable<DirectedEdge> adj(int v){
		return adj[v];
	}
	
	public Iterable<DirectedEdge> edges(){
		return this.edgeList;
	}
	
	public int V(){
		return V;
	}
	
	public int E(){
		return edgeList.size()*2;
	}
}

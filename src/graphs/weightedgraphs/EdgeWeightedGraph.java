package graphs.weightedgraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ds.bag.Bag;

public class EdgeWeightedGraph {
	protected int V, E;
	protected Bag<Edge>[] adj;
	protected List<Edge> edgeList = new ArrayList<>();
	
	@SuppressWarnings("unchecked")
	public EdgeWeightedGraph(int V){
		this.V = V;
		adj = (Bag<Edge>[])new Bag[V];
		for(int i=0;i<V;i++){
			adj[i] = new Bag<>();
		}
	}
	
	public void addEdge(Edge e){
		int v = e.either(); int w = e.other(v);
		this.edgeList.add(e);
		adj[v].add(e);
		adj[w].add(e);
	}
	
	public Iterable<Edge> adj(int v){
		return adj[v];
	}
	
	public Iterable<Edge> edges(){
		return this.edgeList;
	}
	
	public int V(){
		return V;
	}
	
	public int E(){
		return edgeList.size()*2;
	}

}

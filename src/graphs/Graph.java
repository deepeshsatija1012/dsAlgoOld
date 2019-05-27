package graphs;
import java.util.Arrays;

import ds.bag.Bag;

//TODO : Storing grph in DB

public class Graph {
	private final int V;
	protected Bag<Integer>[] adj;
	
	public Graph(int V){
		this.V = V;
		this.adj = (Bag<Integer>[])new Bag[V];
		for(int v=0 ; v<V ; v++){
			adj[v] = new Bag<Integer>();
		}
	}
	
	public int V(){
		return V;
	}
	
	public void addEdge(int v, int w){
		adj[v].add(w);
		adj[w].add(v);
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	public boolean isCyclic(){
		boolean[] marked = new boolean[V()];
		for(int i=0;i<V();i++){
			marked[i] = false;
		}
		for(int u=0;!marked[u] && u<V();u++){
			if(isCyclicUtil(this, u, -1, marked)){
				return true;
			}
		}
		return false;
	}
	
	private boolean isCyclicUtil(Graph g, int v, int parent, boolean[] marked){
		marked[v] = true;
		
		for(int x : g.adj(v)){
			if(!marked[x]){
				if(isCyclicUtil(g, x, v, marked)){
					return true;
				}
			}else if(x!=parent){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Graph g1 = new Graph(5);
	    g1.addEdge(1, 0);
	    g1.addEdge(0, 2);
	    g1.addEdge(2, 0);
	    g1.addEdge(0, 3);
	    g1.addEdge(3, 4);
	    
	    Graph g = new Graph(7);
	    g.addEdge(0, 1);
	    g.addEdge(1, 2);
	    g.addEdge(2, 3);
	    g.addEdge(3, 4);
	    g.addEdge(4, 5);
	    g.addEdge(5, 6);
	    
	    System.out.println(g.isCyclic());
	    
	    System.out.println(g1.isCyclic());
	    
	    Bipartite bp = new Bipartite(g1);
	    System.out.println(bp.isBipartite());
	    System.out.println(Arrays.toString(bp.getSets()));
	    bp = new Bipartite(g);
	    System.out.println(bp.isBipartite());
	    System.out.println(Arrays.toString(bp.getSets()));
	    
	    DiGraph g2 = new DiGraph(4);
	    g2.addEdge(0, 1);
	    g2.addEdge(1, 2);
	    g2.addEdge(2, 3);
	    System.out.println(g2.isCyclic());
	}
}
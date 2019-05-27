package graphs;

import java.util.Stack;

public class DepthFirstSearchPath {
	
	private boolean[] marked;
	private int[] edgeTo;
	private int s;
	
	public DepthFirstSearchPath(Graph g, int s){
		this.s = s;
		marked = new boolean[g.V()];
		edgeTo = new int[g.V()];
		for(int i=0;i<marked.length;i++){
			marked[i] = false;
			edgeTo[i] = 0;
		}
		dfsRecursive(g, s);
	}
	
	private void dfsRecursive(Graph g, int v){
		marked[v] = true;
		for(int w : g.adj(v)){
			if(!marked[w]){
				dfsRecursive(g, w);
				edgeTo[w] = v;
			}
		}
	}
	
	public boolean hasPathTo(int x){
		return marked[x];
	}
	
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		
		Stack<Integer> path = new Stack<>();
		for(int i=v;i!=s;i=edgeTo[i]){
			path.push(i);
		}
		path.push(s);
		return path;
	}

}

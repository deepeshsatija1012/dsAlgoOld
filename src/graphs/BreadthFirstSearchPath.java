package graphs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstSearchPath {
	private boolean[] marked;
	private int[] edgeTo;
	private int[] distTo;
	private int s;
	
	public BreadthFirstSearchPath(Graph g, int s){
		this.s = s;
		marked = new boolean[g.V()];
		edgeTo = new int[g.V()];
		distTo = new int[g.V()];
		for(int i=0;i<marked.length;i++){
			marked[i] = false;
			edgeTo[i] = 0;
			distTo[i] = -1;
		}
		bfs(g, s);
	}
	
	private void bfs(Graph g, int v){
		Queue<Integer> queue =  new ArrayDeque<>();
		int distance = 0;
		marked[v] = true;
		queue.add(v);
		while(!queue.isEmpty()){
			int x = queue.remove();
			for(int t : g.adj(x)){
				if(!marked[t]){
					queue.add(t);
					marked[t] = true;
					edgeTo[t] = v;
					distTo[t] = 1+distTo[v];
				}
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

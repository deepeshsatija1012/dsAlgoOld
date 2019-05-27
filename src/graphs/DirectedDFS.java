package graphs;

public class DirectedDFS {
	private boolean[] marked;
	private int count;
	
	public DirectedDFS(Graph G, int s){
		this.marked = new boolean[G.V()];
		dfs(G, s);
	}
	
	public DirectedDFS(Graph G, Iterable<Integer> sources){
		this.marked = new boolean[G.V()];
		for(int s: sources){
			if(!marked(s)) dfs(G, s);
		}
	}
	
	
	public void dfs(Graph G, int s){
		count++;
		marked[s] = true;
		for(int v:G.adj(s)){
			if(!marked[v]) dfs(G, v);
		}
	}
	
	
	public boolean marked(int v){
		return marked[v];
	}

}

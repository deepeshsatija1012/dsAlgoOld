package graphs;


public class ConnectedComponents {
	
	private boolean[] marked;
	private Integer[] id;
	int count;
	
	public ConnectedComponents(Graph g){
		marked = new boolean[g.V()];
		id = new Integer[g.V()];
		for(int i=0;i<marked.length;i++){
			marked[i] = false;
			id[i] = null;
		}
		buildStructure(g);
	}
	
	public ConnectedComponents(Graph g, Iterable<Integer> itr){
		marked = new boolean[g.V()];
		id = new Integer[g.V()];
		for(int i=0;i<marked.length;i++){
			marked[i] = false;
			id[i] = null;
		}
		buildStructure(g, itr);
	}
	
	private void buildStructure(Graph g){
		for(int i=0; !marked[i] && i<marked.length; i++){
			dfsRecursive(g, i);
			count++;
		}
	}
	
	private void buildStructure(Graph g, Iterable<Integer> itr){
		for(int v : itr){
			if(!marked[v]){
				dfsRecursive(g, v);
				count++;
			}
		}
	}
	
	private void dfsRecursive(Graph g, int v){
		marked[v] = true;
		id[v] = count;
		for(int w : g.adj(v)){
			if(!marked[w]){
				dfsRecursive(g, w);
			}
		}
	}
	
	public boolean isConnected(int v, int w){
		return id[v]==id[w];
	}
	
	/**
	 * Gives number o connected components
	 * @return
	 */
	public int count(){
		return count;
	}
	
	public int id(int v){
		return id[v];
	}

}

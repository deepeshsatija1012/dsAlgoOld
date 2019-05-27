package graphs;

public class DiGraph extends Graph {

	public DiGraph(int V) {
		super(V);
	}
	
	public boolean checkIfStronglyConnected(int u, int v){
		DiGraph gr = reverseDiGraph(this);
		TopologicalSort tsr = new TopologicalSort(gr);
		ConnectedComponents scc = new ConnectedComponents(this, tsr.getTopologicalSortOrder());
		return scc.isConnected(v, u);
	}
	
	private DiGraph reverseDiGraph(DiGraph g){
		DiGraph g1 = new DiGraph(g.V());
		for(int i=0;i<g.V();i++){
			for(int u : g.adj(i)){
				g1.addEdge(u, i);
			}
		}
		return g1;
	}
	
	public void addEdge(int v, int w){
		adj[v].add(w);
	}
	
	public boolean isCyclic(){
		boolean[] m = new boolean[V()];
		Integer cycles = new Integer(0);
		for(int i=0;i<V();i++) m[i]=false;
		for(int i=0;i<V();i++){
			cycleDetDfs(i, i, this, m, cycles);
			m[i] = true;
		}
		return cycles>0;
	}
	
	private void cycleDetDfs(int start, int v, Graph g, boolean[] marked, Integer cycles){
		if(marked[v] && start==v){
			cycles++;
			return;
		}
		
		marked[v] = true;
		for(int u : g.adj(v)){
			cycleDetDfs(start, u, g, marked, cycles);
		}
		marked[v] = false;
	}
	
}

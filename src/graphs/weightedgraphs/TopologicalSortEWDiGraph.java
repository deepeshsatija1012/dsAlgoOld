package graphs.weightedgraphs;

import java.util.Stack;

public class TopologicalSortEWDiGraph {
		public boolean[] marked;
		public Stack<Integer> reverseOrder = new Stack<>();
		
		public TopologicalSortEWDiGraph(EdgeWeightedDiGraph g){
			marked = new boolean[g.V()];
			for(int i=0;!marked[i] && i<g.V(); i++){
				dfs(g, i);
			}
		}
		
		public void dfs(EdgeWeightedDiGraph g, int v){
			marked[v] = true;
			
			for(DirectedEdge e : g.adj(v)){
				if(!marked[e.to()]){
					dfs(g, e.to());
				}
			}
			reverseOrder.push(v);
		}
		
		public Iterable<Integer> getTopologicalSortOrder(){
			return reverseOrder;
		}
}

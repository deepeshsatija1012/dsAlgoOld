package graphs;

import java.util.Stack;


/**
 * Sorts a acyclic Digraph in order of precedence
 * For eg : 0->1, 0->2, 1->2
 * Order : 2, 1, 0, ie, 0 cannot be executed before 1 and 2 are complete  
 * @author pc
 *
 */
public class TopologicalSort {
	
	public boolean[] marked;
	public Stack<Integer> reverseOrder = new Stack<>();
	
	public TopologicalSort(DiGraph g){
		marked = new boolean[g.V()];
		for(int i=0;!marked[i] && i<g.V(); i++){
			dfs(g, i);
		}
	}
	
	public void dfs(DiGraph g, int v){
		marked[v] = true;
		
		for(int w : g.adj(v)){
			if(!marked[w]){
				dfs(g, w);
			}
		}
		reverseOrder.push(v);
	}
	
	public Iterable<Integer> getTopologicalSortOrder(){
		return reverseOrder;
	}
	
	public static void main(String[] args) {
		DiGraph g = new DiGraph(7);
		g.addEdge(0, 5);
		g.addEdge(0, 2);
		g.addEdge(0, 1);
		g.addEdge(3, 6);
		g.addEdge(5, 3);
		g.addEdge(3, 4);
		g.addEdge(5, 4);
		g.addEdge(6, 4);
		g.addEdge(6, 0);
		g.addEdge(3, 2);
		g.addEdge(1, 4);
		
		TopologicalSort sort = new TopologicalSort(g);
		for(int w : sort.reverseOrder){
			System.out.print(w+" ");
		}
	}

}

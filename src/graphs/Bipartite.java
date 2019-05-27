package graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class Bipartite {
	private int[] color;
	private boolean isBipartite = false;
	
	public Bipartite(Graph g){
		color = new int[g.V()];
		for(int i=0;i<g.V();i++){
			color[i] = -1;
		}
		
		
		isBipartite = isBipartite(g);
	}
	
	private boolean isBipartite(Graph g){
		for(int i=0; color[i]==-1 && i<g.V();i++){
			if(!getIsBipartiteUsingBfs(g, i)){
				return false;
			}
		}
		return true;
	}
	
	private boolean getIsBipartiteUsingBfs(Graph g, int v){
		Queue<Integer> queue =  new ArrayDeque<>();
		color[v] = 1;
		queue.add(v);
		
		while(!queue.isEmpty()){
			int x = queue.remove();
			
			for(int t:g.adj(x)){
				if(color[t]==-1){
					color[t] = 1-color[x];
					queue.add(t);
				}else if(color[x]==color[t]){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean isBipartite(){
		return isBipartite;
	}
	
	public int[] getSets(){
		return color;
	}

}

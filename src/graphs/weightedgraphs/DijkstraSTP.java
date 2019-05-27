package graphs.weightedgraphs;

import java.util.Stack;

import ds.bag.IndexMinPQ;

//Does not work for negative wights
//Works for cycle
public class DijkstraSTP extends AbstractShortestPath{
	private DirectedEdge[] edgeTo;
	private double[] distTo;
	private IndexMinPQ<Double> pq;

	public DijkstraSTP(EdgeWeightedDiGraph G, int s) {
		super(G, s);
		pq = new  IndexMinPQ<>(G.V());
		distTo = new double[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		
		for(int v=0;v<G.V();v++){
			distTo[v] =Double.POSITIVE_INFINITY;
		}
		distTo[s] = 0.0;
		
		pq.insert(s, 0D);
		while(!pq.isEmpty()){
			int v = pq.delMin();
			for(DirectedEdge e : G.adj(v)){
				relax(e);
			}
		}
		
	}
	
	private void relax(DirectedEdge e){
		int from = e.from(); int to = e.to();
		if(distTo[to]>distTo[from]+e.getWeight()){
			distTo[to] = distTo[from]+e.getWeight();
			edgeTo[to] = e;
			if(pq.contains(to)){ 
				pq.decreaseKey(to, distTo[to]); // this is done to update the queue with the changed distance from source
			}
			else{ 
				pq.insert(to, distTo[to]);
			}
		}
	}

	@Override
	public double distTo(int v) {
		return distTo[v];
	}

	@Override
	public Iterable<DirectedEdge> pathTo(int v) {
		Stack<DirectedEdge> stack = new Stack<>();
		for(DirectedEdge e = edgeTo[v]; e!=null ; e = edgeTo[e.from()]){
			stack.push(e);
		}
		return stack;
	}

}

package graphs.weightedgraphs;

import graphs.TopologicalSort;

import java.util.Stack;
//Works for negative weights
//does not work for cycles
public class DirectedAcyclicGraphSTP extends AbstractShortestPath {
	private DirectedEdge[] edgeTo;
	private double[] distTo;

	public DirectedAcyclicGraphSTP(EdgeWeightedDiGraph G, int s) {
		super(G, s);
		distTo = new double[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		
		for(int v=0;v<G.V();v++){
			distTo[v] =Double.POSITIVE_INFINITY;
		}
		distTo[s] = 0.0;
		
		TopologicalSortEWDiGraph tp = new TopologicalSortEWDiGraph(G);
		for(int v : tp.getTopologicalSortOrder()){
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

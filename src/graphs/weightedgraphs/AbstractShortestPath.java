package graphs.weightedgraphs;

public abstract class AbstractShortestPath {
	
	public AbstractShortestPath(EdgeWeightedDiGraph G, int s){}
	
	public abstract double distTo(int v);
	
	public abstract Iterable<DirectedEdge> pathTo(int v); 

}

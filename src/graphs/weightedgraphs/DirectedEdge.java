package graphs.weightedgraphs;

public class DirectedEdge extends Edge{

	public DirectedEdge(int v, int w, double weight) {
		super(v, w, weight);
	}
	
	public int from(){
		return super.either();
	}
	
	public int to(){
		return super.other(super.either());
	}

}

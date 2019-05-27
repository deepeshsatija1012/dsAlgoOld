package graphs.weightedgraphs;

public class Edge implements Comparable<Edge>{
	
	private int v, w;
	private double weight;
	
	public Edge(int v, int w, double weight){
		this.v = v; this.w = w; this.weight = weight;
	}
	
	public int either(){
		return this.v;
	}
	
	public int other(int vertex){
		if(vertex==v) return w;
		return v;
	}
	
	public double getWeight(){
		return weight;
	}
	
	public String toString() {
		return null;
	}

	@Override
	public int compareTo(Edge that) {
		if(this.weight>that.weight) return 1;
		if(this.weight<that.weight) return -1;
		return 0;
	}

}

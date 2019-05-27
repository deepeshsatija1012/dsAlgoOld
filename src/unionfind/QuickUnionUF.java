package unionfind;


public class QuickUnionUF extends UF {
	
	public QuickUnionUF(int N) {
		super(N);
	}

	protected int root(int i){
		while(i!=arr[i]) i = arr[i];
		return i;
	}

	@Override
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		arr[i] = j;
	}

	public boolean connected(int p, int q) {
		return root(p)==root(q);
	}

}

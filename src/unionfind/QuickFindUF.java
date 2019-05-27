package unionfind;


public class QuickFindUF extends UF {
	
	public QuickFindUF(int N) {
		super(N);
	}

	@Override
	public void union(int p, int q) {
		int pid = arr[p];
		int qid = arr[q];
		
		for(int i = 0 ; i < N; i++){
			if(arr[i]==pid){
				arr[i] = qid;
			}
		}
	}

	@Override
	public boolean connected(int p, int q) {
		return arr[p] == arr[q];
	}
	
	public static void main(String[] args) {
		QuickFindUF uf = new QuickFindUF(10);
		uf.union(9, 2);
		uf.union(0, 6);
		uf.union(6, 9);
		uf.union(4, 2);
		uf.union(0, 1);
		uf.union(8, 1);
		uf.display();
	}
}

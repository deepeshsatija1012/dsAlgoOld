package unionfind;

import java.util.Arrays;

public class QuickUnion extends QuickUnionUF {
	int[] sz;

	public QuickUnion(int N) {
		super(N);
		sz = new int[N];
		Arrays.fill(sz, 1);
	}
	
	@Override
	protected int root(int i){
		while(i!=arr[i]){
			//makes the tree flat by movin the current to the gradparent
//			arr[i] = arr[arr[i]];
			i = arr[i];
		}
		return i;
	}

	@Override
	public void union(int p, int q) {
		System.out.println("Union "+p+","+q);
		int i = root(p);
		int j = root(q);
		System.out.println("root("+p+")="+i+"->"+sz[i]);
		System.out.println("root("+q+")="+j+"->"+sz[j]);
		//the root of smaller tree becomes child of bigger
		if(sz[i]<sz[j]){
			arr[i] =j;
			sz[j] += sz[i];
		}else{
			arr[j] = i;
			sz[i] += sz[j];
		}
	}
	
	public void displaySize(){
//		System.out.println("Size : " + Arrays.toString(sz));
	}
	
	public static void main(String[] args) {
		QuickUnion uf = new QuickUnion(10);
		uf.union(5,1);
		uf.display();uf.displaySize();
		uf.union(0,7);uf.display();uf.displaySize();
		uf.union(3,9);uf.display();uf.displaySize();
		uf.union(6,8);uf.display();uf.displaySize();
		uf.union(6,0);uf.display();uf.displaySize();
		uf.union(5,2);uf.display();uf.displaySize();
		uf.union(9,1);uf.display();uf.displaySize();
		uf.union(5,7);uf.display();uf.displaySize();
		uf.union(7,4);
		uf.display();uf.displaySize();
	}
}

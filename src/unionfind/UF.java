package unionfind;

import java.util.Arrays;

public abstract class UF {
	
	int N;
	int[] arr;
	
	public UF(int N){
		this.N = N;
		this.arr = new int[N];
		for(int i = 0 ; i < N ; i++){
			arr[i] = i;
		}
	}
	
	public abstract void union(int p, int q);
	
	public abstract boolean connected(int p, int q);
	
	public int[] getArr(){
		return this.arr;
	}
	
	public void display(){
		System.out.println(Arrays.toString(arr));
	}

}

package sorting.problems;

import java.util.Arrays;

public class MinPriorityQueue<K extends Comparable<K>> {
	
	private K[] arr;
	private int N = 0;
	
	public MinPriorityQueue(int size){
		arr = (K[])new Comparable[size+1];
		this.N = 0;
	}
	
	
	
	public void insert(K e){
		arr[++N]=e;
		swim(N);
	}
	
	public K delMin(){
		swap(1,N);
		K min = arr[N--];
		sink(1);
		arr[N+1]=null;
		return min;
	}
	
	private boolean greater(int i, int j){
		return ((Comparable<K>) arr[i]).compareTo(arr[j]) > 0;
	}
	
	private void swap(int i, int j){
		K t=arr[i];arr[i]=arr[j];arr[j]=t;
	}
	
	private void sink(int k){
		while(2*k<=N){
			int j=2*k;
			if(j<N && greater(j, j+1)) j++;
			if(!greater(k,  j)) break;
			swap(k,j);
			k=j;
		}
	}
	
	private void swim(int k){
		while(k>1 && greater(k/2,k)){
			swap(k/2,k);
			k=k/2;
		}
		
	}
	
	public void display(){
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
		Character[] arr = new Character[]{'S','O','R','T','E','X','A','M','P','L','E'};
		MinPriorityQueue<Character> pq = new MinPriorityQueue<>(arr.length);
		for(int i =0;i<arr.length;i++){
			pq.insert(arr[i]);
		}
		pq.display();
	}
	

}

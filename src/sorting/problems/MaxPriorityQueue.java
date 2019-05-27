package sorting.problems;

import java.util.Arrays;


public class MaxPriorityQueue<Key extends Comparable<Key>> {
	private Key[] arr;
	private int N=0;
	
	public MaxPriorityQueue(int N){
		arr = (Key[]) new Comparable[N+1];
	}
	
	private void swim(int k){
		while(k>1 && less(k/2, k)){
			exchange(k/2, k);
			k = k/2;
		}
	}
	
	private void sink(int k){
		while(2*k<=N){
			int j = 2*k;
			if(j<N && less(j,j+1)){
				j=j+1;
			}
			if(!less(k,j)){
				break;
			}
			exchange(k, j);
			k=j;
		}
	}
	
	public void insert(Key key){
		System.out.println("Inserting " + key.toString());
//		if(N==0){
//			arr[N]=key;
//		}else{
//			arr[N]=key;
//			swim(N);
//		}
		arr[++N]=key;
		swim(N);
	}
	
	public Key delMax(){
		exchange(1, N);
		Key max = arr[N--];
		arr[N+1] = null;
		sink(1);
		return max;
	}
	
	private boolean less(int i, int j){
		return arr[i].compareTo(arr[j])<0;
	}
	
	public void display(){
		System.out.println(Arrays.toString(arr));
	}
	
	private void exchange(int i, int j){
		Key temp = arr[i];
		arr[i] = arr[j];
		arr[j] =  temp;
	}
	
	public void HeapSort(Key[] arr){
		this.arr = arr;
		N = this.arr.length-1;
		heapify();
		sort();
	}
	
	public void heapify(){
		int count = this.arr.length/2-1;
		while(count>=0){
			sink(count--);
		}
	}
	
	public void sort(){
		int s = N;
		for(;N>=0;N--){
			exchange(0, N);
			sink(0);
		}
		N = s;
	}
	
	public static void main(String[] args) {
		Character[] arr = new Character[]{'S','O','R','T','E','X','A','M','P','L','E'};
		MaxPriorityQueue<Character> pq = new MaxPriorityQueue<>(arr.length);
		for(int i =0;i<arr.length;i++){
			pq.insert(arr[i]);
		}
		pq.display();
		for(int i =0;i<arr.length;i++){
			System.out.println("Deleted "+pq.delMax());
		}
//		System.out.println("Before Sorrt : " + Arrays.toString(arr));
//		pq.HeapSort(arr);
//		pq.display();
	}
}

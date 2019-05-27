package sorting;

import java.util.Arrays;

public class SortingUtil {
	
	public static boolean less(Comparable v, Comparable w){
		return v.compareTo(w)<0;
	}
	
	public static void exchange(Comparable[] arr, int i, int j) {
		Comparable temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static boolean isSorted(Comparable[] arr) {
		for(int i=1 ; i<arr.length ; i++){
			if(less(arr[i], arr[i-1])){
				return false;
			}
		}
		return true;
	}
	
	public static void SelectionSort(Comparable[] arr) {
		for(int i = 0 ; i<arr.length ; i++){
			int min = i;
			for(int j=i+1;j<arr.length;j++){
				if(less(arr[j], arr[min])){
					min = j;
				}
			}
			exchange(arr	, i, min);
		}
		
	}
	
	public static void InsertionSort(Comparable[] arr) {
		for(int i=1;i<arr.length;i++){
			for(int j=i;j>0;j--){
				if(less(arr[j],arr[j-1])){
					exchange(arr, j, j-1);;
				}else{
					break;
				}
			}
		}
	}
	
	public static void ShellSort(Comparable[] arr) {
		int h=1;
		while(h<arr.length/3){
			h = 3*h+1;
		}
		
		while(h>=1){
			for(int i = h ; i < arr.length ; i++){
				for( int j = i; j>=h && less(arr[j], arr[j-h]); j-=h){
					exchange(arr, j, j-h);
				}
			}
		}
	}
	
	private static void abstractInPlaceMerge(Comparable[] arr, Comparable[] aux, int lo, int mid, int high){
		for(int i=lo;i<=high; i++){
			aux[i] = arr[i];
		}
		
		int i = lo, j=mid+1;
		for(int k=lo;k<=high;k++){
			if(i>mid){
				arr[k] = aux[j++];
			}else if(j>high){
				arr[k] = aux[i++];
			}else if(less(aux[i],aux[j])){
				arr[k] = aux[i++];
			}else{
				arr[k] = aux[j++];
			}
		}
	}
	private static void mergesort(Comparable[] arr, Comparable[] aux, int lo, int high){
		if(lo<high){
		int mid = (lo+high)/2;
		mergesort(arr, aux, lo, mid);
		mergesort(arr, aux, mid+1, high);
		abstractInPlaceMerge(arr, aux, lo, mid, high);
		}
	}
	
	public static void MergeSortWithAux(Comparable[] arr){
		Comparable[] aux = new Comparable[arr.length];
		mergesort(arr, aux, 0, arr.length-1); 
	}
	
	public static void inPlaceMerge(Comparable[] arr, int lo, int mid, int high){
		int i = lo, j=mid+1;
		if(less(arr[mid],arr[j])){
			return;
		}
		
		while(i<=mid && j<=high){
			if(less(arr[i],arr[j])){
				i++;
			}else{
				Comparable temp = arr[j];
				System.arraycopy(arr, i, arr, i+1, j-i);
				arr[i] = temp;
				i++; j++; mid++; 
			}
		}
//		System.out.println("===============================");
//		System.out.println("In Place Merge ");
//		System.out.println("Lo, Mid, High = "+lo+","+mid+","+high);
//		System.out.println(Arrays.toString(arr));
//		
//		System.out.println("===============================");
	}
	
	public static void mergesort(Comparable[] arr, int lo, int high){
		if(lo<high){
		int mid = (lo+high)/2;
//		System.out.println("lo,mid = " +lo+","+mid);
		mergesort(arr, lo, mid);
//		System.out.println("mid+1,high = " +(mid+1)+","+high);
		mergesort(arr, mid+1, high);
//		System.out.println("Merge lo,mi,high = "+lo+","+mid+","+high);
		inPlaceMerge(arr, lo, mid, high);
		}
	}
	
	public static void InPlaceMergeSort(Comparable[] arr) {
		mergesort(arr, 0, arr.length-1);
	}
	
	
	public static int partition(Comparable[] arr, int lo, int high){
		int i = lo, j = high+1;
		while (true){
			while(less(arr[++i], arr[lo])){
				if(i==high) break;
			}
			while(less(arr[lo], arr[--j])){
				if(j==lo) break;
			}
			
			if(i>=j) break;
			System.out.println("i"+i+" j"+j);
			exchange(arr, i, j);
			System.out.println(Arrays.toString(arr));
		}
		
		exchange(arr, lo, j);
		
		return j;
	}
	
	public static void quickSortImpl(Comparable[] arr, int lo, int high){
		if(high<=lo){
			return;
		}
		
		int partition = partition(arr, lo, high);
		System.out.println(Arrays.toString(arr));
		quickSortImpl(arr, lo, partition-1);
		quickSortImpl(arr, partition+1, high);
		
	}
	
	public static void QuickSort(Comparable[] arr){
		quickSortImpl(arr, 0, arr.length-1);
	}
	
	public static void quick3WaySortImpl(Comparable[] arr, int lo, int hi) {
		if(lo>=hi) return;
		
		int lt = lo, gt = hi;
		int i = lo;
		Comparable pvt = arr[lo];
		
		while(i<=gt){
			int cmp = arr[i].compareTo(pvt);
			if(cmp<0){
				exchange(arr, i++, lt++);
			}else if(cmp>0){
				exchange(arr, i, gt--);
			}else{
				i++;
			}
		}
		System.out.println("==============================");
		System.out.println("lo, lt, gt, hi = "+lo+","+lt+","+gt+","+hi);
		System.out.println(Arrays.toString(arr));
		System.out.println("==============================");
		quick3WaySortImpl(arr, lo, lt-1);
		quick3WaySortImpl(arr, gt+1, hi);
	}
	
	public static void Quick3WaySort(Comparable[] arr) {
		quick3WaySortImpl(arr, 0, arr.length-1);
	}
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[]{3,2,4,7,9,1,0,5,8};
		Integer[] arr1 = new Integer[]{3,2,4,7,9,1,0,5,8};
		Integer[] arr2 = new Integer[]{3,2,4,7,9,1,0,5,8};
		Integer[] arr3 = new Integer[]{3,2,4,7,9,1,4,5,8};
		System.out.println(Arrays.toString(arr));
//		MergeSortWithAux(arr);
//		InPlaceMergeSort(arr1);
		QuickSort(arr2);
//		Quick3WaySort(arr3);
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
//		System.out.println(Arrays.toString(arr3));
	}
}

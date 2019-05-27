package sorting.problems;

import java.util.Arrays;

import sorting.SortingUtil;

public class KthSmallest {

	public static void main(String[] args) {
		Integer[] arr = new Integer[]{3,2,4,7,9,1,0,5,8};
		Integer[] arr1 = new Integer[]{3,2,4,7,9,1,0,5,8};
		SortingUtil.QuickSort(arr1);
		int k = 5;
		int lo=0, hi=arr.length-1;
		while(hi>lo){
			int j = SortingUtil.partition(arr, lo, hi);
			if(j<k) {lo = j+1;}
			else if(j>k) {hi = j-1;}
			else {System.out.println(arr[k]);break;}
		}
		System.out.println(Arrays.toString(arr1));
		System.out.println(arr[k]);
	}

}

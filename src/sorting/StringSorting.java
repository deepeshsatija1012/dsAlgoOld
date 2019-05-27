package sorting;

import java.util.Arrays;

/**
 * Sorts the array if the range of array is know.
 * @author pc
 *
 */
public class StringSorting {
	private static final int R = 256;
	
	public static void keyIndexSort(String[] arr, int d){
		
		int[] count = new int[R+1];
		//find frequecny of each key
		for(int i=0;i<arr.length;i++){
			count[charAt(arr[i],d)+1]++;
		}
		
		//find cumulative sum, ie, number of key leass than at index in range
		for(int i=0;i<R;i++){
			count[i+1]+=count[i];
		}
		
		//copy the 
		String[] aux = new String[arr.length];
		for(int i=0;i<arr.length;i++){
			// we are copying the value at count index to auxilarry arraya and increamenting the count vvalue to copy the next
			//value to next index
			//This count basically contains the indices where the value is supposed tobe copied in auxillary array
			aux[count[charAt(arr[i],d)]++] = arr[i];
		}
		
		
		for(int i=0;i<aux.length;i++){
			arr[i] = aux[i];
		}
	}
	
	public static void LSDSort(String[] arr, int W){
		String[] aux = new String[arr.length];
		for(int d=W-1;d>=0;d--){
			int[] count = new int[256+1];
			for(int i=0;i<arr.length;i++){
				count[arr[i].charAt(d)+1]++;
			}
			
			for(int i=0;i<256;i++){
				count[i+1]+=count[i];
			}
			
			for(int i=0;i<arr.length;i++){
				aux[count[arr[i].charAt(d)]++] = arr[i];
			}
			
			for(int i=0;i<arr.length;i++){
				arr[i] = aux[i];
			}
		}
		
	}
	
	
	public static void MSDSort(String[] arr){
		String[] aux = new String[arr.length];
		MSDSort(arr, aux, 0, arr.length, 0);
	}
	
	private static int charAt(String s, int d){
		if(d<s.length()) return s.charAt(d);
		return -1;
	}
	
	private static void MSDSort(String[] arr, String[]aux, int lo, int hi, int d){
		
		if(hi<=lo) return;
		
		int[] count = new int[256+2];
		
		for(int i=lo;i<hi;i++){
			count[charAt(arr[i], d)+2]++;
		}
		
		for(int i=0;i<256+1;i++){
			count[i+1]+=count[i];
		}
		
		for(int i=lo;i<hi;i++){
			aux[count[charAt(arr[i], d)+1]++] = arr[i];
		}
		
		for(int i =lo;i<hi;i++){
			arr[i] = aux[i];
		}
		
		
		for(int i=0;i<256;i++){
			MSDSort(arr, aux, lo+count[i], lo+count[i]-1, d+1);
		}
		
	}
	
	public static void radixQuickSort3Way(String[] arr, int lo, int hi, int d){
		if(hi<=lo) return;
		int lt=lo, gt=hi;
		int v = charAt(arr[lo],d);
		int i=lo+1;
		
		while(i<=gt){
			int t = charAt(arr[i], d);
			if(t<v) exch(arr, i++, lt++);
			else if(t>v) exch(arr, i, gt--);
			else i++;
		}
		
		radixQuickSort3Way(arr, lo, lt-1, d);
		if(v>=0) radixQuickSort3Way(arr, lt, gt, d+1);
		radixQuickSort3Way(arr, gt+1, hi, d);
	}
	
	private static void exch(String[] arr, int i, int j){
		String temp = arr[i]; arr[i]=arr[j]; arr[j] = temp;
	}
	
	
	public static void main(String[] args) {
		System.out.println("==================KeyIndex Sort===================================");
		String[] arr = new String[]{"Namita", "Kanika", "Deepes", "Sudesh", "Ashoka", "Mudias"};
		System.out.println("Before Sort");
		System.out.println(Arrays.toString(arr));
		System.out.println("After Sort");
		keyIndexSort(arr, 1);
		System.out.println(Arrays.toString(arr));
		
		System.out.println("==================LSDSort===================================");
		String[] strArr = new String[]{"Namita", "Kanika", "Deepes", "Sudesh", "Ashoka", "Mudias"};
		System.out.println("Before Sort");
		System.out.println(Arrays.toString(strArr));
		LSDSort(strArr, strArr[0].length());
		System.out.println("After Sort");
		System.out.println(Arrays.toString(strArr));
		System.out.println("==================MSDSort===================================");
		String[] strArr1 = new String[]{"Namita", "Kanika", "Deepes", "Sudesh", "Ashoka", "Mudias"};
		System.out.println("Before Sort");
		System.out.println(Arrays.toString(strArr1));
		MSDSort(strArr1);
		System.out.println("After Sort");
		System.out.println(Arrays.toString(strArr1));
		System.out.println("==================3WayRadixSort===================================");
		String[] strArr2 = new String[]{"Namita", "Kanika", "Deepesh", "Sudesh", "Ashok", "Manav", "Anay"};
		System.out.println("Before Sort");
		System.out.println(Arrays.toString(strArr2));
		radixQuickSort3Way(strArr2, 0, strArr2.length-1, 0);
		System.out.println("After Sort");
		System.out.println(Arrays.toString(strArr2));
		
	}

}

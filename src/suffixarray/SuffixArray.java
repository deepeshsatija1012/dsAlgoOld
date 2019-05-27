package suffixarray;

import sorting.StringSorting;

public class SuffixArray {
	
	private static String[] suffixArray(String s){
		String[] arr = new String[s.length()];
		for(int i=0;i<s.length();i++){
			arr[i] = s.substring(i);
		}
		
		return arr;
	}
	
	private static int longestcommonprefix(String s1, String s2){
		int n = Math.min(s1.length(), s2.length());
		
		for(int i=0;i<n;i++){
			if(s1.charAt(i)!=s2.charAt(i)){
				return i;
			}
		}
		
		return n;
	}
	
// Solution for longest common substring
///http://cs.stackexchange.com/questions/9555/computing-the-longest-common-substring-of-two-strings-using-suffix-arrays
//1) Concatenate on say #
//2) calculate longest common-prefix arr lcp[i] betwenn sorted suffix array arr[i] and arr[i-1]
//3) calc, sa[i] which is the index of the value in sorted array in the unsorted version
//4) get the max lcp[i] such that sa[i] and sa[i] indees fall in the 2 differnet strings
	
//consider A=abcabc and B=bc. 
//Then, S=abcabc#bc. 
//Sorted suffixes are {abc#bc,abcabc#bc,bc,bc#bc,bcabc#bc,c,c#bc,cabc#bc}.
//SA=[4,1,8,5,2,9,6,3,7]    LCP=[-1,3,0,2,2,0,1,1,0]
//Now, the greatest value is LCP[2]=3, but it is for SA[1] and SA[2], both of which start in the string A. 
//So, we ignore that. On the other hand, LCP[4]=2 is for SA[3] (corresponds to the suffix bc of B) and SA[4] (corresponding to 
//suffix bcabc#bc of A). 
//So, this is the longest common substring between the two strings. 
//For getting the actual substring, you take a length 2 (value of the greatest feasible LCP) substring starting from either 
//SA[3] or SA[4], which is bc.

		
	
	public static String longestRepeatingSubstring(String s){
		String[] arr = suffixArray(s);
		
		StringSorting.radixQuickSort3Way(arr, 0, arr.length-1, 0);
		
		String lrs = "";
		for(int i=0;i<arr.length-1;i++){
			int len = longestcommonprefix(arr[i], arr[i+1]);
			if(len>lrs.length()){
				lrs=arr[i].substring(0, len);
			}
		}
		
		return lrs;
	}
	
}

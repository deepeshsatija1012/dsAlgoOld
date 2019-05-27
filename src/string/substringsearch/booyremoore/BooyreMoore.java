package string.substringsearch.booyremoore;

import java.util.Arrays;

public class BooyreMoore {
	
	private int[] arr = new int[256];
	
	private String pattern;
	
	public BooyreMoore(String pat){
		this.pattern = pat;
		
		Arrays.fill(arr, -1);
		
		for(int i=0;i<pat.length();i++){
			arr[pat.charAt(i)] = i;
		}
	}
	
	public int searchIn(String text){
		char[] t = text.toCharArray();
		int skip=0;
		for(int i=0;i<text.length()-pattern.length();i+=skip){
			skip=0;
			for(int j=pattern.length()-1;j>=0;j--){
				if(pattern.charAt(j)!=text.charAt(i+j)){
					skip = Math.max(1, j-arr[text.charAt(i+j)]);
					break;
				}
			}
			if(skip==0) return i;
		}
		return -1;
	}

}

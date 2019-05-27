package string.substringsearch.KnthMorrisPratt;

import java.util.HashMap;
import java.util.Map;

public class KnthMorrisPratt {
	
	private int[][] dfa;
	private String pattern;
	private Map<Character, Integer> charMap = new HashMap<Character, Integer>();
	
	private int getCharIndex(char c){
		if(this.charMap.get(c)==null) System.out.println("Char not found " + c);
		return this.charMap.get(c);
	}
	
	public KnthMorrisPratt(String pattern){
		this.pattern = pattern;
		int index = 0;
		for(int i=0;i<pattern.length();i++){
			if(!charMap.containsKey(pattern.charAt(i))){
				this.charMap.put(pattern.charAt(i), index++);
			}
		}
		
		dfa = new int[this.charMap.size()][pattern.length()];
		
		dfa[getCharIndex(pattern.charAt(0))][0]=1;
		//A:0  B:1  C:2
		for(int X=0, j=1;j<pattern.length();j++){
			for(Map.Entry<Character, Integer> entry : charMap.entrySet()){
				dfa[entry.getValue()][j] = dfa[entry.getValue()][X];
			}
			dfa[getCharIndex(pattern.charAt(j))][j] = j+1;
			//X is used for tracking the state machine for input pattern[1...j] (pattern is a zero index array)
			X = dfa[getCharIndex(pattern.charAt(j))][X];
			
		}
	}
	
	public void display2D(int[][] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			
			for(int j=0;j<arr[0].length;j++)
			{
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	
	private int search(String text){
		int i, j;
		for(i=0,j=0;i<text.length() && j<pattern.length();i++){
			j = dfa[getCharIndex(text.charAt(i))][j];
		}
		
		if(j==pattern.length()) return i-pattern.length();
		return text.length();
	}
	
	public static void main(String[] args) {
		KnthMorrisPratt cmp = new KnthMorrisPratt("ABABAC");
		
		System.out.println(cmp.search("AAAAAABAAABABAC"));
	}
	

}

import java.util.Arrays;

public class PermutationsOfAString {

	public static void permute(int level, String permuted, boolean used[],
			String original) {
		int length = original.length();
		if (level == length) {
			System.out.println(permuted);
		} else {
			for (int i = 0; i < length; i++) {
				System.out.println("USED - " + permuted);
				System.out.println("USEDARR - "+Arrays.toString(used));
				if (!used[i]) {
					used[i] = true;
					permute(level + 1, permuted + original.charAt(i), used,
							original);
					used[i] = false;
				}
			}
		}
	}
	
	public static void permute3(String s){
		permute3help("", s);
	}
	
	private static void permute3help(String a, String s){
		if(s.length()==0){
			System.out.println(a);
		}else{
			for(int i=0;i<s.length();i++){
				permute3help(a+s.charAt(i), s.substring(0, i)+s.substring(i+1, s.length()));
			}
		}
	}
	
	private static void swap(char[] arr, int i, int j){
		char t = arr[i]; arr[i] = arr[j]; arr[j] = t;
	}
	
	public static void permuteRecu(char[] str, int start, int end) {
		if(start==end){
			System.out.println(str);
		}else{
			for(int i=start;i<=end;i++){
				swap(str, i, start);
				permuteRecu(str, start+1, end);
				swap(str, i, start);
				
			}
		}
	}
	
	public static void main(String[] args) {
        String s = "abc";
        boolean used[] = {false, false, false, false, false};
//        permute(0, "", used, s);
        
//        permuteRecu(s.toCharArray(), 0, s.length()-1);
        permute3(s);
    }

}

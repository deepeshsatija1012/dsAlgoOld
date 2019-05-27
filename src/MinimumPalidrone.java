import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinimumPalidrone {

	public static int max(int i, int j) {
		return i >= j ? i : j;
	}

	public static int longestCommmonSubstring(String s1, String s2) {
		int[][] lcp = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					lcp[i][j] = lcp[i - 1][j - 1] + 1;
				} else {
					lcp[i][j] = max(lcp[i - 1][j], lcp[i][j - 1]);
				}
			}
		}
		System.out.println("------LCP------");
		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				System.out.print(lcp[i][j]);
			}
			System.out.println();
		}
		System.out.println("------LCP------");
		return lcp[s1.length()][s2.length()];
	}

	public static String shortestPalindrone(String str) {
		String rev = new StringBuilder(str).reverse().toString();
		print("String " + str + ", Reverse " + rev);
		int len = str.length() - longestCommmonSubstring(str, rev);
		return rev.substring(0, len) + str;
	}

	public static void print(String str) {
		System.out.println(str);
	}

	public static void main(String[] args) {
		getScore("attract");
	}

	public static void permute3(String s, Set<String> palindromes) {
		permute3help("", s, palindromes);
	}

	private static void permute3help(String a, String s, Set<String> palindromes) {
		if (s.length() == 0) {
			if (a.equals(new StringBuilder(a).reverse().toString())) {
				palindromes.add(a);
			}
		} else {
			for (int i = 0; i < s.length(); i++) {
				permute3help(a + s.charAt(i), s.substring(0, i) + s.substring(i + 1, s.length()), palindromes);
			}
		}
	}
	
	static void subsequence(String str, Set<String> st) 
    { 
        for (int i = 0; i < str.length(); i++) { 
              
            for (int j = str.length(); j > i; j--) { 
                String sub_str = str.substring(i, j); 
              
                if (!st.contains(sub_str)) 
                    st.add(sub_str); 
  
                for (int k = 1; k < sub_str.length() - 1; k++) { 
                    StringBuffer sb = new StringBuffer(sub_str); 
  
                    sb.deleteCharAt(k); 
                    if (!st.contains(sb)) 
                        ; 
                    subsequence(sb.toString(), st); 
                } 
            } 
        } 
    } 

	private static List<List<Double>> multiply(List<List<Double>> mat1, List<List<Double>> mat2) {
		int dim = mat1.size();
		List<List<Double>> product = new ArrayList<>();
		for(int i=0;i<dim;i++) {
			product.add(new ArrayList<Double>());
		}
		
        for(int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
            	double sum =0;
                for (int k = 0; k < dim; k++) {
                    sum += mat1.get(i).get(k) * mat2.get(k).get(j);
                }
                product.get(i).add(sum);
            }
        }

        return product;

	}
	
	public static List<List<Double>> power(int n, List<List<Double>> in_A) {
		List<List<Double>> product = multiply(in_A, in_A);
	    for(int i=1;i<n;i++) {
	    	product = multiply(product, in_A);
	    }
	    return product;
	}

	private static Set<String> findpalindrome(String s) {
		TreeMap<String, Integer> m = new TreeMap<>();
		int n = s.length();

		int[][] R = new int[2][n + 1];

		s = "@" + s + "#";

		for (int j = 0; j <= 1; j++) {
			int rp = 0;
			R[j][0] = 0;

			int i = 1;
			while (i <= n) {
				while (s.charAt(i - rp - 1) == s.charAt(i + j + rp))
					rp++;

				R[j][i] = rp;
				int k = 1;
				while ((R[j][i - k] != rp - k) && (k < rp)) {
					R[j][i + k] = Math.min(R[j][i - k], rp - k);
					k++;
				}
				rp = Math.max(rp - k, 0);
				i += k;
			}
		}

		s = s.substring(1, s.length() - 1);

		m.put(s.substring(0, 1), 1);
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= 1; j++)
				for (int rp = R[j][i]; rp > 0; rp--)
					m.put(s.substring(i - rp - 1, i - rp - 1 + 2 * rp + j), 1);
			m.put(s.substring(i, i + 1), 1);
		}

		return m.keySet();
	}

	public static int getScore(String s) {
		Set<String> palindrones = new TreeSet<>();
		permute3(s, palindrones);
		System.out.println(palindrones);
		return -1;
	}
	
	static String electionWinner(String[] votes) {
        Stream.of(votes).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet().stream().collect(Collectors.groupingBy(entry -> entry.getValue()));


    }

}

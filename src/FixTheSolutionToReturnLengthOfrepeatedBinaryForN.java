import java.util.Arrays;

public class FixTheSolutionToReturnLengthOfrepeatedBinaryForN {

	public static void main(String[] args) {
		FixTheSolutionToReturnLengthOfrepeatedBinaryForN f = new FixTheSolutionToReturnLengthOfrepeatedBinaryForN();

		// 1110111011
		// 1110111011
		 System.out.println(f.solution(955));

		// 111011100110101100101000000000
		// System.out.println(f.solution(1000000000));
		int[] A = new int[7];
		A[0] = 1;
		A[1] = 0;
		A[2] = -1;
		A[3] = 1;
		A[4] = 1;
		A[5] = -1;
		A[6] = -1;
		
//		System.out.println(f.sol(A, 2));
	}

	public int solution(int n) {
		int[] d = new int[30];
        int l = 0;
        int p;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }
        for (p = 1; p < (1 + l)/2; ++p) {
            int i;
            boolean ok = true;
            for (i = 0; i < l - p; ++i) {
                if (d[i] != d[i + p]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return p;
            }
        }
        return -1;
	}

	public int sol(int[] A, int S) {
		int[] sumArr = new int[A.length];
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			sumArr[i] = sum;
		}

		int l = -1;

		for (int i = 0; i < sumArr.length; i++) {
			if (sumArr[i] == S && i > l) {
				l = i;
			}
		}

		return l+1;

	}

}

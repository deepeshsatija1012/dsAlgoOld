public class FindIfArrayCanBeSortedWithOneExchange {

	public static void main(String[] args) {
		int[] A = new int[5];
		A[0] = 1;
		A[1] = 3;
		A[2] = 5;
		A[3] = 3;
		A[4] = 7;
		
		FindIfArrayCanBeSortedWithOneExchange f = new FindIfArrayCanBeSortedWithOneExchange();
		
		System.out.println(f.solution(A));
		
	}

	public boolean solution(int[] A) {
		int count =0;
		for(int i=0;i<A.length-1;i++){
			if(A[i+1]<A[i]){
				count++;
				int t = A[i]; A[i]=A[i+1];A[i+1]=t;
			}
		}
		return count==1;
	}

}


public class DPMisc {
	
	public static int waysToWriteN(int N) {
		int[] dp = new int[N+1];
		dp[0] = 1;
		///!!!!!! this is wrong check with suman ******************
		for(int i=1;i<=N;i++) {
			dp[i] = dp[N-i] + dp[i-1];
		}
		return dp[N];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5;
		int ways = waysToWriteN(2);
		System.out.println(ways);

	}

}

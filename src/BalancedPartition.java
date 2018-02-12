
public class BalancedPartition {
	
	public static boolean bpRecursion(int[] a, int i, int k) {
		if(k == 0)
			return true;
		if(i < 0 && k!=0) {
			return false;
		}
		
		return bpRecursion(a, i-1, k-a[i]) || bpRecursion(a, i-1, k);
	}
	
	public static boolean bpDP(int[] a, int k) {
		int n = a.length;
		boolean[][] dp = new boolean[k/2+1][n+1];
		
		for(int i=0;i<k/2;i++) {
			dp[i][0] = false;
		}
		for(int j=0;j<n;j++) {
			dp[0][j] = true;
		}
		for(int i=1;i<=k/2;k++) {
			for(int j=1;j<=n;j++) {
				dp[i][j] = dp[i][j] || dp[i-a[j-1]][j];
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] a = {1, 5, 11, 5};
		int[] a = {1, 5, 2, 10};
		int sum =0;
		for(int i=0;i<a.length;i++)
			sum += a[i];
		if(sum%2 != 0)
			System.out.println("BP doesnt exist");
		else
			System.out.println(bpRecursion(a, a.length-1, sum/2));

	}

}

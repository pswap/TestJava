
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
		int dp[] = new int[n+1];
		dp[0] = a[0]; 
		
		for(int i=0;i<n;i++) {
			dp[i] = k - dp[i-1];
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

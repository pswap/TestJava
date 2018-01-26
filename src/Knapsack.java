
public class Knapsack {
	
	public static int knapSackRecursion(int[] v, int[] w, int W, int n) {
		if(n == 0)  // no more items in value array
			return 0;
		if(W == 0)  // no more space in the bag 
			return 0;
		
		if(w[n-1] > W)
			return knapSackRecursion(v, w, W, n-1);		
		
		return Math.max(knapSackRecursion(v, w, W, n-1), v[n-1] + knapSackRecursion(v, w, W-w[n-1], n-1));
	}
	
	 //Using W (and not w) for column index is because the recursion is a function of #elements of val array and Total wt f(n, W)
	public static int knapSackDp(int[] V, int[] wt, int W) {
		int n = V.length;
		//int m = wt.length;
		
		int[][] dp = new int[n+1][W+1];
			
		for(int i=0;i<=n;i++) {
			for(int w=0;w<=W;w++) {
				if(i==0 || w==0)
					dp[i][w] = 0;
				else if(wt[i-1] > w)
					dp[i][w] = dp[i-1][w];
				else
					dp[i][w] = Math.max(dp[i-1][w], V[i-1] + dp[i-1][w-wt[i-1]]);
			}
		}
		return dp[n][W];
	}
	
	public static int unBoundedKnapsack(int[] V, int[] wt, int W) {
		int[] dp = new int[W+1];
		int n = V.length;
		
		for(int i=0;i<=W;i++) {
			for(int j=0;j<n;j++) {
				if(wt[j] <= i)
					dp[i] = Math.max(dp[i], dp[i-wt[j]]+V[j]);
			}
		}
		return dp[W];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] v= {60, 100, 120};
		//int[] w = {10, 20, 30};
		//int W = 50;
		
		int W = 100;
	    int v[] = {10, 30, 20};
	    int w[] = {5, 10, 15};
		
		int ret = knapSackRecursion(v, w, W, v.length);
		int retdp = knapSackDp(v, w, W);
		int ret2 = unBoundedKnapsack(v, w, W);
		System.out.println(ret);
		System.out.println("ret dp= " + retdp);
		System.out.println("ret dp= " + ret2);
	}

}

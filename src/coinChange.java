//https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
public class coinChange {
	
	//min number of coins to make a given total
	public static int mincoinChangeDp(int[] d, int total) {
		int[] dp = new int[total+1];
		dp[0] = 0;
		
		for(int i=1;i<=total;i++) {
			int min = Integer.MAX_VALUE;
			for(int j=0;j<d.length;j++) {
				// if current denom is less than sum value
				if(d[j] <= i && min > dp[i-d[j]])
					min = dp[i-d[j]];
			}
			dp[i] = min+1;
		}
		return dp[total];
	}
	
	// total ways to make a given total - inclusion/exclusion
	/* 
	 * f(t,i) = 1 if t=0 t is total
	 * 		 = 0 if i == len)denom)
	 * 			= sum from j=i to m-1, f(t-denom[j], j)  
	 * 			=f(t, i+1)  if t<denom[i]
	 * 			= else f(t-denom[i], i) + f(t, i+1) 
	 */
	//https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/CoinChanging.java
	public static int waysCoinChange(int[] d, int total) {
		int[][] dp = new int[d.length+1][total+1];
		// no coins are given, 0 ways to change total
		for(int i=0;i<=total;i++) {
			dp[0][i] = 0;
		}
		// if total=0, only one way to make it ie empty set
		for(int j=0;j<=d.length;j++) {
			dp[j][0] = 1;
		}
		
		for(int i=1;i<=d.length;i++) {
			for(int j=1;j<=total;j++) {
				if(d[i-1] > j)
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j] = dp[i][j-d[i-1]] + dp[i-1][j];

			}
		}
		return dp[d.length][total];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int coins[] = {9, 6, 5, 1};
        //int V = 11;
        int V = 15;
        int coins[] = {3,4,6,7,9};
        System.out.println ( "Minimum coins required is "
                            + mincoinChangeDp(coins, V));
        System.out.println("total ways for the total =" + waysCoinChange(coins, V));

	}

}

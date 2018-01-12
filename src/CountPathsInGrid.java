
public class CountPathsInGrid {
	
	public static int countPathsInGrid(int m, int n) {
		if(m == 1 || n == 1)
			return 1;
		
		return countPathsInGrid(m-1, n) + countPathsInGrid(m, n-1);
	}
	
	public static int countPathsInGriddp(int m, int n) {

		int[][] dp = new int[m][n];
		for(int i=0;i<m;i++)
			dp[i][0] = 1;
		for(int i=0;i<n;i++)
			dp[0][i] = 1;
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		return dp[m-1][n-1];
	}
	
	public static void printPaths(int[][] grid, int m, int n, int i, int j, String path) {
		if(i == m-1) {
			for(int k=j;k<n;k++)
				path += grid[i][k] + "-";
			System.out.println(path);
			return;
		}
		if(j == n-1) {
			for(int k=i;k<m;k++)
				path += grid[k][j] + "-";
			System.out.println(path);
			return;
		}
		path += grid[i][j] + "-";
		printPaths(grid, m, n, i+1, j, path);
		printPaths(grid, m, n, i, j+1, path);
	}
	
	public static int min(int a, int b, int c) {
		if(a <b && a <c)
			return a;
		else if(b < a && b < c)
			return b;
		return c;
	}
	public static int maxPath(int[][] a, int i, int j) {
		if(i == 0 || j == 0)
			return a[i][j];
		return a[i][j] + min(maxPath(a, i-1, j), maxPath(a, i, j-1), maxPath(a, i-1, j-1));
	}
	
	public static int maxPathDP(int[][] a, int m, int n) {
		int[][] dp = new int[m][n];
		dp[0][0] = a[0][0];
		for(int i=1;i<m;i++) {
			dp[i][0] = a[i][0] + dp[i-1][0];
		}
		for(int i=1;i<n;i++) {
			dp[0][i] = a[0][i] + dp[0][i-1];
		}
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				dp[i][j] = a[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
			}
		}
		return dp[m-1][n-1];
	}
	
	public static void main(String[] args) {
		//int ret = countPathsInGrid(3, 3);
		//int ret = countPathsInGriddp(3,3);
		//System.out.println(ret);
		
		int[][] grid = { {1, 2, 3}, 
				 {4, 8, 2},
				 {1, 5, 3} };
		
		// print paths
		/*int m = 3, n=3;		
		printPaths(grid, m,n, 0, 0, new String());
		*/
		
		// max path sum
		int[][] A = { { 1, 7, 9, 2 }, { 8, 6, 3, 2 }, { 1, 6, 7, 8 },
					{ 2, 9, 8, 2 } };
		int maxSum = maxPath(grid, 2, 2);
		//int maxSumDP = maxPathDP(grid, 3, 3);
		System.out.println("max path sum = " + maxSum);
		//System.out.println("max path sum DP= " + maxSumDP);
	}

}

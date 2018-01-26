
public class LongestCommonSubsequenceDP {
	
	public static int LongestCommonSubsequence(String a, String b) {
		int m = a.length();
		int n = b.length();
		int[][] dp = new int[m+1][n+1];
		
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0)
					dp[i][j] = 0;      // preprocess the first row and column
				else if(a.charAt(i-1) == b.charAt(j-1)) 
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); 
			}
		}
		
		// printing the string
		int index = dp[m][n];
		char[] lcs = new char[index+1];
		lcs[index] = '\0';
		int i=m,j=n;
		while(i>0 && j>0) {
			if(a.charAt(i-1) == b.charAt(j-1)) {
				lcs[index-1] = a.charAt(i-1);
				i--;j--;
				index--;
			}
			else if(dp[i-1][j] > dp[i][j-1])
				i--;
			else
				j--;	
		}
		System.out.println("LCS = ");
		for(i=0;i<lcs.length;i++)
			System.out.print(lcs[i]);
		System.out.println();
		return dp[m][n];		
	}
	
	public static int longestCommonSubstring(String a, String b) {
		int m = a.length();
		int n = b.length();
		int[][] dp = new int[m+1][n+1];
		int result = 0;
		
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0)
					dp[i][j] = 0;      // preprocess the first row and column
				else if(a.charAt(i-1) == b.charAt(j-1))  {
					dp[i][j] = 1 + dp[i-1][j-1];
					result = Math.max(result, dp[i][j]);
				}
				else
					dp[i][j] = 0;
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "ABCDGH", b= "ABDFHR";
		int ret = LongestCommonSubsequence(a, b);
		System.out.println("LongestCommonSubsequence=" + ret);
		
		ret = longestCommonSubstring(a, b);
		System.out.println("longestCommonSubstring=" + ret);


	}

}

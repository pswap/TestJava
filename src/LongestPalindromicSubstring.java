
public class LongestPalindromicSubstring {
	
	//https://www.geeksforgeeks.org/?p=25463
	public static void longestPalindromicSubstring(String s) {
		if(s == null)
			return;
		
		int n = s.length();
		int[][] dp = new int[n][n];
		int maxLen = 1;
		for(int i=0;i<n;i++)
			dp[i][i] = 1;
		
		//check for substring of length 2
		int start =0;
		for(int i=0;i<n;i++) {
			if(s.charAt(i) == s.charAt(i+1)) {
				dp[i][i+1] = 1;
				start = i;
				maxLen = 2;
			}
		}
		
		for(int k=2;k<n;k++) {
			// fix lenght of starting index
			for(int i=0;i<n-k+1;i++) {
				int j = n+k-1;
				if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] ==1) {
					dp[i][j] = 1;
					if(k > maxLen) { 
						maxLen = k;
						start = i;
					}
				}
			}
		}
		
		System.out.print("Longest palindrome substring is; " + s.substring(start, start+maxLen-1));	
	}
	
	//https://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
	public static int longestPalindromicSubsequence(String s) {
		if(s == null)
			return 0;
		
		int n = s.length();
		int[][] dp = new int[n][n];
		for(int i=0;i<n;i++)
			dp[i][i] = 1;
		
		for(int k=2;k<n-k;k++) {
			for(int i=0;i<n-k+1;i++) {
				int j = n+k-1;
				if(s.charAt(i) == s.charAt(j) && k ==2) 
					dp[i][j] = 2;
				else if (s.charAt(i) == s.charAt(j))
					dp[i][j] = dp[i+1][j-1]+2;
				else
					dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
			}
		}
		return dp[0][n-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

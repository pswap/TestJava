/*
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence such that all elements of the subsequence are sorted in increasing order. 
For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
longest-increasing-subsequence

More Examples:

Input  : arr[] = {3, 10, 2, 1, 20}
Output : Length of LIS = 3
The longest increasing subsequence is 3, 10, 20

Input  : arr[] = {3, 2}
Output : Length of LIS = 1
The longest increasing subsequences are {3} and {2}

Input : arr[] = {50, 3, 10, 7, 40, 80}
Output : Length of LIS = 4
The longest increasing subsequence is {3, 7, 40, 80}

 */
import java.math.*;
public class LongestIncreasingSubSequence {
	
	public static int LIS(int[] a) {
		int maxlen = Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++) {
			int len =1;
			for(int j = i+1; j<a.length;j++) {
				if(a[j] > a[i]) {
					len++;								
				}
				maxlen = Math.max(len, maxlen);
			}		
		}
		return maxlen;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] a = {3, 10, 2, 1, 20};
		//int[] a = {3, 2};
		int[] a = {50, 3, 10, 7, 40, 80};
		System.out.println(LIS(a));

	}

}

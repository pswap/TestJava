import java.util.ArrayList;
import java.util.List;

public class SubsetProblems {
	
	public static void printAllSubsets(int[] a, int i, List<Integer> list) {
		if(i == a.length) {
			for(int j=0;j<list.size();j++)
				System.out.print(list.get(j) +", ");
			System.out.println();
			return;
		}
		
		list.add(a[i]);
		printAllSubsets(a, i+1, list);
		list.remove(list.size()-1);
		printAllSubsets(a, i+1, list);
	}
	
	/*
	 * out[] ---> Temporary array to store current combination
     	i ---> Staring and Ending indexes in arr[]
    		index  ---> Current index in out[]
    		k ---> Size of a combination to be printed 
	 */
	public static void printSubsetsOfkSize(int[] a,int i, int[] out, int index, int k) {
		if(index == k) {
			for(int j=0;j<k;j++)
				System.out.print(out[j] +", ");
			System.out.println();
			return;
		}
		
		if(i == a.length)
			return;
		
		out[index] = a[i];
		printSubsetsOfkSize(a, i+1, out, index+1, k);
		printSubsetsOfkSize(a, i+1, out, index, k);
	}
	
	public static void subsetSumRec(int[] a, int i, int[] out, int index, int k) {
		if(k == 0) {
			for(int j=0;j<index;j++)
				System.out.print(out[j] +", ");
			System.out.println();
			return;
		} 
		if(i == a.length)
			return;
		out[index] = a[i];
		subsetSumRec(a, i+1, out, index+1, k-a[i]);
		subsetSumRec(a, i+1, out, index, k);
	}
	
	
	// this function doesnt work. somethign wrong
	public static boolean subsetSumDP(int[] a, int k) {
		boolean[][] dp = new boolean[a.length+1][k+1];
		// if sum is zero, answer is true
		for(int i=0;i<=a.length;i++)
			dp[0][i] = true;
		// if sum is not zero but array is empty, then false
		for(int j=1;j<=k;j++)
			dp[j][0] = false;
		for(int i=1;i<=k;i++) {
			for(int j=1;j<=a.length;j++) {
				dp[i][j] = dp[i][j-1];
				if(i >= a[j-1])
					dp[i][j] = dp[i][j] || dp[i-a[i-1]][j];
			}
		}
		return dp[k][a.length];
	}
	
	public static boolean findKsum(int[] a, int k) {
		boolean[][] dp = new boolean[a.length][k];
		for(int i=0;i<a.length;i++)
			dp[i][0] = true;
		for(int j=0;j<k;j++)
			dp[0][k] = false;
		for(int i=1;i<a.length;i++) {
			for(int j=1;j<k;j++) {
				dp[i][j] = dp[i-1][j-a[i-1]] || dp[i-1][j];
				if(a[i-1] >= j)
					dp[i][j] = dp[i-1][j];
				
			}
		}
		return dp[a.length][k];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 2, 3, 4};
		List<Integer> list = new ArrayList<Integer>();
		printAllSubsets(a, 0, list);
		int k = 2;
		int[] out = new int[a.length];
		printSubsetsOfkSize(a, 0, out, 0, k);
		
		System.out.println("Subset with k sum=");
		k = 5;
		out = new int[a.length];
		subsetSumRec(a, 0, out, 0, k);
		
		boolean ret = subsetSumDP(a, k);
		System.out.println("subset sum exists or not dp=" + ret);

	}

}

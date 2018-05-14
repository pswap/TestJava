import java.util.*;

public class LongestConsecutiveSubsequence {
	
	public static int longestConsec(int[] a) {
		Set<Integer> set  = new HashSet<Integer>();
		for(int i=0;i<a.length;i++) {
			set.add(a[i]);
		}
		
		int len =0;
		int maxlen = 0;
		for(int i : set) {
			// if prev number is already in set, it must be part of a larger sequence; 
			//if current element is the starting element of a sequence
			if(!set.contains(i-1)) {
				len =0;
				int j = i;
				while(set.contains(j)) {
					j++;
					len++;
				}
				maxlen = Math.max(len, maxlen);
			}
		}
		return maxlen;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {100, 4, 200, 1, 3, 2};
		
		System.out.println(longestConsec(a));
	}

}

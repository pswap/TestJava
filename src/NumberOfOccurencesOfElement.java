// https://algorithms.tutorialhorizon.com/find-the-number-of-occurrences-of-a-number-in-a-given-sorted-array/
public class NumberOfOccurencesOfElement {
	
	// some bug - not working correctly
	public static int findNum(int[] a, int k) {
		int f = firstOccurance(a, 0, a.length-1, k);
		int r = lastOccurance(a, 0, a.length-1, k);
		return r-f+1;
	}
	
	public static int firstOccurance(int[] a, int l, int r, int k) {
		while(l <= r) {
			int m = l+(r-l)/2;
			if(a[m] == k && (m ==0 || a[m-1] < k))
				return m;
			else if(a[m] < k)
				l = m+1;
			else
				r = m-1;
		}
		return -1;
	}
	public static int lastOccurance(int[] a, int l, int r, int k) {
		while(l <= r) {
			int m = l+(r-1)/2;
			if(a[m] == k && (m == a.length-1 || a[m+1] > k))
				return m;
			else if(a[m] > k)
				r = m-1;
			else
				l = m+1;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {1,2,2,2,2,2,2,2,3,4,5,5,6};
		System.out.println(findNum(a, 2));

	}

}

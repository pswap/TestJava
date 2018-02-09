/*
 * Given an array arr[] of n integers, construct a Product Array prod[] (of same size) such that prod[i] is equal to the product of all the elements of arr[] except arr[i]. Solve it without division operator and in O(n).

Example:
arr[] = {10, 3, 5, 6, 2}
prod[] = {180, 600, 360, 300, 900}
 */
public class ArrayProduct {
	
	// brute force
	public static void arrayProduct(int[] a) {
		int[] left = new int[a.length];
		int[] right = new int[a.length];
		int n = a.length;
		
		left[0] = 1;
		right[n-1] = 1;
		// contains prod of all elements on left except current
		for(int i=1;i<n;i++) {
			left[i] = left[i-1] * a[i-1];
		}
		// contains prod of all elements on right except current
		for(int j=n-2;j>=0;j--) {
			right[j] = right[j+1] * a[j+1];
		}
		for(int i=0;i<n;i++) {
			a[i] = left[i] * right[i];
		}
		
		for(int i=0;i<n;i++)
			System.out.print(a[i] + " ");
	}
	
	public static void arrayProduct1(int[] a) {
		int[] out = new int[a.length];		
		int n = a.length;
		
		out[0] = 1;		
		for(int i=1;i<n;i++) {
			out[i] = out[i-1] * a[i-1];
		}
		int right = 1;
		for(int j=n-1;j>=0;j--) {
			out[j] *= right;
			right *= a[j];			
		}
				
		for(int i=0;i<n;i++)
			System.out.print(out[i] + " ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {10, 3, 5, 6, 2};
		arrayProduct1(a);
	}

}

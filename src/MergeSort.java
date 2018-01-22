
public class MergeSort {
	
	public static void merge(int[] a, int l, int m, int r) {
		int n1 = m - l +1;
		int n2 = r - m;
		int[] a1 = new int[n1];
		int[] a2 = new int[n2];
		int i=0,j=0, k;
		// copy arrays
		for(i=0; i<n1;i++)
			a1[i] = a[l+i];
		for(j=0;j<n2;j++) 
			a2[j] = a[m+1+j];
		
		i=0;j=0;k=l;
		while(i < n1 && j < n2) {
			if(a1[i] <= a2[j]) 
				a[k++] = a1[i++];
			else
				a[k++] = a2[j++];		
		}
		
		while(i < n1)
			a[k++] = a1[i++];
		while(j < n2)
			a[k++] = a2[j++];
		
	}
	
	public static void mergeSort(int[] a, int l, int r) {		
		if(l > r)
			return;
		
		int m = (r+l)/2;
		mergeSort(a, l, m);
		mergeSort(a, m+1, r);
		merge(a, l, m, r);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {7,3, 5,1,2,9};
		int l = 0;
		int r = a.length;
		for(int i=0;i<a.length;i++)
			System.out.print("before sort=" + a[i] + ",");
		mergeSort(a, l, r-1);
		System.out.println();
		for(int i=0;i<a.length;i++)
			System.out.print("after sort=" + a[i] + ",");

	}

}

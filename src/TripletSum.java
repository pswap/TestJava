
public class TripletSum {
	public static void tripletSumZero(int[] a) {
		Sorting.quickSort(a, 0, a.length-1);
		
		for(int i=0;i<a.length-1;i++) {
			int l = i+1;
			int r = a.length-1;
			while(l < r) {
				if(a[i]+a[l]+a[r] > 0)
					r--;
				else if(a[i]+a[l]+a[r] < 0)
					l++;
				else {
					System.out.println(a[i] + "," + a[l] + "," + a[r]);
					l++; 
					r--;
				}
			}
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {6, -1, 2, -3, 1};
		tripletSumZero(a);

	}

}

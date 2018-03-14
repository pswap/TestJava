/*
 * Given an array of positive and negative numbers, 
 * arrange them in an alternate fashion such that every positive number is followed by negative and vice-versa maintaining the order of appearance.
 * in: {2,3,-4,-9,-1,-7,1,-5,-6}
 * out: {2,-4,3,-9,1,-1,-7,-5,-6}
 * 
 */
public class AlternatingPositiveNegative {
	public static void rotate(int[] a, int i, int j) {
		int temp = a[j];
		for(int k=j;k>i;k--) {
			a[k] = a[k-1];
		}
		a[i] = temp;
	}
	public static int[] reArrangeNumbers(int[] a) {
		for(int i=0;i<a.length-1;i++) {
			int j = i+1;
			if(a[i] > 0) {
				while(a[j] > 0 && j<a.length-2) {
					j++;
				}
				if(a[j] < 0)
					rotate(a, i+1, j);
			}
			else if(a[i] < 0) {
				//System.out.println("i="+i+"j="+j +",a[i]=" +a[i]);
				while(a[j] < 0 && j<a.length-2) {
					j++;
				}
				if(a[j] > 0)
					rotate(a, i+1, j);
			}
		}
		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] a = {2,3,-4,-9,-1,-7,1,-5,-6};
		int[] a = {1, 2, 3, -4, -1, 4};
		int[] ret = reArrangeNumbers(a);
		for(int i=0;i<ret.length;i++) 
			System.out.print(ret[i] + ",");

	}

}

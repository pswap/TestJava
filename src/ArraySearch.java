// this has a divide and conquer solution- do it when time permits
public class ArraySearch {
	public static boolean search(int[][] a, int k) {
		int n = a.length;
		int i=0;
		int j=n-1;
		while(i < n && j >= 0) {
			if(k < a[i][j])
				j--;
			else if(k > a[i][j])
				i++;
			else {
				System.out.println("found " + k + " at i=" + i + " j=" + j);
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = { {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50} };
		search(a, 25);

	}

}

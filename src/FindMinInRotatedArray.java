//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/discuss/48493/Compact-and-clean-C++-solution
public class FindMinInRotatedArray {
	
	//find minimum in a rotated sorted array
	 static int findMinimum(int[] a) {
        if(a.length == 0 || a == null)
            return -1;
        int l =0;
        int r = a.length-1;
        
        while(l < r) {
        		if(a[l] < a[r])
	            return a[l];
            int m = (r+l)/2;   // l+(r-l)/2
             if(a[l] <= a[m])
                l = m+1;
            else
                r = m;
        }
        return a[l];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

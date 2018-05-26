// https://github.com/mission-peace/interview/blob/master/src/com/interview/binarysearch/MedianOfTwoSortedArray.java
public class MedianOfTwoSortedArrays {
	
	// same size arrays
	public static int findMedian(int[] a, int[] b, int a_start, int a_end, int b_start, int b_end) {
		//a=2, 4 ; b= 5,6
		if(a_end-a_start == 2 && b_end-b_start == 2) {
			return Math.max(a_start, b_start) + Math.min(a_end, b_end) /2;
		}
		int medA = getMedian(a, a_start, a_end);
		int medB = getMedian(a, b_start, b_end);
		
		int midA = a_start+a_end/2;
		int midB = b_start+b_end/2;
		
		if(medA > medB) {
			return findMedian(a, b , a_start, midA, midB, b_end);
		} else
			return findMedian(a, b, midA, a_end, b_start, midB);
	}
	public double median(int arr1[],int arr2[]){
        int low1 = 0;
        int high1 = arr1.length-1;
        
        int low2 = 0;
        int high2 = arr2.length-1;

        while(true){
            
            if(high1 == low1){
                return (arr1[low1] + arr2[low2])/2;
            }
            
            if(high1 - low1 == 1){
                return (double)(Math.max(arr1[low1], arr2[low2]) + Math.min(arr1[high1], arr2[high2]))/2;
            }
            
            double med1 = getMedian(arr1,low1,high1);
            double med2 = getMedian(arr2,low1,high2);
            if(med1 <= med2){
                if((high1-low1 + 1) % 2 == 0){
                    low1 = (high1+low1)/2;
                    high2 = (high2+low2)/2 + 1;
                }else{
                    low1 = (low1+high1)/2;
                    high2 = (low2+high2)/2;
                }
            }
            else{
                if((high1-low1 + 1) % 2 == 0){
                    low2 = (high2+low2)/2;
                    high1 = (high1+low1)/2 + 1;
                }else{
                    low2 = (low2+high2)/2;
                    high1 = (low1+high1)/2;
                }
            }
}
	 
	public static int getMedian(int[] a, int s, int e) {
		int size = e-s+1;
		if(size%2 == 0)
			return (a[s+size/2]+a[s+size/2-1])/2;
		else
			return a[s+size/2];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ar1[] = {1, 12, 15, 26, 38};
		int ar2[] = {2, 13, 14, 30, 45};
		int ret = findMedian(ar1, ar2, 0, ar1.length-1, 0, ar2.length-1);
		System.out.println("ret=" + ret);
	}

}

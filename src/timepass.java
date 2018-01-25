
public class timepass {
	
	 static void groupEvenOddNumbers(int[] intArr) {
	        int i=0;
	        int j=intArr.length-1;
	        while(i<=j && i<intArr.length && j>=0) {
	            while(intArr[i]%2 == 0)
	                i++;
	            while(intArr[j]%2 != 0)
	                j--;
	            if(i <= j) {
		            int temp = intArr[i];
		            intArr[i] = intArr[j];
		            intArr[j] = temp;
		            i++; j--;
	            }
	        }
	        for(i=0;i<intArr.length;i++)
	            System.out.println(intArr[i] +",");
	       // return intArr;
	    }
	 
	 public static String sortCharInString(String inString) {
        int[] a = new int[256];
        int i=0,j=0;
        for(i=0;i<256;i++) {
            a[i] = 0;
        }
        
        char[] s = inString.toCharArray();
        for(i=0;i<s.length;i++) {
            j = (int)s[i];
            a[j]++;
        }
        for(i=0,j=0;i<256;i++) {
            if(a[i] !=0)
                s[j++] = (char)a[i];
        }
        return String.valueOf(s);
		    
	 }
	 
	 static void swap(int i, int j) {
			int temp = i;
			i = j;
			j = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4};
		//groupNumbers(a);
		
		String s = "This is easy";
		//System.out.println(sortCharInString(s));
		
		int i=2, j=3;
		swap(i, j);
		System.out.println("i= " + i + ", j=" + j);
	}

}

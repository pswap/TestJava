
public class ArrayMisc {
	
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
	 
	 public static void reverse(char[] a, int s, int e) {	
		while(s <= e) {
			char temp = a[e];
			a[e] = a[s];
			a[s] = temp;
			s++; e--;
		}
	}
	 public static String reverseSen(String str) {
		 char[] a = str.toCharArray();
		 reverse(a, 0, str.length()-1);
		 int i=0, j=0;
		 for(i=0; i<a.length; i++) {
			 if(a[i] == ' ') {
				 reverse(a, j, i-1);
				 j = i+1;
			 }		 			 
		 }
		 reverse(a, j, i-1);  // reverse last word
		 return new String(a);
	 }
	 
	 public static String reverseString(String str) {
		 int s=0;int e=str.length()-1;
		 char[] a = str.toCharArray();
		 while(s <= e) {
			 char temp = a[s];
			 a[s++] = a[e];
			 a[e--] = temp; 
		 }
		 return new String(a);
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
		
		System.out.println(reverseSen("hello how are you"));
		
		System.out.println(reverseString("swathi"));
	}

}

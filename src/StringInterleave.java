
public class StringInterleave {
	
	/*
	 * If first char of C is same as either first char or A or B, then 
	 */
	public static boolean checkInterleaveExistsRecursion(String A, int i, String B, int j, String C, int k) {
		// if we reach end of all strings
		if(i == A.length()-1 && j == B.length()-1 && k ==C.length()-1)
			return true;
		// if we reach end of C, but A and B are not finished, that means C.len!=A.len+B.len
		if(k == C.length()-1)
			return false;
		
		return ((A.charAt(i) == C.charAt(k) && checkInterleaveExistsRecursion(A, i+1, B, j, C, k+1))
				|| (B.charAt(j) == C.charAt(k) && checkInterleaveExistsRecursion(A, i, B, j+1, C, k+1)));
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "AB";
		String B = "CD";
		String C = "ACBD";
	    boolean ret = checkInterleaveExistsRecursion(A, 0, B, 0, C, 0);
	    System.out.println(ret);
	   
	}

}

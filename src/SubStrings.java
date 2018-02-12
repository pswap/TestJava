// smallest substrign that contains all characters from set

public class SubStrings {
	
	public static void printAllSubstrings(String in) {
		int n = in.length();
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				for(int k=i;k<=j;k++) {
					System.out.print(in.charAt(k));
				}
				System.out.println();
			}
		}
	}
	
	/*public static void printAllSubsequences(String in) {
		int n = in.length();
		for(int i=0;i<n;i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(in.charAt(i));
			for(int j=i+1;j<=n-1;j++) {
				sb.append(in.charAt(j));
				System.out.println(sb.toString());
				sb.deleteCharAt(sb.length()-1);
			}
		}
	} 
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String in = "abc";
		printAllSubstrings(in);
		//printAllSubsequences(in);

	}

}

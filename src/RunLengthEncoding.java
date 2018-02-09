
public class RunLengthEncoding {
	
	public static String basicEncoding(char[] a) {
		int cnt = 0;
		StringBuffer out = new StringBuffer(a.length);
		for(int i=0;i<a.length;i++) {
			cnt = 0;			
			while(i+1 < a.length && a[i] == a[i+1]) {
				cnt++;
				i++;				
			}
			if(cnt == 0)
				out.append(a[i]);
			else {
				out.append(cnt+1);
				out.append(a[i]);
			}
		}
		System.out.println(out.toString());
		return out.toString();
	}
	
	public static String decode(char[] a) {		
		StringBuffer out = new StringBuffer();
		for(int i=0;i<a.length;i++) {
			if(a[i] >= '0' && a[i] <= '9') {
				int j = a[i];
				while(j-- <= 0)
					out.append(a[i+1]);
			} else 
				out.append(a[i]);
		}
		System.out.println(out.toString());
		return out.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "BAAAB777";
		//String a = "AAAAA";
		basicEncoding(a.toCharArray());
		decode(a.toCharArray());
	}

}

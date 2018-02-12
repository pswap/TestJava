import java.util.HashSet;
import java.util.*;

// min window in a string that contains all characters of set
public class MinimumWindowSubString {
	
	public static String minWindow(String s, String T) {
		char[] str = s.toCharArray();
		Set<Character> charSet = new HashSet<Character>();
		for(int i=0;i<T.length();i++)
			charSet.add(T.charAt(i));
		Map<Character, Integer> hm = new HashMap<Character, Integer>();
		int minl = 0, minr =0;
		int l = 0, r=0;
		int n = str.length;
		int minWin = Integer.MAX_VALUE;
		while(r < n) {
			// increment r as long as the current char is in set
			// if we reach hm,size = set.size, it means we have a window.
			while(r < n) {
				if(charSet.contains(str[r])) {
					if(hm.containsKey(str[r])) {
						int cnt = hm.get(str[r]);
						hm.put(str[r], cnt+1);
					} else 
						hm.put(str[r], 1);
				}
				if(hm.size() == charSet.size())
					break;
				r++;
			}
			
			// Now from the left side, remove the chars we no longer need in the window
			while(l<n) {
				if(charSet.contains(str[l])) {
					if(hm.containsKey(str[l])) {
						int cnt = hm.get(str[l]);
						hm.put(str[l], cnt-1);
						if(cnt-1 == 0)
							hm.remove(str[l]);
					}
				}
				l++;
				if(hm.size() < charSet.size())
					break;
			}
			
			int tmp = r - (l-1)+1; //r-(l-1)+1; dont need +1 as said in the class as the stop condition in r loop is different
			if(tmp < minWin) {
				minWin = r - l + 2;
				minl = l-1;
				minr = r-1;
			}
			r++;
		}
		System.out.println("lenght of minWindow=" + minWin + ", start at =" + minl + ", to =" + minr);
		String ret = "";
		for(int i=minl; i<=minr; i++)
			ret += s.charAt(i);
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ADOBECODEBANC"; //this is a test string";//"abcdba";
		String T = "ABC"; //"tist";//"bd";
		String ret = minWindow(s, T);
		System.out.println("min string = " + ret);
	}

}

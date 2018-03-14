import java.util.*;

public class LongestSubStringWithAtmostKDistinct {
	
	// longest substring with atmost two distinct chars
	//eceba -> ece
	
	// tracking the element counts is the key here
	public static String longestSubStringWithAtmostKDistinct(String s, int k) {
		int l = 0, i=0;
		int max = Integer.MIN_VALUE;
		int maxl=0, maxi=0;
		Map<Character, Integer> hm = new HashMap<Character, Integer>();
		for(i=0;i<s.length();i++) {
			if(hm.containsKey(s.charAt(i)))
				hm.put(s.charAt(i), hm.get(s.charAt(i))+1);
			else
				hm.put(s.charAt(i), 1);
			while(hm.size() > k) {
				// reduce count if hm consists this 'l' index. if count==0 , delete that entry
				if(hm.containsKey(s.charAt(l)))
					hm.put(s.charAt(l), hm.get(s.charAt(l))-1);
				if(hm.get(s.charAt(l)) == 0) 
					hm.remove(s.charAt(l));
				l++;
			}
			
			int tmp = i-l+1;
			if(tmp > max) {
				max = tmp;
				maxl = l;
				maxi = i;
			}
		}
		String res = "";
        if(i == s.length() && l == 0 && hm.size() == 1)
            return res;
		for(i=maxl;i<=maxi;i++) 
			//System.out.println(s.charAt(i));
            res += s.charAt(i);
		System.out.println("max=" + max + " , result =" + res);
		return res;
	}
	
	//Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.
	//aaabb->aaa k=3

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaaaa"; //"abcbbbbcccbdddadacb"; //"eceba";
		int k =2;
		longestSubStringWithAtmostKDistinct(s, k);

	}

}

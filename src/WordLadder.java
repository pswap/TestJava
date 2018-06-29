import java.util.LinkedList;
import java.util.*;
import java.util.Queue;
/*
 * https://leetcode.com/problems/word-ladder/description/
 * http://www.learn4master.com/algorithms/bread-first-search/leetcode-word-ladder-solution-in-java
 * Need better understanding
 */
public class WordLadder {
		
	public static int wordLadder(String s1, String s2, Set<String> dict) {
		Queue<String> q = new LinkedList<String>();
		q.add(s1);
		dict.add(s2);
		
		int count = 1;
		
		while(!q.isEmpty()) {
			String s = q.remove();
			if(s.equals(s2))
				return count;
			
			char[] tmp = s.toCharArray();
			for(int i=0;i<tmp.length;i++) {
				char a = tmp[i];
				for(char j='a';j<='z';j++) {
					//if(tmp[i] != j)
						tmp[i] = j;
					
					String ts = new String(tmp); //.toString();					
					if(dict.contains(ts)) {
						q.add(ts);
						dict.remove(ts);
					}
					tmp[i] = a;
				}
			}
			count++;
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String begin = "hit";
		String end = "cog";
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		dict.add("cog");
		//int ret = getMinLength(begin, end, dict);
		int ret = wordLadder(begin, end, dict);
		//int ret = length2(begin, end, dict);
		System.out.println("ret=" + ret);

	}

}

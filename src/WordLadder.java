import java.util.LinkedList;
import java.util.*;
import java.util.Queue;
/*
 * https://leetcode.com/problems/word-ladder/description/
 * http://www.learn4master.com/algorithms/bread-first-search/leetcode-word-ladder-solution-in-java
 * Need better understanding
 */
public class WordLadder {
		
	public static int getMinLength(String begin, String end, Set<String> dict) {
		Queue<String> currLevel = new LinkedList<String>();
		Queue<String> nextLevel = new LinkedList<String>();
		int level = 1;
		currLevel.add(begin);
		
		while(!currLevel.isEmpty()) {
			level++;
			while(!currLevel.isEmpty()) {

				String s = currLevel.poll();
				char[] a = s.toCharArray();	
				
				for(int i=0;i<a.length;i++) {
					//System.out.println("starting with i=" + i);
					
					for(char j='a'; j<='z';j++) {
						// save current char in word					
						char t = a[i];
						if(a[i] != j)
							a[i] = j;
						// create new string with replaced char
						String temp = new String(a);
						if(temp.equals(end))
							return level;

						if(dict.contains(temp)) {
							//System.out.println("path=" + temp);
							nextLevel.add(temp);
							dict.remove(temp);
						}	
						// restore the char back
						a[i] = t;
					}
				}
			}
			currLevel = nextLevel;
			nextLevel = new LinkedList<String>();		
		
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
		int ret = getMinLength(begin, end, dict);
		//int ret = length2(begin, end, dict);
		System.out.println("ret=" + ret);

	}

}

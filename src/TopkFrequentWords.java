import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class TopkFrequentWords {
	
	class strCount implements Comparator {
		String str;
		int count;
		strCount(String str, int count) {
			this.str = str;
			this.count = count;
		}
		@Override
		public int compare(Object o1, Object o2) {
			return map.get;
		}
	}
	
	public static void countWords(String str, int k) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		Queue<String> pq = new PriorityQueue<String>(k, new Comparator<Integer>()
														{ public int compare(String a, String b) {return map.get(a)-map.get(b);}} 
													); 
		String[] s = str.split(",");
		for(int i =0;i<s.length;i++) {
			if(map.containsKey(s[i]))
				map.put(s[i], map.get(s[i])+1);
			else
				map.put(s[i], 1);
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

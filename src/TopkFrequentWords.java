import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class TopkFrequentWords {
	static Map<String, Integer> map = new HashMap<String, Integer>();	
	
	class MyComparator implements Comparator<String> {
		@Override
		public int compare(String a, String b) {
			return map.get(a) - map.get(b);
		}
	}
	
	public static List<String> countWords(String str, int k, MyComparator mc) {
			
		Queue<String> pq = new PriorityQueue<String>(k, mc); 
		String[] s = str.split(" ");
		// build map with counts
		for(int i =0;i<s.length;i++) {
			if(map.containsKey(s[i]))
				map.put(s[i], map.get(s[i])+1);
			else
				map.put(s[i], 1);
		}
		// insert strings into heap
		for(String tmp : map.keySet()) {
			pq.offer(tmp);
			if(pq.size() > k)
				pq.poll();
		}
		
		List<String> result = new ArrayList<String>();
		while(!pq.isEmpty()) {
			result.add(pq.poll());
		}
		Collections.reverse(result);
		return result;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TopkFrequentWords maincall = new TopkFrequentWords();
		MyComparator mc = maincall.new MyComparator();
		//String str="hello hi hello how are you hi hello";
		String str = "Two vast and trunkless legs of stone Stand in the desert. Near them, on the sand, Half sunk, a shattered visage lies, whose frown, And wrinkled lip, "
				+ "and sneer of cold command, Tell that its sculptor well those passions read Which yet survive, stamped on these lifeless things, The hand that mocked them "
				+ "and the heart that fed: And on the pedestal these words appear: 'My name is Ozymandias, king of kings: Look on my works, ye Mighty, and despair!' Nothing beside remains. "
				+ "Round the decay Of that colossal wreck, boundless and bare The lone and level sands stretch far away.";
		int k = 10;
		str.replaceAll(".,:!", "");
		List<String> res = countWords(str, k, mc);
		for(int i=0;i<res.size();i++) {
			System.out.println(res.get(i));
		}

	}

}

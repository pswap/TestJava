import java.util.ArrayList;
import java.util.List;

public class WordBreak {
	
	public static List<List<String>> wordBreakListOfLists(String str, List<String> dict, List<String> list, List<List<String>> bigList) {
		//List<List<String>> bigList = new ArrayList<List<String>>();
		if(str.length() == 0) {
			bigList.add(list);
			//list = new ArrayList<String>();
			return bigList;
		}
		for(int i=1;i<=str.length();i++) {
			//list = new ArrayList<String>();
			String curr = str.substring(0, i);
			if(dict.contains(curr)) {

				list.add(curr);
				String suffix = str.substring(i, str.length());
				wordBreakListOfLists(suffix, dict, list, bigList);				
			}			
		}	
		return bigList;
	}
	
	public static void dfs(List<List<String>> list) {
		for(List<String> subList : list) {
			for(int i=0;i<subList.size();i++) {
				System.out.print(subList.get(i) + "|");
			}
			System.out.println("");
		}
	}
	
	public static void wordBreak(String str, List<String> dict, String out) {
		if(str.length() == 0) 
			System.out.println("final out= " + out);
		for(int i=1;i<=str.length();i++) {
			String curr = str.substring(0, i);
			if(dict.contains(curr)) {
				String suffix = str.substring(i, str.length());
				wordBreak(suffix, dict, out + "|" + curr);				
			}			
		}		
	}
	
	public static boolean wordBreakExistsOrNot(String str, List<String> dict) {
		if(str.length()==0)
			return true;
		for(int i=1;i<=str.length();i++) {
			String curr = str.substring(0, i);
			if(dict.contains(curr) && wordBreakExistsOrNot(str.substring(i, str.length()), dict))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "catsanddogs";
		List<String> dict = new ArrayList<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("dogs");
		dict.add("sand");
		//dict.add("dog");
		//dict.add("s");
		wordBreak(str, dict, "");
		boolean ret = wordBreakExistsOrNot(str, dict);
		System.out.println("wordBreakExistsOrNot = " + ret);
		
		List<List<String>> bigList = new ArrayList<List<String>>();
		dfs(wordBreakListOfLists(str, dict, new ArrayList<String>(), bigList));

	}

}

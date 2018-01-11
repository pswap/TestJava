import java.util.ArrayList;
import java.util.List;

public class PalindromicPartition {
	public static boolean isPalindrome(String str) {
		int s=0;
		int e=str.length()-1;
		while(s <= e) {
			if(str.charAt(s) != str.charAt(e)) 
				return false;
			s++; e--;
		}
		return true;
	}
	public static void ppUtil(String str, List<ArrayList<String>> result, List<String> partition, int start) {
		if(start == str.length()) {
			result.add(new ArrayList<String>(partition));
			return;
		}
			
		for(int i=start+1;i<=str.length();i++) {
			String curr = str.substring(start, i);
			if(isPalindrome(curr)) {
				partition.add(curr);
				ppUtil(str, result, partition, i);
				partition.remove(partition.size() - 1);				
			}
		}
	}
	public static void palindromicPartitionRecursion(String str) {
		List<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		List<String> partition = new ArrayList<String>();
		
		ppUtil(str, result, partition, 0);
		
		for(int i=0;i<result.size();i++) {
			List<String> sublist = result.get(i);
			for(int j=0;j<sublist.size();j++) {
				System.out.print(sublist.get(j) + "|");
			}
			System.out.println();
		}
	}
	
	public static void palindromicPartitionDP(String str) {
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abracadabra";
		
		palindromicPartitionRecursion(str);


	}
}

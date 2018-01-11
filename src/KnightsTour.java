import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KnightsTour {
	public static Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
	
	// (currnum, remainingSlotsToFill)
	public static int ktRecursion(int currNum, int remNum) {
		if(remNum == 0)
			return 1;
		int count = 0;
		List<Integer> list = map.get(currNum);
		if(list != null) {
			for(int i=0;i<list.size();i++)
				count += ktRecursion(list.get(i), remNum-1);
		}
		
		return count;
	}
	
	public static int ktMemoization(int currNum, int remNum, Integer memo[][]) {
		if(remNum == 0)
			return 1;
		if(memo[currNum][remNum] != -1)
			return memo[currNum][remNum];
		
		int count = 0;
		List<Integer> list = map.get(currNum);
		if(list != null) {
			for(int i=0;i<list.size();i++)
				count += ktRecursion(list.get(i), remNum-1);
		}
		memo[currNum][remNum]  = count;
		return count;
	}
	
	public static void main(String[] args) {
		int n = 10;
		map.put(0, Arrays.asList(4,6));
		map.put(1, Arrays.asList(6,8));
		map.put(2, Arrays.asList(7,9));
		map.put(3, Arrays.asList(4,8));
		map.put(4, Arrays.asList(3,9,0));
		map.put(5, null);
		map.put(6, Arrays.asList(0,1,7));
		map.put(7, Arrays.asList(6,2));
		map.put(8, Arrays.asList(1,3));
		map.put(9, Arrays.asList(2,4));

		int c1 = ktRecursion(6, n-1);
		System.out.println("recursion count="+ c1);
		
		Integer memo[][] = new Integer[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				memo[i][j] = -1;
		int c2 = ktMemoization(6, n-1, memo);
		System.out.println("memoization count="+ c2);

	}
}

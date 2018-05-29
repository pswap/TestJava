
//https://www.geeksforgeeks.org/total-number-of-possible-binary-search-trees-with-n-keys/
public class CountTrees {
	 static int countTrees(int n) {
	        if(n <= 1)
	            return 1;
	        int total = 0;
	        for(int i=1;i<=n;i++) {
	            int nl = i-1;
	            int nr = n-i;
	            total += countTrees(nl) * countTrees(nr);
	        }
	        return total;
	    }
}

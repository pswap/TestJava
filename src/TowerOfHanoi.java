
public class TowerOfHanoi {
	 public static void towersHanoi(int n, char src, char dest, char temp) {
	        if(n==1) {
	            System.out.println("moving " + n + " from " + src + " to " + dest);
	            return;
	        }
	        towersHanoi(n-1, src, temp, dest);
	        System.out.println("moving " + n + " from " + src + " to " + dest);
	        towersHanoi(n-1, temp, dest, src);
	    }
	    public static void main(String args[] ) throws Exception {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
	        towersHanoi(64, 'A', 'B', 'C');
	    }
}

// wildcard
// double power


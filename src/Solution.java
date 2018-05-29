import java.util.*;

public class Solution {

	static Map<Integer, List<String>> bank = new HashMap<Integer, List<String>>();
	static Set<String> set = new HashSet<String>();
	    public static boolean canBeSeated(List<String> seats) {
	        int size = seats.size();
	        int i =0;
	        if(size == 3) {
	            if(!set.contains(seats.get(i)) && !set.contains(seats.get(i+1)) 
	            && !set.contains(seats.get(i+2)) )
	                return true;
	        }
	        if(size == 4) {
	            if((!set.contains(seats.get(i)) && !set.contains(seats.get(i+1)) 
	            && !set.contains(seats.get(i+2))) 
	            || (!set.contains(seats.get(i+1)) && !set.contains(seats.get(i+2)) 
	            && !set.contains(seats.get(i+3))) )
	                return true;
	        }
	        
	       return false; 
	    }
	    public static List<String> genSeatNumbers(int N, List<String> seats ) {
	    		List<String> seatNumbers = new ArrayList<String>();
	    		for(int i=0;i<seats.size();i++) {
	    			seatNumbers.add(N+seats.get(i));
	    		}
	    		return seatNumbers;
	    	
	    }
	    public static int solution(int N, String S) {
	        // write your code in Java SE 8
	        // add values to the seat banks
	        bank.put(0, new LinkedList<String>(Arrays.asList("A","B","C")));
	        bank.put(1, new LinkedList<String>(Arrays.asList("D","E","F", "G")));
	        bank.put(2, new LinkedList<String>(Arrays.asList("H","J","K")));
	        
	        // add reserved seats to the set
	        String[] st = S.split(" ");
	        for(int i=0;i<st.length;i++)
	            set.add(st[i]);

	        int count=0;
	        for(int i=0;i<N;i++) {
	            for(int key : bank.keySet()) {
	            		List<String> seatNumbers = genSeatNumbers(N, bank.get(key));
	                if(canBeSeated(seatNumbers) == true) {
	                    count++;
	                }   
	            }
	        }
	        return count;
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ret = solution(2, "1A 2F 1C");
		System.out.println("ret=" + ret);
	}

}

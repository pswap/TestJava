import java.util.Stack;

public class LongestSubStringWithMatchingParanthesis {
	
	 static int find_max_length_of_matching_parentheses(String brackets) {
	        Stack<Integer> stk = new Stack<Integer>();
	        int fromCount = 0;
	        int max = 0;
	        for(int i=0;i<brackets.length();i++) {
	            if(brackets.charAt(i) == '(')
	                stk.push(i);
	            else {
	                if(stk.empty()) 
	                    fromCount = i+1;
	                else {
	                    stk.pop();
	                    if(stk.empty())
	                        max = Math.max(max, i-fromCount+1);
	                    else
	                        max = Math.max(max, i-stk.peek());
	                }
	            }
	        }
	        return max;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

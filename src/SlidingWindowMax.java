import java.util.Deque;
import java.util.LinkedList;
//https://www.programcreek.com/2014/05/leetcode-sliding-window-maximum-java/

public class SlidingWindowMax {
	
	/*
	 * head has the largest elem in current window and elems will be added to the tail
	 * We check the tail to decide if we should insert an elem or not
	 * if tail is less than current elem, it is useless. so remove it
	 * also if the window has passed, delete it 
	 */
	public static int[] slidingWindowMax(int[] a, int k) {
		Deque<Integer> dq = new LinkedList<Integer>();
		int[] res = new int[a.length-(k-1)];
		int j=0;
		for(int i=0;i<a.length;i++) {
			
			// remove elements from head which are out of this window
			if(!dq.isEmpty() && dq.peek() == i-k)
				dq.poll();
			
			// remove all elements smaller than the current elem (elements are useless)
			while(!dq.isEmpty() && a[dq.peekLast()] < a[i]) {
				dq.removeLast();
			}
			// add elem to the tail
			dq.addLast(i);
			
			// queue head has largest elem in this window
			if(i+1 >= k)
				res[j++] = a[dq.peek()]; 
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 2, 3, 1, 4, 5, 2, 3, 6};
		int k = 3;
		//output : 3 3 4 5 5 5 6
		int res[] = slidingWindowMax(a, k);
		for(int i=0;i<res.length;i++) 
			System.out.println(res[i]+",");

	}

}

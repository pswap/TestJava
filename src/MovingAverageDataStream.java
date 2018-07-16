import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MovingAverageDataStream {
	static Queue<Integer> q=null;
	static int size = 100;
	static int sum = 0;
	static double avg = 0;
	
	//http://buttercola.blogspot.com/2016/06/leetcode-346-moving-average-from-data.html
	public MovingAverageDataStream() {
		q = new LinkedList<Integer>();
	}
	
	public static double next(int val) {
		if(q.size() == 0) {
			// first element
			for(int i : q) {
				sum += i;
			}
			return sum/q.size();
		} else {
			sum += val;
			int n;
			if(q.size() > size)  {
				n = q.poll();
				sum -= n;
			} 
			q.offer(val);
			return  sum/q.size();
		}		
	}
}

//https://leetcode.com/problems/find-median-from-data-stream/solution/
//https://leetcode.com/problems/find-median-from-data-stream/discuss/74049/Share-my-java-solution-logn-to-insert-O(1)-to-query
// complexity log(n)
/*
 * First add num to maxheap (contains lower half of sorted numbers). then to rebalance,remove its top and add it to minheap(contains higher half)
 */
class MedianDataStream {
	
	Queue<Integer> minHeap = new PriorityQueue<>();
	Queue<Integer> maxHeap = new PriorityQueue<>(1000, Collections.reverseOrder());
	
	public void addNum(int k) { 
		maxHeap.offer(k);     // add to max heap
		minHeap.offer(maxHeap.poll());    // remove max elem from maxheap and give it to min, so that it'll rebalance
		
		if(maxHeap.size() < minHeap.size()) {
			maxHeap.offer(minHeap.poll());   // maintain size property
		}
	}
	
	public double findMedian() {
		if(maxHeap.size() == minHeap.size())
			return (maxHeap.peek() + minHeap.peek())/2;
		else
			return maxHeap.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

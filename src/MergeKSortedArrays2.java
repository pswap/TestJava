import java.util.Arrays;
import java.util.PriorityQueue;

//https://www.youtube.com/watch?v=6bvnZzwiKzs
//https://www.programcreek.com/2014/05/merge-k-sorted-arrays-in-java/

class QueueNode implements Comparable<QueueNode> {
	int value;
	int index;    // index of array from which element is taken
	int subIdx;    // index of next element to be picked in the array
	QueueNode(int index, int subIdx, int value) {
		this.value = value;
		this.index = index;
		this.subIdx = subIdx;
	}
	public int compareTo(QueueNode o) {
		if(value > o.value) return 1;
		if(value < o.value) return -1;
		return 0;
	}
	
}
// using java priority queue
public class MergeKSortedArrays2 {
	
	public static int[] merge(int[][] a) {
		PriorityQueue<QueueNode> pq = new PriorityQueue<QueueNode>();
		int size =0;
		for(int i=0;i<a.length;i++) {
			size += a[i].length;
			pq.add(new QueueNode(i, 0, a[i][0]));
		}
		
		int[] result = new int[size];
		int m =0;
		
		while(!pq.isEmpty()) {
			QueueNode n = pq.poll();
			result[m++] = n.value;
			int idx = n.index;
			int subidx = n.subIdx + 1;
			if(subidx <= a[idx].length-1)
				pq.add(new QueueNode(idx, subidx, a[idx][subidx]));
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = { 1, 3, 5, 7 };
		int[] arr2 = { 2, 4, 6, 8 };
		int[] arr3 = { 0, 9, 10, 11 };
 
		int[] result = merge(new int[][] { arr1, arr2, arr3 });
		System.out.println(Arrays.toString(result));

	}
}

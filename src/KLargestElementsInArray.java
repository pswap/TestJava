import java.util.*;

public class KLargestElementsInArray {
	public static List<Integer> findKLargest(int[] a, int k) {
		Queue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer> () {
																public int compare(Integer o1, Integer o2) {
																	return o1.compareTo(o2);
																}
															}
													 );
		int i = 0;
		while(i < a.length) {
			pq.offer(a[i]);
			i++;
			if(pq.size() > k)
				pq.poll();
		}

		List<Integer> list = new ArrayList<Integer>();
		while(!pq.isEmpty()) {
			list.add(pq.poll());
		}
		Collections.reverse(list);
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[]{1, 23, 12, 9, 30, 2, 50};
		int k = 3;
		List<Integer> b = findKLargest(arr, k);
		for(int i=0;i<k;i++)
			System.out.println(b.get(i) + ",");

	}

}

import java.util.Arrays;
/*
 * Given k sorted arrays of size n each, merge them and print the sorted output. Facebook
 */

public class MergeKSortedArrays {
	static int n;
	static int k;
	
	public static class MinHeapNode {
		int val;
		int i;    // index of array from which element is taken
		int j;    // index of next element to be picked in the array
		
	}
	
	public static class minHeap{
		
		MinHeapNode[] hArr;
		int hSize;
		int MAXSIZE = 100;
		
		// constructor if we want to construct heap from array directly
		public minHeap(MinHeapNode[] arr, int size) {
			hArr = new MinHeapNode[size];		
			hArr = Arrays.copyOf(arr, size);	
			hSize = size;	
			int i = (hSize-1)/2;
			while(i >= 0) {
				minHeapify(i);
				i--;
			}
		}
		
		int parent(int i) {
			return (i-1)/2;
		}
		int leftChild(int i) {
			return (2*i)+1;
		}
		int rightChild(int i) {
			return (2*i)+2;
		}
		
		void replaceMin(MinHeapNode x) {
			hArr[0] = x;
			minHeapify(0);
		}		
		
		MinHeapNode getMin() {
			MinHeapNode ret = hArr[0];
			return ret;
		}
		void swap(int p, int q) {
			MinHeapNode temp = hArr[p];
			hArr[p] = hArr[q];
			hArr[q] = temp;
		}
		void minHeapify(int c) {
			int l = leftChild(c);
			int r = rightChild(c);
			int min = c;
			if(l<hSize && hArr[l].val < hArr[min].val)
				min = l;
			if(r<hSize && hArr[r].val < hArr[min].val)
				min = r;
			if(min != c) {
				swap(min, c);
				minHeapify(min);
			}
			
		}
	}   // end of minheap class
	
	public static int[] merge(int[][] a) {
		int[] res = new int[n*k];
		MinHeapNode[] mh = new MinHeapNode[k];
		for(int p = 0;p < k;p++) {
			mh[p] = new MinHeapNode();
			mh[p].val = a[p][0];
			mh[p].i = p;     // index of array
			mh[p].j = 1;    // next elem to be picked is 1 as we already copied 0th elem
		}
		minHeap mHeap = new minHeap(mh, k); 
		
		for(int m=0;m<n*k;m++) {
			// get min from heap and put in result
			MinHeapNode h = mHeap.getMin();
			res[m] = h.val;
						
			// next elem belongs to same row as current root
			if(h.j < n) {				
				h.val = a[h.i][h.j];
				h.j++;
			}
			else 
				h.val = Integer.MAX_VALUE;
			
			// replace root of heap with next elem
			mHeap.replaceMin(h);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		k = 3;
		n = 4;
		int arr[][] =  {{2, 6, 12, 34},
                		 {1, 9, 20, 1000},
                		 {23, 34, 90, 2000}};		
		
		int[] ret = MergeKSortedArrays.merge(arr);
		for(int i=0;i<k*n;i++)
			System.out.print(ret[i] + ",");

	}

}

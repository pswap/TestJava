import java.util.Arrays;

public class MaxHeap {
	int[] hArr;
	int hSize;
	int MAXSIZE = 100;
	
	// constructor if we want to construct heap from array directly
	MaxHeap(int[] a, int size) {
		hArr = new int[size];
		hArr = Arrays.copyOf(a, size);
		hSize = size;
		int i = (hSize-1)/2;
		while(i >= 0) {
			maxHeapify(i);
			i--;
		}
	}
	
	MaxHeap() {
		hArr = new int[MAXSIZE];
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
	void swap(int i, int j) {
		int temp = hArr[i];
		hArr[i] = hArr[j];
		hArr[j] = temp;
	}
	int getMax() {
		return hArr[0];
	}
	void replaceMax(int x) {
		hArr[0] = x;
		maxHeapify(0);
	}
	
	void insert(int e) {
		if(hSize == MAXSIZE) {
			System.out.println("max reached");
		}
		
		hSize++;
		int i = hSize -1;  // index where new elem is inserted
		hArr[i] = e;
		// rearrange the heap
		int parent = parent(i);
		while(i != 0 && hArr[parent] < hArr[i]) {
			swap(parent, i);
			i = parent;
			parent = parent(i);
		}
	}
	
	// delete element at a given index
	int delete(int i) {
		if(hSize == 0)
			return Integer.MIN_VALUE;
		int e = hArr[i];
		hArr[i] = hArr[hSize-1];
		hSize--;
		maxHeapify(i);
		return e;
	}
	
	public void maxHeapify(int i) {
		int l = leftChild(i);
		int r = rightChild(i);
		int largest = i;
		if(l < hSize && hArr[l] > hArr[i])
			largest = l;
		if(r < hSize && hArr[r] > hArr[largest])
			largest = r;
		if(largest != i) {
			swap(i, largest);
			maxHeapify(largest);
		}
	}
	
	// get max ie top elem/root in heap
	public int extractMax() {
		if(hSize == 0)
			return Integer.MAX_VALUE;
		int root = hArr[0];
		if(hSize > 1) {
			hArr[0] = hArr[hSize -1];
			maxHeapify(0);
		}
		hSize--;
		return root;
	}
	
	public void printHeap() {
        if (hArr == null)
            System.out.print("null");
        int iMax = hSize - 1, i;
        if (iMax == -1)
            System.out.print("[]");

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (i = 0; i < iMax; i++) {
            b.append(hArr[i]);
            b.append(", ");
        }
        System.out.println(b.append(hArr[i]).append(']').toString());
    }

		
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int[] a = new int[]{2, 4, 5, 1, 6, 7, 8};
		//heap = [8, 6, 7, 1, 4, 2, 5]
		MaxHeap maxHeap = new MaxHeap(a, a.length);
        maxHeap.printHeap();
        System.out.println("extract max= " + maxHeap.extractMax());
        maxHeap.printHeap();
        //System.out.println("extract max= " + maxHeap.delete(1));
       */
		
		/*MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(2);
        maxHeap.insert(4);
        maxHeap.insert(5);
        maxHeap.insert(1);
        maxHeap.insert(6);
        maxHeap.insert(7);
        maxHeap.insert(8);
        maxHeap.printHeap();
        System.out.println("extract max= " + maxHeap.extractMax());
        */
        /* --------find kth maximum element in a stream of numbers ------  
		 * -- method 1 : using max heap; build max heap for n elements and call extractmax k times
		 * -- method 2 : using min heap; build a heap for k elements and for n-k elements, 
         * if current elem is smaller than root, replace root with curr elem and heapify.
         * this will build a max heap eventually
         * 
         * This file is only for maxheap; when I write minheap, we can see the second method
         */
        int k =2;
        int[] a = new int[]{2, 4, 5, 1, 6, 7, 8};
		//heap = [8, 6, 7, 1, 4, 2, 5]
		MaxHeap maxHeap = new MaxHeap(a, a.length);
        maxHeap.printHeap();
        for(int i=0;i<k;i++) {
        		maxHeap.extractMax();
        }
        System.out.println("kth largest = " +maxHeap.getMax());
        	
        
        /* for method 2 described above
          MaxHeap maxHeap = new MaxHeap(a, n);
         for(int i = k; i<a.length;i++) {
         
        		if(a[i] < maxHeap.getMax())
        			maxHeap.replaceMax(a[i]);
        	}
        	System.out.println("kth largest = " +maxHeap.getMax());
        	*/
	}

}

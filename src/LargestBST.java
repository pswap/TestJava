class Node1 {
	int val;
	Node1 left;
	Node1 right;
	Node1(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}
class bstWrapper {
	int size;
	boolean isBST;
	int highest;
	int lowest;
	
	bstWrapper() {
		size = 0;
		isBST = false;
		highest = Integer.MIN_VALUE;
		lowest = Integer.MAX_VALUE;
	}
}
public class LargestBST {
	// recursively check if curret node is larger than max of left and less than min of right
	// we need several return values like isbst or not, size of max bst, min and max at the current node. so create a wrapper class with those
	
	public static bstWrapper getLargestBST(Node1 n) {
		bstWrapper curr = new bstWrapper();
		if(n == null) {
			curr.isBST = true;
			return curr;
		}
		
		bstWrapper lw = getLargestBST(n.left);
		bstWrapper rw = getLargestBST(n.right);
		curr.highest = Math.max(rw.highest, n.val);
		curr.lowest = Math.min(lw.lowest, n.val);		
		 
		
		if(lw.isBST && rw.isBST && lw.highest <= n.val && rw.lowest >= n.val)  {
			curr.isBST = true;			
			curr.size = lw.size + rw.size + 1;
				
		} else {
			curr.isBST = false;
			curr.size = Math.max(lw.size, rw.size);
		}
		
		return curr;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node1 root = new Node1(60);
	    root.left = new Node1(65);
	    root.right = new Node1(70);
	    root.left.left = new Node1(50);
	    System.out.println(" Size of the largest BST = " + getLargestBST(root).size);

	}

}

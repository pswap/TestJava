// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/discuss/35472/Share-my-O(1)-space-and-O(n)-time-Java-code
public class SortedListToBST {
	
	//Build BST from a sorted list
	private static ListNode node;   // this is important to keep head constant in recursion	
	public static TreeNode sortedListToBst(ListNode head) {
		
		int size =0;
		ListNode p = head;
		node = head;
		while(p!=null) {
			p = p.next;
			size++;
		}
		return sortedListToBstUtil(0, size-1);
	}
	public static TreeNode sortedListToBstUtil(int l, int r) {
		if(l > r)
			return null;
		int m = l+(r-l)/2;
		TreeNode left = sortedListToBstUtil(l, m-1);
		TreeNode root = new TreeNode(node.val);
		root.left = left;
		node = node.next;
		
		root.right = sortedListToBstUtil(m+1, r);
		return root;
	} 
	
	public static void printTree(TreeNode root) {
		if(root == null)
			return;
		printTree(root.left);
		System.out.println(root.val +",");
		printTree(root.right);
	}
	
	 
	//Build BST from a sorted array
	public static TreeNode sortedArrayToBST(int[] a) {
		return sortedArrayToBSTUtil(a, 0, a.length-1);
	}
	public static TreeNode sortedArrayToBSTUtil(int[] a, int l, int r) {
		if(l > r)
			return null;
		int m = l+(r-l)/2;
		TreeNode left = sortedArrayToBSTUtil(a, l, m-1);
		TreeNode root = new TreeNode(a[m]);
		root.left = left;
		root.right = sortedArrayToBSTUtil(a, m+1, r);
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(1);
		a.next = new ListNode(2);
		a.next.next = new ListNode(3);
		a.next.next.next = new ListNode(4);
		a.next.next.next.next = new ListNode(5);
		TreeNode root = sortedListToBst(a);
		printTree(root);
		
		int[] arr = {1,2,3,4,5};
		TreeNode root1 = sortedArrayToBST(arr);
		printTree(root1);
	}

}

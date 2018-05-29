public class SortedListToBST {
	
	public static TreeNode sortedListToBst(ListNode head) {
		
		int size =0;
		ListNode p = head;
		while(p!=null) {
			p = p.next;
			size++;
		}
		return sortedListToBstUtil(head, 0, size-1);
	}
	public static TreeNode sortedListToBstUtil(ListNode head, int l, int r) {
		if(l > r)
			return null;
		int m = l+(r-l)/2;
		TreeNode left = sortedListToBstUtil(head, l, m-1);
		TreeNode root = new TreeNode(head.val);
		root.left = left;
		head = head.next;
		
		root.right = sortedListToBstUtil(head, l, m-1);
		return root;
		
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

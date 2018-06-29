//http://www.techiedelight.com/place-convert-given-binary-tree-to-doubly-linked-list/
//https://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
public class BinaryTreetoDLL {
	
	static TreeNode prev = null;
	
	
	// these Bt to dll functions are not working
	public static void BTtoDLL(TreeNode root) {
		if(root == null)
			return;
		BTtoDLL(root.left);
		if(prev != null) {
			prev.right = root;
			root.left = prev;
		}  
		prev = root;
		BTtoDLL(root.right);
	}
	
	public static void BTtoDLL2(TreeNode root, TreeNode head, TreeNode prev1) {
		if(root == null)
			return;
		BTtoDLL2(root.left,head,  prev1);
		if(prev1 != null) {
			root.left = prev1;
			prev1.right = root;		
		} else
			head = root;
		prev1 = root;
		BTtoDLL2(root.right, head, prev1);
	}
	
	//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/36977/My-short-post-order-traversal-Java-solution-for-share
	public static void FlattenList(TreeNode root) {
		if(root == null)
			return;
		FlattenList(root.left);
		FlattenList(root.right);
		
		root.right = prev;
		root.left = null;
		prev = root;		
	}
	
	public static void printList(TreeNode node)
    {
        while (node != null) 
        {
            System.out.print(node.val + " ");
            node = node.right;
        }
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);
        //BTtoDLL2(root, root, null);
		//printList(root);
		
		FlattenList(root);
		printList(root);
	}

}

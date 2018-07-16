//http://www.techiedelight.com/place-convert-given-binary-tree-to-doubly-linked-list/
//https://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
public class BinaryTreetoDLL {
	
	static TreeNode prev = null;
	static TreeNode head = null;
	
	//figure out how to pass head in function def but not as a variable
	// same code can be used for bst to DLL
	public static void BTtoDLL(TreeNode root) {
		if(root == null)
			return;
		BTtoDLL(root.left);
		if(prev == null) 
			head = root;
		else {
			root.left = prev;
			prev.right = root;
		}  
		prev = root;
		BTtoDLL(root.right);
	}
	
	// this is same as bst to circular dll and bst to sorted dll
	//http://yuanhsh.iteye.com/blog/2194096
	public static TreeNode BSTtoCircularSortedDLL(TreeNode root) {
		if(root == null)
			return null;
		BSTtoCircularSortedDLL(root.left);
		root.left = prev;
		if(prev == null) 
			head = root;
		else {
			prev.right = root;
		}
		prev = root;
		TreeNode tempright = root.right; //need this as we need to recurse 
		head.left = root;
		root.right = head;
		BSTtoCircularSortedDLL(tempright);
		return head;
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
        BTtoDLL(root);
		printList(head);
		
		//FlattenList(root);
		//printList(root);
	}

}


public class TreeMisc {
	
	public static int currlevel = 0;
	public static void printLeftView(TreeNode root, int level) {
		if(root == null)
			return;
		if(currlevel < level) {
			System.out.println(root.val);
			currlevel = level;
		}
		
		printLeftView(root.left, level+1);
		printLeftView(root.right, level+1);
	}
	
	public static void printRightView(TreeNode root, int level) {
		if(root == null)
			return;
		if(currlevel < level) {
			System.out.println(root.val);
			currlevel = level;
		}
		
		printRightView(root.right, level+1);
		printRightView(root.left, level+1);
	}
	
	 static TreeNode flipTree(TreeNode TreeNode) {
        if(TreeNode == null)
            return null;
        
        TreeNode nl = flipTree(TreeNode.left);
        TreeNode nr = flipTree(TreeNode.right);
        
        TreeNode.left = nr;
        TreeNode.right = nl;
        
        return TreeNode;

    }
	 
	 static TreeNode cloneTree(TreeNode root) {
        if(root== null)
            return null;
        TreeNode n = new TreeNode(root.val);
        n.left = cloneTree(root.left);
        n.right = cloneTree(root.right);
        return n;
    }
	 
	 // populate sibling pointers
	 // given a binary tree, populate next right pointers in each TreeNode
	 static void sibling2(TreeNode root) {
	        if(root == null)
	            return;
	        if(root.left != null) {
	            if(root.right != null) {
	                root.left.next = root.right;
	                if(root.next.left != null)
	                    root.right.next = root.next.left;     
	                else
	                    root.right.next = root.next.right; 
	            }
	            else {
	                if(root.next.left != null)
	                    root.left.next = root.next.left;     
	                else
	                    root.left.next = root.next.right;
	            }
	        }
	        sibling2(root.left);
	        sibling2(root.right);
	    } 
	 
	 private boolean isBST(TreeNode root, int min, int max){
        if(root == null){
            return true;
        }
        if(root.val <= min || root.val > max){
            return false;
        }
        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }
	 
	 public static void main(String[] args) {
		 TreeNode root = new TreeNode(5);
			root.left = new TreeNode(10);
			root.right = new TreeNode(15);
			root.left.left = new TreeNode(20);
			root.left.right = new TreeNode(25);
			root.right.left = new TreeNode(30);
			root.right.right = new TreeNode(35);
			root.left.right.right = new TreeNode(45);
		 //printLeftView(root, 1);
		 printRightView(root, 1);
	 }

}

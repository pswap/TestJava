
public class TreeMisc {
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
        TreeNode n = new TreeNode(root.data);
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
        if(root.data <= min || root.data > max){
            return false;
        }
        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }

}

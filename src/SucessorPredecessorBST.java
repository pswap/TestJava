
public class SucessorPredecessorBST {
	
	//https://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
	/*
	 * 1) If right subtree of node is not NULL, then succ lies in right subtree. Do following.
Go to right subtree and return the node with minimum key value in right subtree.
2) If right sbtree of node is NULL, then start from root and us search like technique. Do following.
Travel down the tree, if a node’s data is greater than root’s data then go right side, otherwise go to left side.
	 */
	public static TreeNode successorBST(TreeNode root, TreeNode k) {
		if(k.right != null) {
			TreeNode t = k;
			while(t!= null) {
				t = t.left;
			}
			return t;
		}
		
		TreeNode succ = null;
		while(root != null) {
			if(root.val > k.val) {
				succ = root;
				root = root.left;
			} else if(root.val < k.val){
				root = root.right;
			} else
				break;
		}
		return succ;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

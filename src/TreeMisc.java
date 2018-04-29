
public class TreeMisc {
	 static Node flipTree(Node node) {
        if(node == null)
            return null;
        
        Node nl = flipTree(node.left);
        Node nr = flipTree(node.right);
        
        node.left = nr;
        node.right = nl;
        
        return node;

    }
	 
	 static Node cloneTree(Node root) {
        if(root== null)
            return null;
        Node n = new Node(root.val);
        n.left = cloneTree(root.left);
        n.right = cloneTree(root.right);
        return n;
    }
	 
	 // populate sibling pointers
	 // given a binary tree, populate next right pointers in each node
	 static void sibling2(Node root) {
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

}

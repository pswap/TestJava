//https://articles.leetcode.com/construct-binary-tree-from-inorder-and-preorder-postorder-traversal/
public class RebuildTree {
	
	  static class Node {
	        int val;
	        Node left;
	        Node right;
	        Node(int val) {
	            this.val = val;
	        }
	    }
	    static Node constructTreeUtil(int[] in, int iStart, int iEnd, int[] pre, int pStart, int pEnd) {
	        
	        if(iStart > iEnd)
	            return null;
	        
	        Node root = new Node(pre[pStart]);
	        int index = 0;
	        for(int i=0;i<in.length;i++) {
	            if(in[i] == root.val) {
	                index = i;
	                break;
	            }
	        }
	        root.left = constructTreeUtil(in, iStart, index-1, pre, pStart+1, pStart+index-iStart);
	        root.right = constructTreeUtil(in, index+1, iEnd, pre, pStart+index-iStart+1, pEnd);
	        return root;
	    }

	    static void printLevelOrder(Node root) {
	        if(root == null)
	            return;
	        Queue<Node> q = new LinkedList<Node>();
	        q.add(root);
	        while(true) {
	            int count = q.size();
	            if(count == 0)
	                break;
	            
	            while(count > 0) {
	                Node node = q.peek();
	                System.out.print(node.val + " ");
	                q.remove();
	                if(node.left != null)
	                    q.add(node.left);
	                if(node.right != null)
	                    q.add(node.right);
	                count--;
	            }
	            System.out.println();
	        }
	    }

	    static void constrctTree(int[] iInOrderArray, int[] iPreOrderArray) {
	        Node root = constructTreeUtil(iInOrderArray, 0, iInOrderArray.length-1, iPreOrderArray, 0, iPreOrderArray.length-1);
	        printLevelOrder(root);
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Node2 {
		int val;
		Node2 left, right;
		Node2(int val) {
			this.val = val;
			this.left = this.right = null;
		}
}
public class BinaryTreetoDLL {
		
	public static void BTtoDLL(Node2 root) {
		Node2 prev = new Node2(0);
		helper(root, prev);
	}
	
	public static void helper(Node2 root, Node2 prev) {
		if(root == null)
			return;
		helper(root.left, prev);
		if(prev != null) {
			prev.right = root;
			root.left = prev;
		}  
		prev = root;
		helper(root.right, prev);
	}
	
	public static void printList(Node2 node)
    {
        while (node != null) 
        {
            System.out.print(node.val + " ");
            node = node.right;
        }
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node2 root = new Node2(10);
        //tree.root = new Node2(10);
        root.left = new Node2(12);
        root.right = new Node2(15);
        root.left.left = new Node2(25);
        root.left.right = new Node2(30);
        root.right.left = new Node2(36);
		BTtoDLL(root);
		
		printList(root);
	}

}

class Node1 {
	int val;
	Node1 left;
	Node1 right;
	
	public Node1(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}
public class UniValTrees {
	
	public static boolean countUnivalTree(Node1 root, int count) {
		if(root == null)
			return false;
		
		boolean r1 = countUnivalTree(root.left, count);
		boolean r2 = countUnivalTree(root.right, count);
		
		if(r1 && r2) {
			Node1 l = root.left;
			Node1 r = root.right;
			
			// leaf node
			if(l == null && r == null) {
				count++;
				return true;
			} 
			else if(l!=null  && r!=null && l.val == root.val && r.val == root.val) {
				//both children exists and have same value as parent
				count++;
				return true;
			} 
			else if(l!=null && l.val == root.val) {
				//if left child is not null and has same val as parent
				count++;
				return true;
			} else if(r!=null && r.val == root.val) {
				count++;
				return true;
			}
		}
		return false;		
		
	}
	
	public static boolean countUnivalTree2(Node1 root, int[] count) {
		if(root == null)
			return false;
		
		boolean r1 = countUnivalTree2(root.left, count);
		boolean r2 = countUnivalTree2(root.right, count);
		
		if(r1 && r2) {
			Node1 l = root.left;
			Node1 r = root.right;
			
			// leaf node
			if(l == null && r == null) {
				count[0]++;
				return true;
			} 
			else if(l!=null  && r!=null && l.val == root.val && r.val == root.val) {
				//both children exists and have same value as parent
				count[0]++;
				return true;
			} 
			else if(l!=null && l.val == root.val) {
				//if left child is not null and has same val as parent
				count[0]++;
				return true;
			} else if(r!=null && r.val == root.val) {
				count[0]++;
				return true;
			}
		}
		return false;		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Node1 tree = new Node1(5);
	        tree.left = new Node1(4);
	        tree.right = new Node1(5);
	        tree.left.left = new Node1(4);
	        tree.left.right = new Node1(4);
	        tree.right.right = new Node1(5);
	        int[] count = new int[1];
	        countUnivalTree2(tree, count);
	        System.out.println(count[0]);
	}

}

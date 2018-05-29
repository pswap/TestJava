public class UniValTrees {
	
	public static boolean countUnidataTree(TreeNode root, int count) {
		if(root == null)
			return false;
		
		boolean r1 = countUnidataTree(root.left, count);
		boolean r2 = countUnidataTree(root.right, count);
		
		if(r1 && r2) {
			TreeNode l = root.left;
			TreeNode r = root.right;
			
			// leaf node
			if(l == null && r == null) {
				count++;
				return true;
			} 
			else if(l!=null  && r!=null && l.data == root.data && r.data == root.data) {
				//both children exists and have same dataue as parent
				count++;
				return true;
			} 
			else if(l!=null && l.data == root.data) {
				//if left child is not null and has same data as parent
				count++;
				return true;
			} else if(r!=null && r.data == root.data) {
				count++;
				return true;
			}
		}
		return false;		
		
	}
	
	public static boolean countUnidataTree2(TreeNode root, int[] count) {
		if(root == null)
			return false;
		
		boolean r1 = countUnidataTree2(root.left, count);
		boolean r2 = countUnidataTree2(root.right, count);
		
		if(r1 && r2) {
			TreeNode l = root.left;
			TreeNode r = root.right;
			
			// leaf node
			if(l == null && r == null) {
				count[0]++;
				return true;
			} 
			else if(l!=null  && r!=null && l.data == root.data && r.data == root.data) {
				//both children exists and have same dataue as parent
				count[0]++;
				return true;
			} 
			else if(l!=null && l.data == root.data) {
				//if left child is not null and has same data as parent
				count[0]++;
				return true;
			} else if(r!=null && r.data == root.data) {
				count[0]++;
				return true;
			}
		}
		return false;		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 TreeNode tree = new TreeNode(5);
	        tree.left = new TreeNode(4);
	        tree.right = new TreeNode(5);
	        tree.left.left = new TreeNode(4);
	        tree.left.right = new TreeNode(4);
	        tree.right.right = new TreeNode(5);
	        int[] count = new int[1];
	        countUnidataTree2(tree, count);
	        System.out.println(count[0]);
	}

}

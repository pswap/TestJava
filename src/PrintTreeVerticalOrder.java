import java.util.*;

class vTreeNode {
	int val;
	vTreeNode left;
	vTreeNode right;
	int level;
	
	vTreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
		this.level = 0;
	}
	public void setlevel(int level) {
		this.level = level;
	}
}

public class PrintTreeVerticalOrder {
	public static void preOrder(TreeNode root, int dist, Map<Integer, List<Integer>> map) {
		if(root == null)
			return;
		
		if(map.get(dist) == null)
			map.put(dist, new ArrayList<Integer>());
		map.get(dist).add(root.val);
		preOrder(root.left, dist-1, map);
		preOrder(root.right, dist+1, map);
			
	}
	
	public static void levelOrder(vTreeNode root, Map<Integer, List<Integer>> map) {
		Queue<vTreeNode> q = new LinkedList<vTreeNode>();
		q.add(root);
		
		while(!q.isEmpty()) {
			vTreeNode n = q.poll();
			int dist = n.level;
			if(map.get(dist) == null)
				map.put(dist, new ArrayList<Integer>());
			map.get(dist).add(n.val);
			if(n.left != null) {
				n.left.setlevel(dist-1);
				q.offer(n.left);
				
			} 
			if(n.right != null) {
				n.right.setlevel(dist+1);
				q.offer(n.right);
			}
		}
	}
	
	public static void printVerticalOrder(Map<Integer, List<Integer>> map) {
		for(List<Integer> l : map.values()) {
			for(int i =0;i<l.size();i++) {
				System.out.print(l.get(i) +" ");
			}
			System.out.println();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(2);
	    root.right = new TreeNode(3);
	    root.left.left = new TreeNode(4);
	    root.left.right = new TreeNode(5);
	    root.right.left = new TreeNode(6);
	    root.right.right = new TreeNode(7);
	    root.right.left.right = new TreeNode(8);
	    root.right.right.right = new TreeNode(9);
	    root.right.right.left= new TreeNode(10);
	    root.right.right.left.right= new TreeNode(11);
	    root.right.right.left.right.right= new TreeNode(12);
		Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
		
		preOrder(root, 0, map);		
		printVerticalOrder(map);
		
		vTreeNode root1 = new vTreeNode(1);
	    root1.left = new vTreeNode(2);
	    root1.right = new vTreeNode(3);
	    root1.left.left = new vTreeNode(4);
	    root1.left.right = new vTreeNode(5);
	    root1.right.left = new vTreeNode(6);
	    root1.right.right = new vTreeNode(7);
	    root1.right.left.right = new vTreeNode(8);
	    root1.right.right.right = new vTreeNode(9);
	    root1.right.right.left= new vTreeNode(10);
	    root1.right.right.left.right= new vTreeNode(11);
	    root1.right.right.left.right.right= new vTreeNode(12);
		Map<Integer, List<Integer>> nmap = new TreeMap<Integer, List<Integer>>();
		levelOrder(root1, nmap);
		printVerticalOrder(nmap);

	}

}

//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74253/Easy-to-understand-Java-Solution
// https://gist.github.com/bittib/5620951
public class SerializeDeserializeTree {
	
	public static void serialize(TreeNode root, StringBuilder sb) {
		if(root == null)
			sb.append("X");
		else {
			sb.append(root.val + ",");
			serialize(root.left, sb);
			serialize(root.right, sb);
		}

	}

	public static TreeNode deserialize(String sb) {
		String[] tmp = sb.split(",");
		return buildTree(tmp, 0);		
	}

	public static TreeNode buildTree(String[] s, int i) {
		String p = s[i];
		if(p.equals('X'))
			return null;
		TreeNode root = new TreeNode(Integer.parseInt(s[i]));
		root.left = buildTree(s, i++);
		root.right = buildTree(s, i++);
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package wc311;

import daily.TreeNode;

public class L6182 {
	public static void main(String[] args) {
		new L6182();
	}

	L6182() {

	}

	public TreeNode reverseOddLevels(TreeNode root) {
		reverse(root);
		return root;
	}

	static void reverse(TreeNode root) {
		bfs(root.left, root.right, 0);
	}

	static void bfs(TreeNode root1, TreeNode root2, int level) {

		if (root1 == null || root2 == null)
			return;

		if (level % 2 == 0) {
			int t = root1.val;
			root1.val = root2.val;
			root2.val = t;
		}

		bfs(root1.left, root2.right, level + 1);
		bfs(root1.right, root2.left, level + 1);
	}

}

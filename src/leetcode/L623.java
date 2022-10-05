package leetcode;

public class L623 {

	public static void main(String[] args) {
		new L623();
	}

	L623() {
	}

	public TreeNode addOneRow(TreeNode root, int val, int depth) {
		// 初始深度為1是例外情況直接做處理
		if (depth == 1) {
			TreeNode n = new TreeNode(val);
			n.left = root;
			root = n;
		}
		// 要從depth-1開始插入原因為
		// 這樣就不用去記你前個node節點
		addNodeOrderDepth(root, val, depth - 1);
		return root;
	}

	private void addNodeOrderDepth(TreeNode root, int val, int depth) {

		if (root == null) {
			return;
		}
		// 到達指定depth開始做插入
		if (depth == 1) {
			TreeNode l = new TreeNode(val);
			TreeNode r = new TreeNode(val);
			l.left = root.left;
			r.right = root.right;
			root.left = l;
			root.right = r;
			return;
		}

		// 向左右繼續尋找
		addNodeOrderDepth(root.left, val, depth - 1);
		addNodeOrderDepth(root.right, val, depth - 1);
	}
}

package daily;

import tool.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class L111 {

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		int depth = 1;
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				TreeNode curr = q.poll();
				if (curr.left == null && curr.right == null)
					return depth;
				if (curr.left != null)
					q.add(curr.left);
				if (curr.right != null)
					q.add(curr.right);
			}
			depth++;
		}
		return depth;
	}
}

package leetcode;

import java.util.HashSet;
import java.util.Set;

public class L653 {
	public static void main(String[] args) {
		new L653();
	}

	L653() {
	}

	Set<Integer> set = new HashSet<>();

	public boolean findTarget(TreeNode root, int k) {

		if (root == null) {
			return false;
		}

		if (set.contains(k - root.val)) {
			// 如果set有存在對應的值則返回true
			return true;
		} else {
			// 把val新增至set
			set.add(root.val);
		}

		// 向左右節點繼續找下去
		return findTarget(root.left, k) || findTarget(root.right, k);
	}
}

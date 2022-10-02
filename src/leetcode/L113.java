package leetcode;

import java.util.LinkedList;
import java.util.List;

public class L113 {
	public static void main(String[] args) {
		new L113();
	}

	L113() {
	}

	List<List<Integer>> ans = new LinkedList<>();
	int ts = 0;

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		ts = targetSum;
		find(root, new LinkedList<>(), 0);
		return ans;
	}

	public void find(TreeNode root, List<Integer> list, int sum) {
		if (root == null) {
			return;
		}

		list.add(root.val);
		sum += root.val;

		if (sum > ts) {
			return;
		}

		if (root.left == null && root.right == null) {
			if (sum == ts) {
				ans.add(list);
			}
			return;
		}

		find(root.left, new LinkedList<>(list), sum);
		find(root.right, new LinkedList<>(list), sum);
	}
}

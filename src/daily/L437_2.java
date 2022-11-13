package daily;

import tool.TreeNode;

import java.util.HashMap;

public class L437_2 {
	public int pathSum(TreeNode root, int sum) {
		HashMap<Long, Integer> preSum = new HashMap<Long, Integer>();
		preSum.put(0L, 1);
		return helper(root, 0, sum, preSum);
	}

	public int helper(TreeNode root, long currSum, int target, HashMap<Long, Integer> preSum) {

		if (root == null) {
			return 0;
		}

		currSum += root.val;
		int res = preSum.getOrDefault(currSum - target, 0);
		preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

		res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
		preSum.put(currSum, preSum.get(currSum) - 1);
		return res;
	}
}

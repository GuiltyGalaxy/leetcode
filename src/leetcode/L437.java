package leetcode;

public class L437 {
	public int pathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return 0;
		}

		return pathSum_a(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
	}

	public int pathSum_a(TreeNode root, long targetSum) {
		if (root == null) {
			return 0;
		}
		int ans = 0;
		if (root.val == targetSum) {
			ans++;
		}
		ans += pathSum_a(root.left, targetSum - root.val);
		ans += pathSum_a(root.right, targetSum - root.val);
		return ans;
	}
}

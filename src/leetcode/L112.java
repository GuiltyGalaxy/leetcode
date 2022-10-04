package leetcode;

public class L112 {

	public boolean hasPathSum(TreeNode root, int targetSum) {

		if (root == null) {
			return false;
		}

		targetSum -= root.val;
		// 葉節點時判斷是否滿足目標
		if (root.left == null && root.right == null) {
			if (targetSum == 0) {
				return true;
			} else {
				return false;
			}
		}
		// 繼續往下找，其中一個達成即可所以用||
		return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
	}

}

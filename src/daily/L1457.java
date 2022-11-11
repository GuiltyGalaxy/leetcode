package daily;

public class L1457 {
	public static void main(String[] args) {
		new L1457();
	}

	L1457() {
	}

	private int ans = 0;

	public int pseudoPalindromicPaths(TreeNode root) {
		dp(root, 0);
		return ans;
	}

	public void dp(TreeNode root, int mask) {
		if (root == null) {
			return;
		}

		mask ^= 1 << root.val;

		if (root.left == null && root.right == null) {
			if (mask == 0 || ((mask & (mask - 1)) == 0)) {
				ans++;
			}
			return;
		}
		dp(root.left, mask);
		dp(root.right, mask);

	}
}

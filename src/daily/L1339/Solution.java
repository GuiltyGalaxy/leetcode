package daily.L1339;

import tool.TreeNode;

class Solution {
    private long max = 0;
    private long total = 0;

    public int maxProduct(TreeNode root) {
        //第一次計算先求出每個節點總和
        total = sum(root);
        sum(root);
        return (int) (max % (int) (1e9 + 7));
    }

    private long sum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        long sub = root.val + sum(root.left) + sum(root.right);
        //第二次計算時total不為0
        //此時total - sub就會得到該節點另一個樹的和
        max = Math.max(max, sub * (total - sub));

        return sub;
    }

}
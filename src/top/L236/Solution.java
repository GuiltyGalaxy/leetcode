package top.L236;

import tool.TreeNode;

class Solution {

    TreeNode lca;

    /**
     * 這題目是要找p,q的LCA(lowest common ancestor)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 假設LCA是p
        if (dfs(p, q.val)) {
            return p;
        }
        // 假設LCA是q
        if (dfs(q, p.val)) {
            return q;
        }
        // 都不是就全部找一遍
        lca(root, p.val, q.val, 1, 0);
        return lca;
    }

    /**
     * 檢查t是否在root中
     */
    public boolean dfs(TreeNode root, int t) {

        if (root == null) {
            return false;
        }

        if (root.val == t) {
            return true;
        }

        return dfs(root.left, t) || dfs(root.right, t);
    }

    public void lca(TreeNode root, int t1, int t2, int d, int maxDepth) {

        if (root == null) {
            return;
        }
        // t1 t2都包含在該root則更新lac與maxDepth
        // d > maxDepth是為了LCA所設定條件，如果沒設會導致後面誤更新LCA，因我們不是使用BFS
        if (d > maxDepth && dfs(root, t1) && dfs(root, t2)) {
            maxDepth = d;
            lca = root;
        }

        // 往下一層找使否有LCA
        lca(root.left, t1, t2, d + 1, maxDepth);
        lca(root.right, t1, t2, d + 1, maxDepth);
    }
}
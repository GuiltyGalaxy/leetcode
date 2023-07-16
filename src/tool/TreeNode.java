package tool;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createTree(Integer... nums) {

        if (nums.length == 0) {
            return new TreeNode();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        queue.add(root);

        int i = 1;
        while (i < nums.length) {
            TreeNode parent = queue.poll();

            Integer leftNum = nums[i++];
            if (leftNum != null) {
                TreeNode left = new TreeNode(leftNum);
                assert parent != null;
                parent.left = left;
                queue.add(left);
            }

            if (i < nums.length) {
                Integer rightNum = nums[i++];
                if (rightNum != null) {
                    TreeNode right = new TreeNode(rightNum);
                    assert parent != null;
                    parent.right = right;
                    queue.add(right);
                }
            }
        }

        return root;
    }

    public static boolean isEquals(TreeNode a, TreeNode b) {

        if (a == null && b == null) return true;

        if (a == null || b == null) return false;

        if (a.val != b.val) return false;

        return isEquals(a.left, b.left) || isEquals(a.right, b.right);
    }

}

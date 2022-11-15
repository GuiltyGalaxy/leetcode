package daily.L222;

import tool.TreeNode;

class Solution {
    public int countNodes(TreeNode root) {

        int h = height(root);
        if (h < 0) {
            return 0;
        }

        //左右高度相同，代表left是填滿的狀態，繼續往right算
        if (height(root.right) == h - 1) {
            //(1 << h)代表left節點數目
            return (1 << h) + countNodes(root.right);
        }

        //高度不同則，代表left非填滿狀態，繼續往left算
        //(1 << h - 1)代表right節點數目
        return (1 << h - 1) + countNodes(root.left);
    }

    /**
     * 往left走可取得最高高度
     */
    private int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
}
package top.L105;

import daily.TreeNode;

class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return create(0, 0, inorder.length, preorder, inorder);
    }

    private TreeNode create(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {

        //邊緣檢測
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }

        //preStart為當前的root的值
        TreeNode root = new TreeNode(preorder[preStart]);
        //於inorder尋找當前preorder[preStart]的index
        //此index特性為
        //於inorder[index]左邊元素一定在preorder[preStart]的left
        //於inorder[index]右邊元素一定在preorder[preStart]的right
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                inIndex = i;
                break;
            }
        }

        //藉由inIndex去區分left right的分割點
        //因preorder的關系 preStart + 1 會為下個left的頂點
        //preStart + inIndex - inStart + 1的算法為，(inIndex - inStart)為offer，加上該offer後+1就為right值
        root.left = create(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = create(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);

        return root;
    }
}
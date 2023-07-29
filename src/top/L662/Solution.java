package top.L662;

import tool.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root, 0));
        int max = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int start = 0;
            int end = 0;
            for (int i = 0; i < size; i++) {
                Node tmp = queue.remove();
                TreeNode node = tmp.node;
                int index = tmp.idx;

                // 紀錄最初的idx
                if (i == 0) {
                    start = index;
                }

                // 紀錄最後的idx
                if (i == size - 1) {
                    end = index;
                }

                // idx在tree下層為當前idx * 2
                if (node.left != null) {
                    queue.add(new Node(node.left, 2 * tmp.idx));
                }

                if (node.right != null) {
                    queue.add(new Node(node.right, 2 * tmp.idx + 1));
                }

            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

    // 用來記錄該節點在該層的idx為多少
    static class Node {
        TreeNode node;
        int idx;

        Node(TreeNode node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }
}
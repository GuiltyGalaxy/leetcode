package top.L116;

import tool.Node;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public Node connect(Node root) {

        if (root == null) {
            return null;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        //BSF
        while (!q.isEmpty()) {
            int size = q.size();
            Queue<Node> t_q = new LinkedList<>();
            while (size-- > 0) {
                Node t_node = q.poll();
                //如果q還有值代表同層還未結束
                if (q.peek() != null) {
                    t_node.next = q.peek();
                }
                if (t_node.left != null && t_node.right != null) {
                    //下一組條件要先暫放於t_q，必免q.peek()會拿到下一組的值
                    t_q.add(t_node.left);
                    t_q.add(t_node.right);
                }
            }
            q.addAll(t_q);
        }
        return root;
    }
}
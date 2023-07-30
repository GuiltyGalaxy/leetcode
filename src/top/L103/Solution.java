package top.L103;

import tool.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        travel(root, 0);
        return res;
    }

    private void travel(TreeNode curr, int level) {

        if (curr == null) {
            return;
        }

        // res第一次進入該level則須新增空的list
        if (res.size() <= level) {
            List<Integer> newLevel = new LinkedList<>();
            res.add(newLevel);
        }

        // 取得對應level資料
        List<Integer> levelSet = res.get(level);
        // 判別要從頭加還是從尾巴加
        if (level % 2 == 0) {
            levelSet.add(curr.val);
        } else {
            levelSet.add(0, curr.val);
        }

        // 往下繼續找(先序)
        travel(curr.left, level + 1);
        travel(curr.right, level + 1);
    }
}
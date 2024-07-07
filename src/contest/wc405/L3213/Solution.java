package contest.wc405.L3213;


class Solution {
    static Node root;
    char[] target;

    public int minimumCost(String target, String[] words, int[] costs) {
        // 初始化字典樹
        // 並客製化紀錄cost
        root = new Node();
        for (int i = 0; i < words.length; i++) {
            insert(words[i].getBytes(), costs[i]);
        }

        // 該dp紀錄對應長度的最小花費
        int[] dp = new int[target.length()];
        this.target = target.toCharArray();
        int res = recursion(dp, 0);

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int recursion(int[] dp, int index) {
        // 長度相同代表找到答案
        if (index == target.length) {
            return 0;
        }
        // 已經找過了就直接回傳dp結果
        if (dp[index] != 0) {
            return dp[index];
        }

        int res = Integer.MAX_VALUE;
        Node n = root;
        for (int i = index; i < target.length; i++) {
            int j = target[i] - 'a';
            if (n.children[j] == null) {
                break;
            }
            n = n.children[j];
            // 找到有符合的字母
            if (n.cost != Integer.MAX_VALUE) {
                // 以當前的index繼續往下找
                int tmp = recursion(dp, i + 1);
                // 有找到解答
                if (tmp != Integer.MAX_VALUE) {
                    res = Math.min(res, tmp + n.cost);
                }
            }
        }

        // 更新dp並回傳結果
        return dp[index] = res;
    }

    private void insert(byte[] b, int cost) {
        Node n = root;
        for (byte value : b) {
            int ix = value - 'a';
            if (n.children[ix] == null) {
                n.children[ix] = new Node();
            }
            n = n.children[ix];
        }
        // 有可能出現同樣的字但cost不同，取最小
        n.cost = Math.min(n.cost, cost);
    }


    static class Node {
        Node[] children;
        int cost;

        Node() {
            cost = Integer.MAX_VALUE;
            children = new Node[26];
        }
    }
}

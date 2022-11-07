package leetcode.L212;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {

        char c = board[i][j];
        //該點已被找過或是不符合p的目標
        if (c == '#' || p.next[c - 'a'] == null) {
            return;
        }

        p = p.next[c - 'a'];
        //word不為null代表找到底了
        //把該word加入答案中
        if (p.word != null) {
            res.add(p.word);
            p.word = null;
        }

        //標註#代表於該call loop找過了
        board[i][j] = '#';
        //往4個方向去找
        if (i > 0) dfs(board, i - 1, j, p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
        //call loop結束把值復原
        board[i][j] = c;
    }

    /**
     * 建立words的有向圖
     * ex. abcd => a->b->c->d
     */
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) {
                    p.next[i] = new TrieNode();
                }
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    static class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
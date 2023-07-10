package top.L212;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private char[][] grid;
    private int M, N;
    private List<String> res;

    public List<String> findWords(char[][] board, String[] words) {
        res = new ArrayList<>();
        grid = board;
        M = board.length;
        N = board[0].length;

        // 建立以字母為基礎的向量圖
        Trie trie = new Trie();
        for (String w : words) {
            trie.insert(w);
        }
        // 找遍所有可能
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                dfs(i, j, "", trie.root);
            }
        }
        return res;
    }

    private void dfs(int i, int j, String curString, TrieNode curNode) {

        if (curNode.isWord) {
            res.add(curString);
            // 找過的字將註記復原
            curNode.isWord = false;
        }

        // 邊界檢測
        if (i < 0 || j < 0 || i >= M || j >= N) {
            return;
        }

        char curChar = grid[i][j];
        if (curChar == '#' || curNode.children[curChar - 'a'] == null) {
            return;
        }

        TrieNode parent = curNode;
        // 往下個節點找
        curNode = curNode.children[curChar - 'a'];
        String nextString = curString + curChar;

        // 先表記為#代表目前正在使用中
        grid[i][j] = '#';
        dfs(i + 1, j, nextString, curNode);
        dfs(i - 1, j, nextString, curNode);
        dfs(i, j + 1, nextString, curNode);
        dfs(i, j - 1, nextString, curNode);
        grid[i][j] = curChar;

        // 由於上方尋找後能確定isWord有被找到的話會被設為false
        // 如果這個字後面都沒有接任何node
        // 則可以把該node移除，因為用不到了，可減少後面被無意義進入的可能
        // 該處理可提升效能600ms -> 20ms
        int a;
        for (a = 0; a < 26; a++) {
            if (curNode.children[a] != null) {
                break;
            }
        }
        if (a == 26) {
            parent.children[curChar - 'a'] = null;
        }
    }

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }

    private static class Trie {
        private final TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                // 字節點為空則建立
                if (cur.children[ch - 'a'] == null) {
                    cur.children[ch - 'a'] = new TrieNode();
                }
                // 指向下一個字
                cur = cur.children[ch - 'a'];
            }
            // 最後結尾註記word
            // 代表該順序可以形成一個字
            cur.isWord = true;
        }
    }
}

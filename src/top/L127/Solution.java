package top.L127;

import java.util.HashSet;
import java.util.List;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> start = new HashSet<>();
        HashSet<String> end = new HashSet<>();
        HashSet<String> dict = new HashSet<>(wordList);

        start.add(beginWord);
        end.add(endWord);

        // endWord不再字典中則無解
        if (!dict.contains(endWord)) {
            return 0;
        }
        // 已使用beginWord、beginWord，所以從2開始
        return bfs(start, end, dict, 2);
    }

    public int bfs(HashSet<String> start, HashSet<String> end, HashSet<String> dict, int step) {
        // 無start代表無結果(next沒有找到任何可以往下計算的)
        if (start.isEmpty()) {
            return 0;
        }

        if (start.size() > end.size()) {
            // start和end輪流計算，以平衡計算量，避免每次答案都在最後一個
            return bfs(end, start, dict, step);
        }
        // 使用start作計算，所以移除dict中的start
        dict.removeAll(start);
        // 開始紀錄下一輪符合的個數
        HashSet<String> next = new HashSet<>();
        for (String s : start) {
            char[] arr = s.toCharArray();
            // 逐個替換其中一個字元
            for (int i = 0; i < arr.length; i++) {
                char tmp = arr[i];
                // a-z都跑一遍
                for (char c = 'a'; c <= 'z'; c++) {
                    if (tmp == c) {
                        continue;
                    }
                    arr[i] = c;
                    // 檢查該差異的情況是否有符合在dic中
                    String tmpString = new String(arr);
                    if (dict.contains(tmpString)) {
                        if (end.contains(tmpString)) {
                            // 找到答案
                            return step;
                        } else {
                            next.add(tmpString);
                        }
                    }
                }
                // 復原arr
                arr[i] = tmp;
            }
        }
        // 往下繼續找
        return bfs(next, end, dict, step + 1);
    }
}
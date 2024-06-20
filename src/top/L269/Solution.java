package top.L269;

import java.util.*;

class Solution {
    public String alienOrder(String[] words) {
        // Step 1: 初始化向量圖
        // 紀錄該字的後面可連接的字
        Map<Character, List<Character>> adjList = new HashMap<>();
        // 紀錄連進節點的字有幾個
        Map<Character, Integer> inDegree = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adjList.putIfAbsent(c, new ArrayList<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        // Step 2: 建立拓譜
        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];
            int len = Math.min(first.length(), second.length());
            boolean foundDifference = false;

            for (int j = 0; j < len; j++) {
                char parent = first.charAt(j);
                char child = second.charAt(j);
                if (parent != child) {
                    // 由於是按字典排序，所以可確定如果字不同則parent一定排序child前面
                    adjList.get(parent).add(child);
                    inDegree.put(child, inDegree.get(child) + 1);
                    foundDifference = true;
                    break;
                }
            }

            // 比如說abc ab這種情況會造成無法確立字母順序，直接返回
            if (!foundDifference && first.length() > second.length()) {
                return "";
            }
        }

        // Step 3: BFS
        Queue<Character> queue = new LinkedList<>();
        for (char c : inDegree.keySet()) {
            // 從沒有任何進入的字開始找
            if (inDegree.get(c) == 0) {
                queue.add(c);
            }
        }

        // 有多種情況下inDegree.get(c)會不只一個
        // 所以題目只要我們提供合法排序即可
        // 舉例
        // a->c
        // b->c
        // 這是a b都為0，所以輸出abc、bac都可符合
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char current = queue.poll();
            sb.append(current);
            // 找過所有相鄰點把inDegree更新
            for (char neighbor : adjList.get(current)) {
                // 移掉
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                // 如果移掉該點後inDegree為0則加入下一個BFS
                if (inDegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // inDegree最後大小等同於sb表示所有字都排到了，有找到排序正常返回
        if (sb.length() == inDegree.size()) {
            return sb.toString();
        } else {
            return "";
        }
    }
}
package top.L721;

import java.util.*;

class Solution {

    int[] root;
    int[] rank;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        root = new int[accounts.size()];
        rank = new int[accounts.size()];

        // 初始化union
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
            rank[i] = 1;
        }

        // emailMap記錄所有email對應的root
        Map<String, Integer> emailMap = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            // i = 0 是名子就跳過不計了
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (!emailMap.containsKey(email)) {
                    emailMap.put(email, i);
                } else {
                    //存在情況下合併
                    union(emailMap.get(email), i);
                }
            }
        }


        // 把整理過的emailMap轉換成Map<Integer, List<String>>
        Map<Integer, List<String>> resultMap = new HashMap<>();
        emailMap.forEach((k, v) -> resultMap.computeIfAbsent(find(v), ArrayList::new).add(k));

        // 將resultMap的value對上accounts name轉成答案
        List<List<String>> result = new ArrayList<>();
        resultMap.forEach((k, v) -> {
            List<String> tmp = new ArrayList<>(v);
            Collections.sort(tmp);
            // 把原本名子加到第一個
            tmp.add(0, accounts.get(k).get(0));
            result.add(tmp);
        });

        return result;
    }

    private int find(int target) {
        if (target == root[target]) {
            return target;
        }
        return root[target] = find(root[target]);
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            // 比較大的合集去合併較小的
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

}
package top.L721;

import java.util.*;

class Solution {
    int[] root;
    int[] rank;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        root = new int[accounts.size()];
        rank = new int[accounts.size()];

        //初始化union
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
            rank[i] = 1;
        }

        //emailMap記錄所有email對應的root
        Map<String, Integer> emailMap = new HashMap<>();
        int idx = 0;
        for (List<String> account : accounts) {
            // i = 0 是名子就跳過不計了
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!emailMap.containsKey(email)) {
                    emailMap.put(email, idx);
                } else {
                    //存在情況下合併
                    union(emailMap.get(email), idx);
                }
            }
            idx++;
        }

        List<List<String>> result = new ArrayList<>();
        Map<Integer, List<String>> resultMap = new HashMap<>();

        //把整理過的emailMap轉換成Map<Integer, List<String>>
        for (Map.Entry<String, Integer> entry : emailMap.entrySet()) {
            resultMap.computeIfAbsent(find(entry.getValue()), ArrayList::new).add(entry.getKey());
        }

        //將resultMap的value對上accounts name轉成答案
        for (Map.Entry<Integer, List<String>> entry : resultMap.entrySet()) {
            List<String> ll = new ArrayList<>(entry.getValue());
            Collections.sort(ll);
            ll.add(0, accounts.get(entry.getKey()).get(0));
            result.add(ll);
        }

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
            //合併的條件為rank較大小的合併至較大的
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                //相同情況則以x為主(給x,y其實都沒差)
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

}
package daily.L947;

import java.util.HashSet;

class Solution {

    int[] parent = new int[20005];
    int[] rank = new int[20005];

    public int removeStones(int[][] stones) {
        //初始化對應表
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        //計算union
        for (int i = 0; i < stones.length; i++) {
            union(stones[i][0], stones[i][1] + 10001);
        }
        //統計整理過的parent
        //看剩下那些集團集合
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < stones.length; i++) {
            set.add(findRoot(stones[i][0]));
        }
        //集團數目就代表最後剩下的石頭
        return stones.length - set.size();
    }

    public int findRoot(int node) {
        if (node == parent[node])
            return node;
        //不斷找尋最大的Root
        //並且把尋找路徑上的parent[node]都設定成Root
        return parent[node] = findRoot(parent[node]);
    }

    public void union(int x, int y) {
        int a = findRoot(x);
        int b = findRoot(y);
        if (rank[a] > rank[b]) {
            //a集團比較大則b跟隨a
            parent[b] = a;
        } else if (rank[a] < rank[b]) {
            //b集團比較大則a跟隨b
            parent[a] = b;
        } else {
            //a b集團大小相同
            //則向基數大的靠齊
            parent[a] = b;
            rank[b]++;
        }
    }
}
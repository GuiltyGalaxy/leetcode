package leetcode.L433;

import java.util.*;

class Solution {
    public int minMutation(String start, String end, String[] bank) {
        //初始化set
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        //set中沒有end則不可能有答案
        if (!bankSet.contains(end)) {
            return -1;
        }


        int ans = -1;
        //紀錄已經過的bank
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int size = q.size();
            ans++;
            for (int i = 0; i < size; i++) {
                String cur_s = q.poll();
                if (end.equals(cur_s)) {
                    return ans;
                }
                //將此bank記錄成已走訪過
                visited.add(cur_s);
                for (String s : bankSet) {
                    //set中的bank尚未出現於visited，且符合差異只有1的情況
                    //加入到queue中執行下一次
                    if (isOneDiff(cur_s, s) && !visited.contains(s)) {
                        q.add(s);
                    }
                }
            }
        }
        return -1;
    }


    public boolean isOneDiff(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                cnt++;
                if (cnt >= 2) {
                    return false;
                }
            }
        }
        return cnt == 1;
    }
}
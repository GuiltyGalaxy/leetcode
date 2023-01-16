package top.L128;

import tool.TreeNode;

import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int ans = 0;
        //這邊如果用int num:nums會很慢，不知道是不是set有優化
        for(int s:set){
            //s-1是確保該數字一定是頭
            if(!set.contains(s-1)){
                int cnt = 0;
                //計算最大連續
                while(set.contains(s+cnt+1))cnt++;
                ans = Math.max(ans,cnt+1);
            }
        }
        return ans;
    }
}
package top.L55;

class Solution {
    public boolean canJump(int[] nums) {
        // 只要紀錄最遠可以到哪
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果最遠距離倒不了就提前返回了
            if (i > maxReach) {
                return false;
            }

            maxReach = Math.max(maxReach, i + nums[i]);
            // 最遠距離已可到達目標提前返回
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        // 最遠距離超過nums長度代表可以抵達
        return maxReach >= nums.length - 1;
    }
}
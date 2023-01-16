package top.L75;

class Solution {
    public void sortColors(int[] nums) {
        //紀錄0 1 2次數
        int[] set = new int[3];
        for (int num : nums) {
            set[num]++;
        }
        int idx = 0;
        int cur = 0;
        //依照所記錄的次數設定
        for (int c : set) {
            for (int i = 0; i < c; i++) {
                nums[idx++] = cur;
            }
            cur++;
        }
    }
}
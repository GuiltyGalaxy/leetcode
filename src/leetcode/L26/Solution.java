package leetcode.L26;

class Solution {
    public int removeDuplicates(int[] nums) {
        //目前index最新位子
        int head = 0;
        for (int i : nums) {
            //head == 0為初始化
            //之後都比較 i > nums[head-1]，當i比目前head-1還大時，則放入最新head
            if (head == 0 || i > nums[head - 1]) {
                nums[head++] = i;
            }
        }
        return head;
    }
}
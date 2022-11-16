package top.L324;

import java.util.Arrays;

class Solution {

    //O(nlog(n)) S(n)
    public void wiggleSort(int[] nums) {
        int[] tmp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmp);
        //使用兩個index，一個從最後，一個從中間取
        int last = nums.length - 1;
        int mid = nums.length / 2 + nums.length % 2 - 1;
        //從後取tmp，並從頭交替擺放
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = tmp[mid--];
            //長度為even會少補一個
            if (i < nums.length - 1) {
                nums[i + 1] = tmp[last--];
            }
        }
    }
}
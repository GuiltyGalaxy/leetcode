package top.L287;

import java.util.HashSet;
import java.util.Set;

class Solution {

    //O(n) S(n)
    public int findDuplicate(int[] nums) {
        //簡單使用arrayr紀錄重複
        boolean[] isDuplicate = new boolean[nums.length];
        for (int n : nums) {
            if (isDuplicate[n]) {
                return n;
            } else {
                isDuplicate[n] = true;
            }
        }
        return 0;
    }

    //O(n) S(1)
    public int findDuplicate_index_sort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; ) {
            int n = nums[i];
            if (n == i + 1) {
                //該數位子正確移至下個
                i++;
            } else if (n == nums[n - 1]) {
                //正在排序的數字等於前一個排序代表重複
                return n;
            } else {
                //交換數字 i <=> n-1
                nums[i] = nums[n - 1];
                nums[n - 1] = n;
            }
        }

        return 0;
    }

    //O(n) S(1)
    public int findDuplicate_fastSlow(int[] nums) {
        int slow = 0;
        int fast = 0;
        //nums[]{1,3,4,2,2}可看成 1 > 3 > 4 > 2 > 2
        //且有一處會形成循環
//        0->1
//        1->3
//        2->4
//        3->2
//        4->2
//
//        0->1->3->2->4->2->4->2->…
        //使用快慢針
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        //此時fast會指在循環處
        slow = 0;
        //不斷循環直到slow == fast
        //此時slow就是重複的那個
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

}
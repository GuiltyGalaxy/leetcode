package top.L234;

import tool.ListNode;

class Solution {
    public boolean isPalindrome(ListNode head) {
        // 這題一般來說就取中間後反轉
        // 再把兩個節點依序比較
        // 但這解法可以只跑一次while
        // 利用數字的特性
        // 題目限制剛好val要是個位數
        // 且最大節點數為10^5
        // 才可以用這個解法
        int num = 0;
        int rev = 0;
        int mul = 1;

        while (head != null) {
            // num的數字會從後面append
            num = num * 10 + head.val;
            // rev的數字會從前面append
            rev = head.val * mul + rev;
            mul *= 10;
            head = head.next;
        }

        // 最後相等為Palindrome
        return num == rev;
    }
}
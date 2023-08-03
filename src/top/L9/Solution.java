package top.L9;

class Solution {
    public boolean isPalindrome(int x) {
        int sum = 0;
        int temp = x;
        // 負的不可能會相等
        if (temp < 0) {
            return false;
        }
        while (x > 0) {
            sum = sum * 10 + x % 10;
            x /= 10;
        }
        return sum == temp;

    }
}

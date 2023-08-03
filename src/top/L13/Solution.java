package top.L13;

class Solution {
    public int romanToInt(String s) {
        int res = 0;
        int num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'I' -> num = 1;
                case 'V' -> num = 5;
                case 'X' -> num = 10;
                case 'L' -> num = 50;
                case 'C' -> num = 100;
                case 'D' -> num = 500;
                case 'M' -> num = 1000;
            }

            // 利用數字大的會在前面的特性
            // 如果當前數字*4都沒有比res大
            // 代表該數字是當作修飾用
            // 所以提前先減去
            if (4 * num < res) {
                res -= num;
            } else {
                res += num;
            }
        }
        return res;
    }
}
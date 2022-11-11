package top.L179;

import java.util.PriorityQueue;

class Solution {
    public String largestNumber(int[] nums) {

        //最大的數字組合剛好會為lexicographically
        //不過"3" "30"這種狀況"30"會排前面，這樣會不符合
        //所以暫時組合字串
        //使用"330" "303"去比較
        PriorityQueue<String> q = new PriorityQueue<>((a, b) -> {
            String t1 = a + b;
            String t2 = b + a;
            return t2.compareTo(t1);
        });

        for (int n : nums) {
            q.offer(String.valueOf(n));
        }
        //排除都為0的特殊狀況
        if (q.peek() != null && q.peek().equals("0")) {
            return "0";
        }

        //組合String
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            sb.append(q.poll());
        }
        return sb.toString();
    }
}
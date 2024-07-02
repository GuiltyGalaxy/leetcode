package top.L125;

public class Solution {
    public boolean isPalindrome(String s) {
        char[] ca = s.toLowerCase().toCharArray();
        int L = 0;
        int R = s.length()-1;
        while(L < R){
            while(L < R && !Character.isLetterOrDigit(ca[L]))L++;
            while(L < R && !Character.isLetterOrDigit(ca[R]))R--;
            if(ca[L] != ca[R]){
                return false;
            }
            L++;
            R--;
        }
        return true;
    }
}
package daily.L1323;

class Solution {
    public int maximum69Number(int num) {
        char[] c = String.valueOf(num).toCharArray();
        //把第一個遇到的6換就是答案了
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '6') {
                c[i] = '9';
                break;
            }
        }
        return Integer.parseInt(String.valueOf(c));
    }
}
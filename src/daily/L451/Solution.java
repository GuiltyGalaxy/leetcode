package daily.L451;

class Solution {


    // O(N*75)
    public String frequencySort(String s) {

        //size: '0'=48 ~ 'z'=122
        int[] a = new int[75];

        //統計字母
        for (char c : s.toCharArray()) {
            a[c - '0']++;
        }

        StringBuilder sb = new StringBuilder();

        while (sb.length() != s.length()) {
            int max_freq = 0;
            //尋找出現最多次的字母
            for (int i = 0; i < a.length; i++) {
                if (a[i] > a[max_freq]) {
                    max_freq = i;
                }
            }
            //先將出現較多子母擺在前面
            sb.append(String.valueOf((char) (max_freq + '0')).repeat(a[max_freq]));
            a[max_freq] = 0;
        }

        return sb.toString();
    }
}
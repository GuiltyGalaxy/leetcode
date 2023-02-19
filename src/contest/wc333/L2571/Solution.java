package contest.wc333.L2571;


class Solution {
    public int minOperations(int n) {
        //排除邊界條件
        if (n == 1 || n == 2) {
            return 1;
        }
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(n)).reverse();
        int ans = 0;
        int cnt = 0;
        char[] cs = sb.toString().toCharArray();
        //如果要得到最小異動數為0的情況，勢必就等同於要把bit中的1都去掉
        //比如說1000100的最小為0數是2，因有2個bit為1
        //不過要考慮連續兩個1的情況
        //像是1001110如果按上面邏輯答案會是4
        //但實際上我們可以 1001110 + 10 = 1010000，這時答案為2
        //所以當1連續出現兩次以上，都可以簡化成2步驟移除
        for (int i = 0; i < cs.length - 1; i++) {
            if (cs[i] == '1' && cs[i + 1] == '0') {
                ans++;
                //先前有出現連續1的情況要做進位
                if (cnt > 0) {
                    cs[i + 1] = '1';
                    cnt = 0;
                }
            } else if (cs[i] == '1' && cs[i + 1] == '1') {
                ///連續1先不做處理
                cnt++;
            }
        }
        //如果頭連續為1則要兩步移除
        // 110 + 10 => 1000 - 1000 => 0
        return ans + (cnt == 0?1:2);
    }

}
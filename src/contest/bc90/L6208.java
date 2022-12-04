package contest.bc90;

import java.util.Arrays;

public class L6208 {
    L6208() {

    }

    public static void main(String[] args) {
        new L6208();
    }

    public String oddString(String[] words) {
        int[] dif = getDif(words[0]);
        int i = 1;
        for (; i < words.length; i++) {
            int[] now = getDif(words[i]);
            //比較兩字串是否等差
            if (!Arrays.equals(dif, now)) {
                break;
            }
        }
        //第一個不同的情況要做判定
        if (i == 1) {
            if (Arrays.equals(getDif(words[1]), getDif(words[2]))) {
                return words[0];
            } else {
                return words[1];
            }
        }
        return words[i];
    }

    /**
     * 取得s的等差int array
     */
    public int[] getDif(String s) {
        int[] ret = new int[s.length() - 1];
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length - 1; i++) {
            ret[i] = c[i] - c[i + 1];
        }
        return ret;
    }
}

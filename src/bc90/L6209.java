package bc90;

import java.util.LinkedList;
import java.util.List;

public class L6209 {
    L6209() {

    }

    public static void main(String[] args) {
        new L6209();
    }

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new LinkedList<>();
        //把每個都比過一遍O(len*N^2)
        for (String q : queries) {
            for (String d : dictionary) {
                if (isOK(q, d)) {
                    ans.add(q);
                    break;
                }
            }
        }
        return ans;
    }

    /**
     * 比較a,b是否差異不超過2個字
     */
    public boolean isOK(String a, String b) {
        int cnt = 0;
        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();
        for (int i = 0; i < a.length(); i++) {
            if (as[i] != bs[i]) {
                cnt++;
                if (cnt > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}

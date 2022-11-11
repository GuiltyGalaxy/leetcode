package daily;

import java.util.HashMap;

public class L76 {

    L76() {
    }

    public static void main(String[] args) {
        new L76();
    }

    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }
        //計算t的字母個數
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            int i = map.getOrDefault(c, 0);
            map.put(c, i + 1);
        }
        //當前left
        int left = 0;
        //已知最小left
        int minLeft = 0;
        //目前最小長度
        int minLen = s.length() + 1;
        //以符合數量
        int count = 0;
        for (int right = 0; right < s.length(); right++) {
            //當前s是否符合目標字串
            if (map.containsKey(s.charAt(right))) {
                //map字串-1
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                //NOTE
                //s中符合的字母是可能多於t的
                //所以要注意>=0才做處理
                if (map.get(s.charAt(right)) >= 0) {
                    count++;
                }
                //當前窗口達到目標
                while (count == t.length()) {
                    //比minLen還小就更新
                    if (right - left + 1 < minLen) {
                        minLeft = left;
                        minLen = right - left + 1;
                    }
                    //如果移除的字是在map中
                    //則要把他加回去
                    //維持窗口count正常
                    if (map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        //同理前段NOTE說明
                        if (map.get(s.charAt(left)) > 0) {
                            count--;
                        }
                    }
                    left++;
                }
            }
        }

        if (minLen > s.length()) {
            return "";
        }

        return s.substring(minLeft, minLeft + minLen);
    }
}

package top.L127;

import java.util.HashSet;
import java.util.List;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> start = new HashSet<>();
        HashSet<String> end = new HashSet<>();
        HashSet<String> dic = new HashSet<>(wordList);

        start.add(beginWord);
        end.add(endWord);

        if (!dic.contains(endWord)) {
            return 0;
        }
        //已使用beginWord、beginWord，所以從2開始
        return bfs(start, end, dic, 2);
    }

    public int bfs(HashSet<String> start, HashSet<String> end, HashSet<String> dic, int step) {
        //沒有st了代表無結果
        if (start.size() == 0) {
            return 0;
        }

        if (start.size() > end.size()) {
            //start和end挑少的來做，不一定都要以start為起始
            return bfs(end, start, dic, step);
        }
        //移除dic中的start，確保下次不會再拿到
        dic.removeAll(start);
        //開始紀錄下一輪符合的個數
        HashSet<String> next = new HashSet<>();
        for (String s : start) {
            char[] arr = s.toCharArray();
            //逐個替換其中一個字元
            for (int i = 0; i < arr.length; i++) {
                char tmp = arr[i];
                //a-z都跑一遍
                for (char c = 'a'; c <= 'z'; c++) {
                    if (tmp == c) {
                        continue;
                    }
                    arr[i] = c;
                    //檢查該差異的情況是否有符合在dic中
                    String nstr = new String(arr);
                    if (dic.contains(nstr)) {
                        if (end.contains(nstr)) {
                            //找到答案
                            return step;
                        } else {
                            next.add(nstr);
                        }
                    }
                }
                //復原arr
                arr[i] = tmp;
            }
        }
        //往下繼續找
        return bfs(next, end, dic, step + 1);
    }
}
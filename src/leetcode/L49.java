package leetcode;

import java.util.*;

public class L49 {
    L49() {

    }

    public static void main(String[] args) {
        new L49();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            //按照字母排序
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = new String(ca);
            //排序相同代表為相同的set
            List<String> list = map.getOrDefault(key, new LinkedList<>());
            list.add(s);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

}

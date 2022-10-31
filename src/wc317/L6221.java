package wc317;


import java.util.*;

public class L6221 {
    L6221() {
        mostPopularCreator(new String[]{"a", "a", "a", "b"}, new String[]{"a", "a", "a", "a"}, new int[]{100000, 100000, 100000, 100000});
    }

    public static void main(String[] args) {
        new L6221();
    }

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {

        //計算總分
        Map<String, Long> map = new HashMap<>();
        //計算該creators最高分的
        Map<String, Integer> map2 = new HashMap<>();

        long max = 0;

        for (int i = 0; i < creators.length; ++i) {
            map.put(creators[i], map.getOrDefault(creators[i], 0L) + views[i]);
            map2.put(creators[i], Math.max(map2.getOrDefault(creators[i], 0), views[i]));

            max = Math.max(max, map.get(creators[i]));
        }

        Map<String, String> res = new HashMap<>();

        for (String key : map.keySet()) {
            //先記錄那些有符合最高分
            if (map.get(key) == max) {
                //預設zzzzzz是為了符合字典順序，所以預設為最大
                res.put(key, "zzzzzz");
            }
        }

        for (int i = 0; i < creators.length; ++i) {
            //要為最大總分creators
            boolean condition1 = res.containsKey(creators[i]);
            //符合creators中views最高分
            boolean condition2 = views[i] == map2.get(creators[i]);
            //符合id最小字典順序
            boolean condition3 = ids[i].compareTo(res.get(creators[i])) <= 0;
            if (condition1 && condition2 && condition3) {
                res.put(creators[i], ids[i]);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for (String key : res.keySet()) {
            result.add(Arrays.asList(key, res.get(key)));
        }

        return result;
    }


}

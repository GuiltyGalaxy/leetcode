package top.L692;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> frequencyMap = new HashMap<>();

        // 統計每個字的出現頻率
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // 按照次數出現頻率排序
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        entryList.sort((a, b) -> {
            if (a.getValue().equals(b.getValue())) {
                // 次數一樣用字典排序決定
                return a.getKey().compareTo(b.getKey());
            }
            return b.getValue() - a.getValue();
        });

        // 取前k個多次元素
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(entryList.get(i).getKey());
        }

        return result;
    }
}
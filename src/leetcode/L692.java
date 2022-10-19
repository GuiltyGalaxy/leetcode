package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class L692 {

	public static void main(String[] args) {
		new L692();
	}

	L692() {
		topKFrequent(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 2);
	}

	public List<String> topKFrequent(String[] words, int k) {
		// 先用map紀錄次數
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		// 使用PriorityQueue
		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((e1, e2) -> {
			String word1 = e1.getKey();
			int freq1 = e1.getValue();
			String word2 = e2.getKey();
			int freq2 = e2.getValue();
			// 頻率高的在前
			if (freq1 != freq2) {
				return freq2 - freq1;
			} else {
				// 頻率相同則照字典排
				return word1.compareTo(word2);
			}
		});

		for (Map.Entry<String, Integer> e : map.entrySet()) {
			pq.offer(e);
		}

		// PriorityQueue結果取K值就為答案
		List<String> ans = new LinkedList<>();
		for (int i = 0; i <= k - 1; i++) {
			ans.add(pq.poll().getKey());
		}

		return ans;
	}

}

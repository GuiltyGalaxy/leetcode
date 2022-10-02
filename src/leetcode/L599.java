package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class L599 {

	public static void main(String[] args) {
		new L599();
	}

	L599() {
		findRestaurant(new String[] { "Shogun", "Tapioca Express", "Burger King", "KFC" },
				new String[] { "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun" });
	}

	public String[] findRestaurant(String[] list1, String[] list2) {

		Map<String, Integer> m1 = new HashMap<>();
		Map<String, Integer> m2 = new HashMap<>();
		Map<String, Integer> m3 = new HashMap<>();
		List<String> list = new LinkedList<>();

		int i = 0;
		for (String key : list1) {
			m1.put(key, i);
			i++;
		}

		i = 0;
		for (String key : list2) {
			m2.put(key, i);
			i++;
		}

		int min = Integer.MAX_VALUE;

		for (Entry<String, Integer> s : m1.entrySet()) {
			String k = s.getKey();
			int v = s.getValue();
			if (m2.containsKey(k)) {
				int sum = v + m2.get(k);
				m3.put(k, sum);
				min = Math.min(min, sum);
			}
		}

		for (Entry<String, Integer> s : m3.entrySet()) {
			String k = s.getKey();
			int v = s.getValue();
			if (v == min) {
				list.add(k);
			}
		}
		return list.toArray(new String[0]);
	}
}

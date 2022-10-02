package wc312;

import java.util.PriorityQueue;

public class L6188 {
	public static void main(String[] args) {
		new L6188();
	}

	L6188() {
		sortPeople(new String[] { "Mary", "John", "Emma" }, new int[] { 180, 165, 170 });
	}

	public String[] sortPeople(String[] names, int[] heights) {
		String[] ans = new String[names.length];
		PriorityQueue<String[]> pq = new PriorityQueue<>((a, b) -> {
			int ia = Integer.valueOf(a[1]);
			int ib = Integer.valueOf(b[1]);
			return ib - ia;
		});
		for (int i = 0; i < names.length; i++) {
			String[] st = new String[2];
			st[0] = names[i];
			st[1] = String.valueOf(heights[i]);
			pq.add(st);
		}
		int idx = 0;
		while (!pq.isEmpty()) {
			ans[idx++] = pq.poll()[0];
		}
		return ans;
	}
}

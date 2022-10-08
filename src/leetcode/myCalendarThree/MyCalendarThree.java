package leetcode.myCalendarThree;

import java.util.TreeMap;

public class MyCalendarThree {
	public static void main(String[] args) {
		MyCalendarThree myCalendarThree = new MyCalendarThree();
		// return 1, The first event can be booked and is disjoint, so the maximum
		// k-booking is a 1-booking.
		myCalendarThree.book(10, 20);
		// return 1, The second event can be booked and is disjoint, so the maximum
		// k-booking is a 1-booking.
		myCalendarThree.book(50, 60);
		// return 2, The third event [10, 40) intersects the first event, and the
		// maximum k-booking is a 2-booking.
		myCalendarThree.book(10, 40);
		// return 3, The remaining events cause the maximum K-booking to be only a
		// 3-booking.
		myCalendarThree.book(5, 15);
		// return 3
		myCalendarThree.book(5, 10);
		// return 3
		myCalendarThree.book(25, 55);
	}

	// 使用treemap有自動排序功能
	TreeMap<Integer, Integer> map;

	public MyCalendarThree() {
		map = new TreeMap<>();
	}

	// O(N^2)
	public int book(int s, int e) {
		// 起始點紀錄為1
		map.put(s, map.getOrDefault(s, 0) + 1);
		// 結束點紀錄為-1
		map.put(e, map.getOrDefault(e, 0) - 1);
		int ans = 0;
		int tmp = 0;
		// 計算當前map中最高堆疊
		for (int i : map.values()) {
			tmp += i;
			ans = Math.max(ans, tmp);
		}
		return ans;
	}
}

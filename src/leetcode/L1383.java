package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class L1383 {
	public static void main(String[] args) {
		new L1383();
	}

	L1383() {
		// 60
		maxPerformance(5, new int[] { 10, 10, 7, 9, 8 }, new int[] { 9, 8, 3, 6, 9 }, 1);
	}

	public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
		Queue<Integer> q = new PriorityQueue<Integer>();
		// 按照efficiency由高至低排序(efficiency相同時，小的speed在前)
		// 這地方是重點，因題目計算方式是拿最小效率去計算
		// 所以這樣排序可以使貪婪演算法成立
		// 只要不斷往下選的同時計算一次當前最大效率即可
		// *用內建sort不知為什麼比較慢*
		mergeSort(efficiency, speed, 0, n);
		long sum = 0;
		long max = 0;
		for (int i = 0; i < n; i++) {
			// 當q中還未選到指定數量k時，直接新增至q中
			if (q.size() < k) {
				q.add(speed[i]);
				sum += speed[i];
				long t = sum * efficiency[i];
				max = Long.max(max, t);
			}
			// 選滿的情況下最小speed拿出來與現在speed比
			// 現在speed比較大時則替換掉並重新計算當前效能
			else if (q.peek() < speed[i]) {
				sum -= q.remove();
				q.add(speed[i]);
				sum += speed[i];
				long t = sum * efficiency[i];
				max = Long.max(max, t);
			}
		}
		max = max % 1000000007;
		return (int) max;
	}

	public static void mergeSort(int[] nums, int[] indices, int start, int end) {
		if (start + 1 >= end) {
			return;
		}
		int mid = (start + end) / 2;
		mergeSort(nums, indices, start, mid);
		mergeSort(nums, indices, mid, end);
		merge(nums, indices, start, mid, end);
	}

	public static void merge(int[] nums, int[] indices, int start, int mid, int end) {
		int i = start;
		int j = mid;
		int[] temp = new int[end - start];
		int[] tempo = new int[end - start];
		int k = 0;
		while (i < mid && j < end) {
			if (nums[i] > nums[j]) {
				tempo[k] = indices[i];
				temp[k++] = nums[i++];
			} else {
				tempo[k] = indices[j];
				temp[k++] = nums[j++];
			}
		}
		while (i < mid) {
			tempo[k] = indices[i];
			temp[k++] = nums[i++];
		}
		while (j < end) {
			tempo[k] = indices[j];
			temp[k++] = nums[j++];
		}
		k = 0;
		for (i = start; i < end; i++) {
			indices[i] = tempo[k];
			nums[i] = temp[k++];
		}
	}
}

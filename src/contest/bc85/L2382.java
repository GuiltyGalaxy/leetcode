package contest.bc85;

import java.util.TreeMap;

public class L2382 {
	public static void main(String[] args) {
		new L2382();
	}

	L2382() {

	}

	public long[] maximumSegmentSum(int[] nums, int[] quer) {
		long[] result = new long[nums.length];
		long[] prefix = new long[nums.length];

		long sum = 0;

		for (int i = 0; i < nums.length; ++i) {
			sum += nums[i];
			prefix[i] = sum;
		}

		TreeMap<Integer, Integer> segments = new TreeMap<>();
		TreeMap<Long, Integer> segSums = new TreeMap<>();

		segments.put(0, nums.length - 1);
		segSums.put(sum, 1);
		long max = sum;
		int idx = 0;

		boolean shouldCheck;

		int l, r, val;

		for (int query : quer) {
			l = segments.floorKey(query);
			r = segments.get(l);
			segments.remove(l);
			nums[query] = 0;

			shouldCheck = false;

			sum = prefix[r] - (l == 0 ? 0 : prefix[l - 1]);

			if (sum == max)
				shouldCheck = true;

			if (query > l) {
				segments.put(l, query - 1);
			}

			if (query < r) {
				segments.put(query + 1, r);
			}

			if (shouldCheck) {
				max = 0;
				for (int key : segments.keySet()) {
					val = segments.get(key);
					sum = prefix[val] - (key == 0 ? 0 : prefix[key - 1]);
					max = Math.max(max, sum);
				}
			}

			result[idx++] = max;
		}

		return result;
	}
}

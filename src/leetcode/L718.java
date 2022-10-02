package leetcode;

import java.util.HashSet;
import java.util.Set;

public class L718 {
	public static void main(String[] args) {
		new L718();
	}

	L718() {
		findLength(new int[] { 9, 9, 9, 9, 2, 1 }, new int[] { 8, 8, 8, 8, 2, 1 });
	}

	public final static int PRIME = 101;

	/**
	 * Binary Search with Rolling Hash<br>
	 * O(n * log(m1)) + O(m * log((m1)) + O((n + m) * log(min(n, m)))<br>
	 * https://www.geeksforgeeks.org/find-the-longest-common-substring-using-binary-search-and-rolling-hash/
	 */
	public int findLength(int[] nums1, int[] nums2) {

		int len1 = nums1.length;
		int len2 = nums2.length;

		// �����\�b�e��
		if (len2 > len1) {
			return findLength(nums2, nums1);
		}

		int min = Math.min(len1, len2);

		// hash�]�l
		long[] power = new long[len1];
		power[0] = 1;
		for (int i = 1; i < len1; ++i) {
			power[i] = (power[i - 1] * PRIME);
		}

		int left = 0;
		int right = min + 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (check(mid, nums1, nums2, power)) {
				// �Hmid�����ɦ����ۦPhash
				// �N��i�H�Nleft�ɩw��mid
				left = mid + 1;
			} else {
				// �Hmid�����ɨS�����ۦPhash
				// �h���s�ɩwright
				right = mid;
			}
		}
		if (left == 0) {
			return 0;
		}
		return left - 1;
	}

	/**
	 * �ˬd�Hlen�����ɪ����khash�ȬO�_�۵�<br>
	 * �ϥ�Rolling Hash�t��k
	 */
	private boolean check(int len, int[] nums1, int[] nums2, long[] power) {

		if (len == 0) {
			return false;
		}

		int len1 = nums1.length;
		int len2 = nums2.length;

		Set<Long> set = new HashSet<>();
		// ����nums2�O�]���L���פ@�w��1�p
		// �p��nums2���C�ӲզXhash��
		long hash1 = 0;
		for (int i = 0; i < len; ++i) {
			hash1 = (hash1 * PRIME + nums2[i] + 1);
		}
		set.add(hash1);

		for (int i = 0; i <= len2 - len - 1; ++i) {
			int num = nums2[i] + 1;
			int num2 = nums2[i + len] + 1;
			hash1 = (hash1 - (power[len - 1] * num));
			hash1 = (hash1 * PRIME + num2);
			set.add(hash1);
		}
		// �p��nums1 hash
		long hash2 = 0;
		for (int i = 0; i < len; ++i) {
			hash2 = (hash2 * PRIME + nums1[i] + 1);
		}
		// �o�Ӭ۵��N��r�꧹���۲�
		if (set.contains(hash2)) {
			return true;
		}

		for (int i = 0; i <= len1 - len - 1; ++i) {
			int num = nums1[i] + 1;
			int num2 = nums1[i + len] + 1;
			hash2 = (hash2 - (power[len - 1] * num));
			hash2 = (hash2 * PRIME + num2);
			if (set.contains(hash2)) {
				return true;
			}
		}

		return false;
	}
}

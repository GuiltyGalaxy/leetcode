package leetcode;

public class L1770 {
	public static void main(String[] args) {
		new L1770();
	}

	L1770() {
		maximumScore(new int[] { -5, -3, -3, -2, 7, 1 }, new int[] { -10, -5, 3, 4, 6 });
	}

	public int maximumScore(int[] nums, int[] multipliers) {
		int n = nums.length;
		int m = multipliers.length;
		int[][] dp = new int[m + 1][m + 1];

		// �Q�ΰ��]�Ѿl�ƥت��i��ʥh�����p��
		// ���q�̫�}�l������
		for (int i = m - 1; i >= 0; i--) {
			int mult = multipliers[i];
			// �p�G m == n�A���̫��諸�Ʀr�@�w�Ѥ@�ӡA�ҥH��n���Ҧ��i�ೣ��@�M��
			// L�MR���t�Z�|�q0��1�A�`�ǹϦp�U
			// m == n �q�o��}�l L[left] = R[left]
			// m-1 == n �q�o��}�l L[left] = R[left+1]
			// m-2 == n �q�o��}�l L[left] = R[left+2] ...
			for (int left = i; left >= 0; left--) {
				int right = n - 1 - (i - left);
				// �N��e�p�⪺���G�P�W�@���p�⵲�G�ۥ[
				int sum_left = mult * nums[left] + dp[i + 1][left + 1];
				int sum_right = mult * nums[right] + dp[i + 1][left];
				// ������j����@�������G
				dp[i][left] = Math.max(sum_left, sum_right);
			}
		}

		// ���̫᪺�N�O�̤j�i��
		return dp[0][0];
	}

}

package leetcode;

public class L659 {

	public static void main(String[] args) {
		new L659();
	}

	L659() {
		isPossible(new int[] { 1, 2, 3, 3, 4, 5 });
		isPossible(new int[] { 1, 2, 3, 3, 4, 4, 5, 5 });
		isPossible(new int[] { 1, 2, 3, 4, 4, 5 });
		isPossible(new int[] { 1, 2, 4, 4, 4, 5 });
		isPossible(new int[] { 1, 2, 3, 4, 4, 4, 5 });
	}

	public boolean isPossible(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return false;
		}
		int curNum = 0, preNum = Integer.MIN_VALUE;
		// �̤jchain�u�|��3���A�ҥH�Х�3���ܼƧY�i
		int curEndL1 = 0, curEndL2 = 0, curEndL3 = 0;
		int preEndL1 = 0, preEndL2 = 0, preEndL3 = 0;
		int m = nums.length;
		for (int i = 0; i < m;) {
			curNum = nums[i];
			// Number of repeated elements ending at curNum.
			int cnt = 0;
			while (i < m && curNum == nums[i]) {
				i++;
				cnt++;
			}
			if (preNum + 1 != curNum) {
				// ���s�p��}�Y
				if (preEndL1 != 0 || preEndL2 != 0) {
					// �p�G���s�p��_�l�A�٦����e���ƶq�Ѿl�A�h�N���Ʀr�S�ǰt����
					return false;
				}
				curEndL1 = cnt;
				curEndL2 = curEndL3 = 0;
			} else {
				if (cnt < preEndL1 + preEndL2) {
					// ���e���Ѿl�q�j��U�@���q�һݭn���q
					// ex.4,4,4,5
					// �o�˴N�N��2��4�L�k�t�令�\
					return false;
				}
				// �N���e��chain���Ჾ��ثe��chain
				curEndL2 = preEndL1;
				curEndL3 = preEndL2;

				// �N�Ѿl�q�֭p��ثechain����
				int residual = cnt - preEndL1 - preEndL2;
				int numToExtendOldLongChain = Math.min(preEndL3, residual);
				curEndL3 += numToExtendOldLongChain;

				// ���s�p��L1
				curEndL1 = Math.max(0, residual - numToExtendOldLongChain);
			}
			// �Ȧs���e�����A
			preNum = curNum;
			preEndL1 = curEndL1;
			preEndL2 = curEndL2;
			preEndL3 = curEndL3;
		}

		return preEndL1 == 0 && preEndL2 == 0;
	}
}

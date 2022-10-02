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
		// 最大chain只會到3長，所以創立3個變數即可
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
				// 重新計算開頭
				if (preEndL1 != 0 || preEndL2 != 0) {
					// 如果重新計算起始，還有先前的數量剩餘，則代表有數字沒匹配完成
					return false;
				}
				curEndL1 = cnt;
				curEndL2 = curEndL3 = 0;
			} else {
				if (cnt < preEndL1 + preEndL2) {
					// 先前的剩餘量大於下一階段所需要的量
					// ex.4,4,4,5
					// 這樣就代表有2個4無法配對成功
					return false;
				}
				// 將先前的chain往後移到目前的chain
				curEndL2 = preEndL1;
				curEndL3 = preEndL2;

				// 將剩餘量累計到目前chain尾巴
				int residual = cnt - preEndL1 - preEndL2;
				int numToExtendOldLongChain = Math.min(preEndL3, residual);
				curEndL3 += numToExtendOldLongChain;

				// 重新計算L1
				curEndL1 = Math.max(0, residual - numToExtendOldLongChain);
			}
			// 暫存先前的狀態
			preNum = curNum;
			preEndL1 = curEndL1;
			preEndL2 = curEndL2;
			preEndL3 = curEndL3;
		}

		return preEndL1 == 0 && preEndL2 == 0;
	}
}

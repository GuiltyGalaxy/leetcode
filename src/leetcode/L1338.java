package leetcode;

public class L1338 {
	public static void main(String[] args) {
		new L1338();
	}

	L1338() {
		minSetSize(new int[] { 3, 3, 3, 3, 5, 5, 5, 2, 2, 7 });
	}

	public int minSetSize(int[] arr) {
		// ���Ʀr���X�{����
		int max = 0;
		for (int a : arr) {
			max = Math.max(max, a);
		}
		int count[] = new int[max + 1];
		for (int a : arr) {
			count[a]++;
		}
		// ���Ʀr�X�{���ƪ��X�{����
		max = 0;
		for (int c : count) {
			if (c > 0) {
				max = Math.max(max, c);
			}
		}
		int len[] = new int[max + 1];
		for (int c : count) {
			if (c > 0) {
				len[c]++;
			}
		}
		// �u�n�q�̤j�ƶq�}�l���L�@�b���X���״N�i�o�X���X�ƶq
		int size = 0;
		int arrCount = 0;
		for (int i = len.length - 1; i >= 0 && arrCount < arr.length / 2; i--) {
			while (len[i] > 0 && arrCount < arr.length / 2) {
				size++;
				len[i]--;
				arrCount += i;
			}
		}

		return size;
	}
}

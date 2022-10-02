package leetcode;

public class L1338 {
	public static void main(String[] args) {
		new L1338();
	}

	L1338() {
		minSetSize(new int[] { 3, 3, 3, 3, 5, 5, 5, 2, 2, 7 });
	}

	public int minSetSize(int[] arr) {
		// 计瞷Ω计
		int max = 0;
		for (int a : arr) {
			max = Math.max(max, a);
		}
		int count[] = new int[max + 1];
		for (int a : arr) {
			count[a]++;
		}
		// 计瞷Ω计瞷Ω计
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
		// 璶眖程计秖秨﹍筁栋碞眔栋计秖
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

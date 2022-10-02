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
		// ����efficiency�Ѱ��ܧC�Ƨ�(efficiency�ۦP�ɡA�p��speed�b�e)
		// �o�a��O���I�A�]�D�حp��覡�O���̤p�Ĳv�h�p��
		// �ҥH�o�˱Ƨǥi�H�ϳg���t��k����
		// �u�n���_���U�諸�P�ɭp��@����e�̤j�Ĳv�Y�i
		// *�Τ���sort�������������C*
		mergeSort(efficiency, speed, 0, n);
		long sum = 0;
		long max = 0;
		for (int i = 0; i < n; i++) {
			// ��q���٥������w�ƶqk�ɡA�����s�W��q��
			if (q.size() < k) {
				q.add(speed[i]);
				sum += speed[i];
				long t = sum * efficiency[i];
				max = Long.max(max, t);
			}
			// �ﺡ�����p�U�̤pspeed���X�ӻP�{�bspeed��
			// �{�bspeed����j�ɫh�������í��s�p���e�į�
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

package wc311;

import java.util.Arrays;
import java.util.PriorityQueue;

public class L2406 {
	public static void main(String[] args) {
		new L2406();
	}

	L2406() {
		minGroups(new int[][] { { 5, 10 }, { 6, 8 }, { 1, 5 }, { 2, 3 }, { 1, 10 } });
	}

	public int minGroups(int[][] intervals) {
		// ���D�η|ĳ�ǥe�Ϊ�����Q�A[0]�_�l�ɶ��P[1]�����ɶ�
		// �p��̤j�ݨϥδX�ӷ|ĳ�ǥi�H���Ҧ��H���Ĭ�}��|
		// �װ_�l�ɶ��Ƨ�
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		// �u���W�C�̫e���������ɶ��A�]�ֵ̧������@�w�i�H���Q����L�H��
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		for (int[] interval : intervals) {
			// ����ƮɡA�ˬd�O�_���w�������|ĳ�i�ϥΡA�i�H�ϥΫh�簣����ϥΪ�
			if (!pq.isEmpty() && pq.peek()[1] < interval[0]) {
				pq.poll();
			}
			pq.add(interval);
		}
		return pq.size();
	}

}

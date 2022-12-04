package contest.wc314;

public class L6201 {
	public static void main(String[] args) {
		new L6201();
	}

	L6201() {
	}

	public int hardestWorker(int n, int[][] logs) {
		int curid = Integer.MAX_VALUE;
		int maxWork = 0;
		int preWork = 0;
		for (int[] log : logs) {
			int id = log[0];
			int work = log[1];
			int curWork = work - preWork;
			if (curWork >= maxWork) {
				// 相同工作量的情況下給員工ID小的
				if (curWork == maxWork) {
					curid = Math.min(curid, id);
				} else {
					curid = id;
				}
				maxWork = Math.max(maxWork, curWork);
			}
			// 紀錄當前的工作進度
			preWork = work;
		}
		return curid;
	}
}

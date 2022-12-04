package contest.bc88;

class LUPrefix {

	int[] list;
	int max = 0;

	public LUPrefix(int n) {
		list = new int[n + 1];
	}

	public void upload(int video) {
		if (video == max + 1) {
			max++;
		}
		for (int i = max+1; i < list.length; i++) {
			if (list[i] == 1) {
				max++;
			} else {
				break;
			}
		}
		list[video] = 1;
	}

	public int longest() {
		return max;
	}
}

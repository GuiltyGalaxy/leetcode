package daily;

public class L869 {
	public static void main(String[] args) {
		new L869();
	}

	L869() {

	}

	public boolean reorderedPowerOf2(int n) {
		if (n == 1) {
			return true;
		}
		int pow = 1;
    	int cur = 0;
		int[] cn = getArray(n);
		while (cur < Integer.MAX_VALUE) {
			cur = (int) Math.pow(2, pow);
			int[] curs = getArray(cur);
			if (isCompare(cn, curs)) {
				return true;
			}
			pow++;
    	}
		return false;
    }

	private int[] getArray(int i) {
		int[] cn = new int[10];
		for (char c : String.valueOf(i).toCharArray()) {
			cn[c - '0']++;
		}
		return cn;
	}

	private boolean isCompare(int[] a, int[] b) {
		int j = 0;
		for (int i : a) {
			if (i != b[j]) {
				return false;
			}
			j++;
		}
		return true;
	}
}

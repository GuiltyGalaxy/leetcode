package bc86;

public class L6173 {
	public static void main(String[] args) {
		new L6173();
	}

	L6173() {
		maximumRows(new int[][] { { 1, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 1, 1, 1, 1 }, { 0, 0, 0, 1, 0, 0, 1 } }, 5);
	}

	public int maximumRows(int[][] mat, int cols) {
		int max = 0;
		// �Ҧ��i��
		// �̤j�ȭ�n�� 1 << mat[0].length
		for (int mask = 0; mask < (1 << mat[0].length); mask++) {
			// bit�ƶq�N���h�ƶq�A���ۦP�h���L
			if (Integer.bitCount(mask) != cols) {
				continue;
			}
			int c = 0;
			// �p���mask�U�i�H��쪺row�ƶq
			for (int i = 0; i < mat.length; i++) {
				boolean take = true;
				for (int j = 0; j < mat[0].length; j++) {
					if ((mask >> j & 1) == 0 && mat[i][j] == 1) {
						take = false;
						break;
					}
				}
				if (take) {
					c++;
				}
			}
			max = Math.max(max, c);
		}
		return max;
	}

}

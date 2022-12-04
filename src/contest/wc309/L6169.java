package contest.wc309;

public class L6169 {
	public static void main(String[] args) {
		new L6169();
	}

	L6169() {
		longestNiceSubarray(new int[] { 84139415, 693324769, 614626365, 497710833, 615598711, 264, 65552, 50331652, 1,
				1048576, 16384, 544, 270532608, 151813349, 221976871, 678178917, 845710321, 751376227, 331656525,
				739558112, 267703680 });
		longestNiceSubarray(new int[] { 3, 8, 1, 3, 8, 48 });

	}

	public int longestNiceSubarray(int[] A) {
		int AND = 0, i = 0, res = 0, n = A.length;
		for (int j = 0; j < n; ++j) {
			while ((AND & A[j]) > 0) {
				AND ^= A[i++];
			}
			AND |= A[j];
			res = Math.max(res, j - i + 1);
		}
		return res;
	}
}

package bc89;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class L6209 {
	public static void main(String[] args) {
		new L6209();
	}

	L6209() {
		productQueries(15, new int[][] {});
	}

	public int[] productQueries(int n, int[][] queries) {

		int mod = 1_000_000_007;
		// 取得次方數set
		Stack<Integer> st = new Stack<>();
		int pow = 1 << Integer.toBinaryString(n).length() - 1;
		while (n > 0) {
			if (n >= pow) {
				st.add(pow);
				n -= pow;
			}
			pow >>= 1;
		}
		// 將set轉換成int[]
		int[] pows = new int[st.size()];
		int idx = 0;
		while (!st.isEmpty()) {
			pows[idx++] = st.pop();
		}

		// 依照queries的條件計算範圍區間相乘之結果
		List<Integer> ans = new LinkedList<>();
		for(int[] q :queries) {
			long tmp = 1;
			int a = 0;
			for (int i = q[0]; i <= q[1]; i++) {
				tmp *= pows[i];
				a = (int) (tmp % mod);
				tmp %= mod;
			}
			ans.add(a);
		}
		return ans.stream().mapToInt(i -> i).toArray();
	}
}

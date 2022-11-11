package daily;

public class L990 {
	public static void main(String[] args) {
		new L990();
	}

	L990() {
		equationsPossible(new String[] { "a==b", "a==c", "c==b", "b==d" });
	}

	int[] uf = new int[26];

	public boolean equationsPossible(String[] equations) {
		// 建立初始向量圖
		// uf[0] = 0 -- a=a
		// uf[1] = 1 -- b=b
		for (int i = 0; i < 26; ++i) {
			uf[i] = i;
		}
		// 計算相等的並更新向量圖
		for (String e : equations) {
			if (e.charAt(1) == '=') {
				int a = find(e.charAt(0) - 'a');
				int b = find(e.charAt(3) - 'a');
				uf[a] = b;
			}
		}
		for (String e : equations) {
			if (e.charAt(1) == '!' && find(e.charAt(0) - 'a') == find(e.charAt(3) - 'a')) {
				return false;
			}
		}
		return true;
	}

	// 尋找目前uf[x]所指向的x
	public int find(int x) {
		if (x != uf[x]) {
			uf[x] = find(uf[x]);
		}
		return uf[x];
	}
}

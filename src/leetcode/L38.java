package leetcode;

public class L38 {
	public static void main(String[] args) {
		new L38();
	}

	L38() {
		countAndSay(5);
	}

	public String countAndSay(int n) {

		if (n == 1) {
			return "1";
		}
		// 取得下個n-1念法
		String s = countAndSay(n - 1);

		// 將該念法再念一遍
		StringBuilder sb = new StringBuilder();
		// 取首個字初始化
		char tmp = s.toCharArray()[0];
		int cnt = 0;
		for (char c : s.toCharArray()) {
			// 當數字變化時，將唸法紀錄
			if (tmp != c) {
				sb.append(String.valueOf(cnt));
				sb.append(tmp);
				tmp = c;
				cnt = 0;
			}
			cnt++;
		}
		sb.append(String.valueOf(cnt));
		sb.append(tmp);

		return sb.toString();
	}
}

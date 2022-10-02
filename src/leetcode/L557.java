package leetcode;

public class L557 {
	public static void main(String[] args) {
		new L557();
	}

	L557() {
		reverseWords("Let's take LeetCode contest");
	}

	public String reverseWords(String s) {
		String[] ss = s.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for (String tmp : ss) {
			StringBuilder sbt = new StringBuilder(tmp);
			sbt.reverse();
			sb.append(sbt);
			sb.append(" ");
		}
		return sb.toString().trim();
	}
}

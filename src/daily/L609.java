package daily;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class L609 {

	public static void main(String[] args) {
		new L609();
	}

	L609() {
		findDuplicate(new String[] { "root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)",
				"root 4.txt(efgh)" });
	}

	public List<List<String>> findDuplicate(String[] paths) {
		Map<String, List<String>> map = new HashMap<>();
		for (String path : paths) {
			String[] p = path.split("\\s+");
			for (int i = 1; i < p.length; i++) {
				String[] s = new String[2];
				String fileName = p[i].split("\\(")[0];
				String text = p[i].split("\\(")[1].split("\\)")[0];
				StringBuilder sb = new StringBuilder();
				s[0] = sb.append(p[0]).append("/").append(fileName).toString();
				s[1] = text;
				List<String> tmp = map.getOrDefault(s[1], new LinkedList<>());
				tmp.add(s[0]);
				map.put(s[1], tmp);
			}
		}
		List<List<String>> ans = new LinkedList<>();
		map.entrySet().stream().forEach(e -> {
			if (e.getValue().size() > 1) {
				ans.add(e.getValue());
			}
		});
		return ans;
	}
}

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class L126 {
	public static void main(String[] args) {
		new L126();
	}

	L126() {
		List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
		findLadders("hit", "cog", wordList);
	}

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> ans = new ArrayList<>();
		Map<String, Set<String>> reverse = new HashMap<>();
		Set<String> wordSet = new HashSet<>(wordList);
		if (!wordSet.contains(endWord)) {
			return ans;
		}
		wordSet.remove(beginWord);
		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		Set<String> nextLevel = new HashSet<>();
		boolean findEnd = false;
		// traverse current layer nodes
		while (!queue.isEmpty()) {
			String word = queue.remove();
			for (String next : wordSet) {
				// is ladder words
				if (isLadder(word, next)) {
					// construct the reverse graph from endWord
					Set<String> reverseLadders = reverse.computeIfAbsent(next, k -> new HashSet<>());
					// add this node link set
					reverseLadders.add(word);
					if (endWord.equals(next)) {
						findEnd = true;
					}
					// store next layer nodes
					nextLevel.add(next);
				}
			}
			// when current layer is all visited
			if (queue.isEmpty()) {
				// if find the endWord, then break the while loop
				if (findEnd)
					break;
				// add next layer nodes to queue
				queue.addAll(nextLevel);
				// remove all next layer nodes in wordSet
				wordSet.removeAll(nextLevel);
				nextLevel.clear();
			}
		}
		// if can't reach endWord from startWord, then return ans.
		if (!findEnd)
			return ans;

		Set<String> path = new LinkedHashSet<>();
		path.add(endWord);
		// traverse reverse graph from endWord to beginWord
		findPath(endWord, beginWord, reverse, ans, path);
		return ans;
	}

	private void findPath(String endWord, String beginWord, Map<String, Set<String>> graph, List<List<String>> ans,
			Set<String> path) {
		Set<String> next = graph.get(endWord);
		if (next == null)
			return;
		for (String word : next) {
			path.add(word);
			if (beginWord.equals(word)) {
				List<String> shortestPath = new ArrayList<>(path);
				// reverse words in shortest path
				Collections.reverse(shortestPath);
				// add the shortest path to ans.
				ans.add(shortestPath);
			} else {
				findPath(word, beginWord, graph, ans, path);
			}
			path.remove(word);
		}
	}

	private boolean isLadder(String s, String t) {
		if (s.length() != t.length())
			return false;
		int diffCount = 0;
		int n = s.length();
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) != t.charAt(i))
				diffCount++;
			if (diffCount > 1)
				return false;
		}
		return diffCount == 1;
	}
}

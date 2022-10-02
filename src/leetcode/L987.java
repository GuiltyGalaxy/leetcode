package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L987 {
	public static void main(String[] args) {
		new L987();
	}

	L987() {
	}

	List<int[]> list = new ArrayList<>();

	public List<List<Integer>> verticalTraversal(TreeNode root) {
		// ���`�I�y�нs��
		preorder(root, 0, 0);
		// �̷Ӹ`�I�Ƨ�
		Collections.sort(list, (a, b) -> {
			// y���P�p���b�e��
			if (a[2] != b[2]) {
				return a[2] - b[2];
			}
			// x���P�p���b�e��
			if (a[1] != b[1]) {
				return a[1] - b[1];
			}
			// x�ۦP�Ȥp���b�e��
			return a[0] - b[0];
		});

		List<List<Integer>> ans = new ArrayList<>();
		int prerow = Integer.MIN_VALUE;
		for (int[] node : list) {
			int row = node[2];
			int value = node[0];
			// row����
			if (row != prerow) {
				ans.add(new ArrayList<>());
				prerow = row;
			}
			ans.get(ans.size() - 1).add(value);
		}
		return ans;
	}

	public void preorder(TreeNode node, int x, int y) {
		if (node == null) {
			return;
		}
		list.add(new int[] { node.val, x, y });
		preorder(node.left, x + 1, y - 1);
		preorder(node.right, x + 1, y + 1);
	}
}

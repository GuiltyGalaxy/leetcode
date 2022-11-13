package daily;

import tool.ListNode;

public class L237 {
	public static void main(String[] args) {
		new L237();
	}

	L237() {
	}

	public void deleteNode(ListNode node) {
		// 題目有限定移除的node一定不是tail
		// 所以node.next一定不為null
		// 5 -> 2 -> 3 -> 1
		//      ^
		// 實際上不能移除自己
		// 利用替代的方式實現
		// 5 -> 3 -> 3 -> 1
		//      ^
		node.val = node.next.val;
		// 把下個節點移除並接上下下個節點
		// 5 -> 3 ┐ 3 ┌> 1
		//      ^ └───┘
		node.next = node.next.next;
	}
}

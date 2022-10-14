package leetcode;

public class L2095 {
	public static void main(String[] args) {
		new L2095();
	}

	L2095() {
	}

	public ListNode deleteMiddle(ListNode head) {
		// 只有一個節點
		if (head.next == null) {
			return null;
		}
		// 使用快慢針
		// 並先在前面安插一個node方便計算
		ListNode slow = new ListNode();
		slow.next = head;
		ListNode fast = slow;
		// 找到fast沒有下個時slow就會在中間
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// 移除
		slow.next = slow.next.next;
		return head;
	}

}

package leetcode;

public class L19 {

	public static void main(String[] args) {
		new L19();
	}

	L19() {
		ListNode list = ListNodeHelper.create(new int[] { 1, 2, 3 });
		removeNthFromEnd(list, 3);
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode f = head;
		ListNode s = head;
		ListNode b = null;
		while (--n > 0) {
			f = f.next;
		}

		while (true) {
			if (f.next == null) {
				break;
			}
			b = s;
			f = f.next;
			s = s.next;
		}

		if (b == null) {
			if (head.next != null) {
				head = head.next;
			} else {
				head = null;
			}
		} else {
			b.next = s.next;
		}

		return head;
	}

	/*
	 * 此方法先在原先list最前面插入0當作開始，避免掉一些null情境
	 */
	public ListNode removeNthFromEnd2(ListNode head, int n) {
		ListNode dummy = new ListNode(0, head);
		ListNode left = dummy;
		ListNode right = head;

		while (n-- > 0) {
			right = right.next;
		}

		while (right != null) {
			left = left.next;
			right = right.next;
		}

		left.next = left.next.next;
		return dummy.next;
	}
}

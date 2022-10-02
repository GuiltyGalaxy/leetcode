package leetcode;

public class ListNodeHelper {
	public static ListNode create(int[] is) {
		ListNode h = new ListNode();
		ListNode c = h;
		c.val = is[0];
		for (int i = 1; i < is.length; i++) {
			c.next = new ListNode();
			c = c.next;
			c.val = is[i];
		}
		return h;
	}
}

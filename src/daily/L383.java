package daily;

public class L383 {
	public static void main(String[] args) {
		new L383();
	}

	L383() {
		ListNode ln = ListNodeHelper.create(new int[] { 1, 0, 0 });
		isPalindrome(ln);
		ln = ListNodeHelper.create(new int[] { 1, 2, 2, 1 });
		isPalindrome(ln);
		ln = ListNodeHelper.create(new int[] { 1, 2, 3, 2, 1 });
		isPalindrome(ln);
	}

	public boolean isPalindrome(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast != null)
			slow = slow.next;
		// reverse link list
		ListNode prev = null;
		while (slow != null) {
			ListNode temp = slow.next;
			slow.next = prev;
			prev = slow;
			slow = temp;
		}
		slow = prev;
		fast = head;
		while (slow != null) {
			if (slow.val != fast.val)
				return false;
			slow = slow.next;
			fast = fast.next;
		}
		return true;
	}
}

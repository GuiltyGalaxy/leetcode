package daily.myCalendarThree;

public class MyCalendarThree2 {
	public static void main(String[] args) {
		MyCalendarThree2 myCalendarThree = new MyCalendarThree2();
		// return 1, The first event can be booked and is disjoint, so the maximum
		// k-booking is a 1-booking.
		myCalendarThree.book(10, 20);
		// return 1, The second event can be booked and is disjoint, so the maximum
		// k-booking is a 1-booking.
		myCalendarThree.book(50, 60);
		// return 2, The third event [10, 40) intersects the first event, and the
		// maximum k-booking is a 2-booking.
		myCalendarThree.book(10, 40);
		// return 3, The remaining events cause the maximum K-booking to be only a
		// 3-booking.
		myCalendarThree.book(5, 15);
		// return 3
		myCalendarThree.book(5, 10);
		// return 3
		myCalendarThree.book(25, 55);
	}

	static class TreeNode {
		TreeNode left;
		TreeNode right;
		int start;
		int end;
		int count;

		TreeNode(int start, int end, int count) {
			this.start = start;
			this.end = end;
			this.count = count;
		}
	}

	TreeNode root;
	int max = 1;

	public MyCalendarThree2() {
	}

	public int book(int start, int end) {
		root = insert(root, start, end, 1);
		return max;
	}

	// Segment Tree
	// O(logN)
	private TreeNode insert(TreeNode node, int start, int end, int count) {
		
		if (node == null) {
			return new TreeNode(start, end, count);
		}

		// end <= node.start代表區間沒重疊
		// 向左插入節點
		if (end <= node.start) {
			node.left = insert(node.left, start, end, count);
			return node;
		}

		// node.end <= start代表區間沒重疊
		// 向右插入節點
		if (node.end <= start) {
			node.right = insert(node.right, start, end, count);
			return node;
		}

		// 重疊區間計算
		// ex.
		// [10 60] c = 2 insert [20 40] c = 1
		// =>
		// [10 20] c = 2 , [40 60] c = 2
		int s1 = Math.min(start, node.start);
		int s2 = Math.max(start, node.start);
		int e1 = Math.min(end, node.end);
		int e2 = Math.max(end, node.end);
		// s1 == node.start代表新分隔節點與分隔前的起始點相同
		// 需要帶入當前節點的node.count，e2同理
		node.left = insert(node.left, s1, s2, s1 == node.start ? node.count : count);
		node.right = insert(node.right, e1, e2, e2 == node.end ? node.count : count);
		// 更新當前節點
		node.count += count;
		node.start = s2;
		node.end = e1;
		// 重疊區間計算完後比對max有沒有更新
		max = Math.max(max, node.count);

		return node;
	}
}

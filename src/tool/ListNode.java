package tool;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode create(int... val) {
        ListNode list = new ListNode();
        ListNode tmp = list;
        for (int v:val){
            tmp.next = new ListNode(v);
            tmp = tmp.next;
        }
        return list.next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode tmp = this;

        while (tmp != null) {
            sb.append(tmp.val);
            tmp = tmp.next;
        }

        return sb.toString();
    }
}

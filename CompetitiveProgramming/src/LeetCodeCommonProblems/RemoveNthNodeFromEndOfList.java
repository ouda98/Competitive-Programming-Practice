package LeetCodeCommonProblems;

public class RemoveNthNodeFromEndOfList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode front = new ListNode(0);
        front.next = head;
        ListNode traverse = head;
        while (traverse != null) {
            traverse = traverse.next;
            count++;
        }
        int remove = count - n + 1;

        traverse = front;

        count = 0;
        ListNode pre = null;
        ListNode cur = front;
        ListNode next = null;
        while (count != remove && cur.next != null) {
            pre = cur;
            cur = cur.next;
            next = cur.next;
            count++;

        }
        if (count == remove) {
            pre.next = next;
        }
        return front.next;
    }
}

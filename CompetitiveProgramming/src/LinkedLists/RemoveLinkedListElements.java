package LinkedLists;

public class RemoveLinkedListElements {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode removeElements(ListNode h, int val) {
            // write your code here
            ListNode head = new ListNode(0);
            head.next = h;
            ListNode iterator = head;
            ListNode pre = null;
            ListNode value = null;
            while (iterator != null) {
                if (iterator.val == val) {
                    value = iterator.next;
                    pre.next = value;
                    iterator = pre;

                }
                pre = iterator;
                iterator = iterator.next;
            }
            return head.next;
        }
    }
}

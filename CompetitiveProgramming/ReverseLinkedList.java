public class ReverseLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        /**
         * @param head: n
         * @return: The new head of reversed linked list.
         */
        public ListNode reverse(ListNode head) {
            // write your code here
            ListNode cur = head;
            ListNode previous = null;
            ListNode next = null;
            while (cur != null) {
                next = cur.next;
                cur.next = previous;
                previous = cur;
                cur = next;
            }
            return previous;
        }
    }
}

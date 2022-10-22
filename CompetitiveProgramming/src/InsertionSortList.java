public class InsertionSortList {

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
         * @param head: The first node of linked list.
         * @return: The head of linked list.
         */
        public ListNode insertionSortList(ListNode head) {
            // write your code here
            if (head == null) return null;
            ListNode dummy = new ListNode(0);
            ListNode p;
            ListNode t;
            while (head != null) {
                p = dummy;
                while (p.next != null && p.next.val < head.val) {
                    p = p.next;
                }
                t = head.next;
                head.next = p.next;
                p.next = head;
                head = t;
            }
            return dummy.next;
        }

    }
}

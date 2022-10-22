package LinkedLists;

public class IntersectionOfTwoLinkedLists {

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
         * @param headA: the first list
         * @param headB: the second list
         * @return: a ListNode
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // write your code here
            ListNode ha = headA;
            int counterA = 0;
            ListNode hb = headB;
            int counterB = 0;
            ListNode h2 = null;
            ListNode h = null;
            while (ha != null) {
                counterA++;
                ha = ha.next;
            }
            while (hb != null) {
                counterB++;
                hb = hb.next;
            }
            if (counterA >= counterB) {
                int diff = counterA - counterB;
                h = headA;
                while (diff > 0) {
                    h = h.next;
                    diff -= 1;
                }
                h2 = headB;
            }
            if (counterB > counterA) {
                int diff = counterB - counterA;
                h = headB;
                while (diff > 0) {
                    h = h.next;
                    diff -= 1;
                }
                h2 = headA;
            }
            while (h != null && h2 != null) {
                if (h != h2) {
                    h = h.next;
                    h2 = h2.next;
                } else
                    break;

            }
            return h;
        }
    }
}

public class LinkedListSimplification {

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
         * @param head: the linked list to be simplify.
         * @return: return the linked list after simplifiction.
         */
        public ListNode simplify(ListNode head) {
            // write your code here
            if (head == null)
                return head;
            ListNode iterate = head.next;
            int sum = 0;
            while (iterate.next != null) {
                sum++;
                iterate = iterate.next;
            }
            String s = "" + sum;
            ListNode h = head;
            for (int i = 0; i < s.length(); i++) {
                ListNode temp = new ListNode(s.charAt(i));
                h.next = temp;
                h = h.next;
            }
            h.next = iterate;
            return head;

        }
    }
}

public class RotateList {
    public static void main(String[] args) {
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public class Solution {
        /**
         * @param head: the List
         * @param k:    rotate to the right k places
         * @return: the list after rotation
         */
        public ListNode rotateRight(ListNode head, int k) {
            // write your code here
            if (head == null || head.next == null)
                return head;
            int count = 1;
            ListNode h = head;
            while (h.next != null) {
                count++;
                h = h.next;
            }
            k = k % count;
            if (k == 0)
                return head;
            int c = 0;
            ListNode t = head;
            while (t != null) {
                c++;
                if (k + c == count)
                    break;
                t = t.next;
            }
            ListNode front = t.next;
            h.next = head;
            t.next = null;
            return front;

        }
    }
}

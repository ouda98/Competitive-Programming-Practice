import java.util.HashSet;

public class RemoveDuplicatesFromUnsortedList {

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
         * @return: Head node.
         */
        public ListNode removeDuplicates(ListNode head) {
            // write your code here
            if (head == null || head.next == null)
                return head;
            HashSet<Integer> set = new HashSet<>();
            ListNode pre = head;
            set.add(pre.val);
            ListNode cur = head.next;
            ListNode next = head.next.next;
            while (cur != null) {
                if (set.contains(cur.val)) {
                    pre.next = next;
                    cur = next;
                    if (next == null)
                        break;
                    next = next.next;
                } else {
                    set.add(cur.val);
                    cur = cur.next;
                    pre = pre.next;
                    if (next == null)
                        break;
                    next = next.next;

                }
            }
            return head;

        }
    }
}

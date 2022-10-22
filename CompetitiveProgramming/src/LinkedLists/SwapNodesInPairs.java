package LinkedLists;

public class SwapNodesInPairs {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode swapPairs(ListNode h) {
            // write your code here
            ListNode head = new ListNode(0);
            head.next = h;
            ListNode iterator = head.next;
            ListNode pre = head;
            while (iterator != null) {
                ListNode first = iterator;
                if (iterator.next != null) {
                    iterator = iterator.next;
                    ListNode second = iterator;
                    iterator = iterator.next;
                    first.next = iterator;
                    second.next = first;
                    pre.next = second;
                } else {
                    break;
                }
                pre = pre.next;
                pre = pre.next;
            }
            return head.next;
        }
    }
}

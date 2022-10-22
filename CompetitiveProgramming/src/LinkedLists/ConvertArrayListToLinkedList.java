package LinkedLists;

import java.util.List;

public class ConvertArrayListToLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }


    public class Solution {
        /*
         * @param nums: an integer array
         * @return: the first node of linked list
         */
        public ListNode toLinkedList(List<Integer> nums) {
            // write your code here
            if (nums.size() == 0)
                return null;
            ListNode head = new ListNode(nums.get(0));
            ListNode traverse = head;
            for (int i = 1; i < nums.size(); i++) {
                traverse.next = new ListNode(nums.get(i));
                traverse = traverse.next;
            }
            return head;
        }
    }
}

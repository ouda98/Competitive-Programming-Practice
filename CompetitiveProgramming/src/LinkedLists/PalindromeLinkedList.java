package LinkedLists;

import java.util.Stack;

public class PalindromeLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public class Solution {
        public boolean isPalindrome(ListNode head) {
            // write your code here
            if (head == null || head.next == null)
                return true;
            ListNode h = head;
            int counter = 0;
            while (h != null) {
                h = h.next;
                counter++;
            }
            int count = 1;
            int rearCounter = counter / 2;
            if (counter % 2 == 1)
                rearCounter += 1;
            ListNode hf = head;
            ListNode hr = head;
            int end = counter / 2;
            while (rearCounter > 0) {
                hr = hr.next;
                rearCounter--;
            }

            Stack<Integer> s = new Stack<>();
            while (count <= end) {
                s.add(head.val);
                head = head.next;
                count++;
            }
            count = 1;
            boolean equal = true;
            while (count <= end) {
                if (s.pop() != hr.val) {
                    equal = false;
                    break;
                }
                hr = hr.next;
                count++;
            }
            if (s.isEmpty() && equal)
                return true;

            return false;


        }
    }
}

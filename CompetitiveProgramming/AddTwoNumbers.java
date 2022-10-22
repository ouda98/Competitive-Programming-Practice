public class AddTwoNumbers {

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
         * @param l1: the first list
         * @param l2: the second list
         * @return: the sum list of l1 and l2
         */
        public ListNode addLists(ListNode l1, ListNode l2) {
            // write your code here
            String first = "";
            while (l1 != null) {
                first = "" + l1.val + first;
                l1 = l1.next;
            }
            String second = "";
            while (l2 != null) {
                second = "" + l2.val + second;
                l2 = l2.next;
            }
            while (first.length() < second.length())
                first = "0" + first;

            while (second.length() < first.length())
                second = "0" + second;
            int carry = 0;
            ListNode head = new ListNode(0);
            ListNode traverse = head;
            for (int i = first.length() - 1; i >= 0; i--) {
                int sum = (first.charAt(i) - '0') + (second.charAt(i) - '0') + carry;
                traverse.next = new ListNode(sum % 10);
                carry = sum / 10;
                traverse = traverse.next;
            }
            if (carry > 0)
                traverse.next = new ListNode(1);
            return head.next;
        }
    }
}

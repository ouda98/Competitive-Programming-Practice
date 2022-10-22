package LinkedLists;

public class AddTwoNumbersII {

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
         * @param l1: The first list.
         * @param l2: The second list.
         * @return: the sum list of l1 and l2.
         */
        static int l;

        public ListNode addLists2(ListNode l1, ListNode l2) {
            // write your code here
            l = 0;
            l1 = reverse(l1);
            int one = l;
            l = 0;
            l2 = reverse(l2);
            int two = l;

            ListNode longest = null;
            ListNode shortest = null;
            if (one >= two) {
                longest = l1;
                shortest = l2;
            } else {
                longest = l2;
                shortest = l1;
            }
            System.out.println(longest.val + " " + shortest.val);
            int carry = 0;
            int sum = 0;
            ListNode pre = longest;
            ListNode s = new ListNode(0);
            s.next = longest;
            while (longest != null) {
                if (shortest != null) {
                    sum = longest.val + shortest.val + carry;
                    longest.val = sum % 10;
                    shortest = shortest.next;
                } else {
                    longest.val += carry;
                    sum = longest.val + carry;
                }

                carry = sum / 10;
                System.out.println(sum + " " + longest.val + " " + carry);
                pre = longest;

                longest = longest.next;
            }
            if (carry == 1)
                pre.next = new ListNode(1);
            pre = pre.next;
            return reverse(s.next);


        }

        ListNode reverse(ListNode node) {
            ListNode prev = null;
            ListNode cur = node;
            ListNode next = null;
            while (cur != null) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                l++;
            }
            return prev;
        }
    }
}

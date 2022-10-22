public class InsertIntoACyclicSortedList {

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
         * @param node: a list node in the list
         * @param x:    An integer
         * @return: the inserted new list node
         */
        public ListNode insert(ListNode node, int x) {
            // write your code here
            if (node == null) {
                ListNode insert = new ListNode(x);
                insert.next = insert;
                return insert;
            }
            if (node.next == node) {
                ListNode insert = new ListNode(x);
                node.next = insert;
                insert.next = node;
                return insert;
            }

            ListNode head = node;
            ListNode cur = node;
            ListNode next = node.next;

            while (next != null) {
                if (cur.val < x && next.val > x)
                    break;
                if (cur.val < x && next.val < x)
                    break;
                if (cur.val > x && next.val > x && cur.val > next.val)
                    break;
                if (cur.val == next.val)
                    break;
                cur = cur.next;
                next = next.next;
            }
            ListNode insert = new ListNode(x);
            cur.next = insert;
            insert.next = next;
            return insert;


        }
    }
}

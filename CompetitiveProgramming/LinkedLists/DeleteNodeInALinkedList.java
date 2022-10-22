package LinkedLists;

public class DeleteNodeInALinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }


    public class Solution {

        public void deleteNode(ListNode node) {
            // write your code here
            if (node == null)
                return;
            node.val = node.next.val;

            while (node.next != null) {
                if (node.next.next != null) {
                    node.next.val = node.next.next.val;
                } else {
                    node.next = null;
                    break;
                }

                node = node.next;
            }
        }
    }
}

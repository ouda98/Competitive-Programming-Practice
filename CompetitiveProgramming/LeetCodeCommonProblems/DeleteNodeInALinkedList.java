package LeetCodeCommonProblems;

public class DeleteNodeInALinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        while (node.next.next != null) {
            node = node.next;
            node.val = node.next.val;
        }
        node.next = null;
    }
}

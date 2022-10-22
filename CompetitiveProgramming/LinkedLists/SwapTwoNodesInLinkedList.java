package LinkedLists;


public class SwapTwoNodesInLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    ListNode swapNodes(ListNode h, int one, int two) {
        ListNode head = new ListNode(0);
        head.next = h;
        ListNode iterator = head;
        ListNode preFirst = null;
        ListNode postFirst = null;
        ListNode first = null;
        ListNode preSecond = null;
        ListNode postSecond = null;
        ListNode second = null;
        int v1 = 0;
        int v2 = 0;
        ListNode e = head;
        while (e != null) {
            if (e.val == one || e.val == two) {
                v1 = e.val;
                break;
            }
            e = e.next;
        }
        if (v1 == one)
            v2 = two;
        else
            v2 = one;
        while (iterator != null) {
            if (iterator.val == v1) {
                first = iterator;
                postFirst = iterator.next;
            }
            if (iterator.val == v2) {
                second = iterator;
                postSecond = iterator.next;
            }
            if (first != null && second != null && first != second) {
                first.next = postSecond;
                preFirst.next = second;
                if (postFirst == second && preSecond == first) {
                    second.next = first;
                } else if (postFirst == preSecond) {
                    second.next = postFirst;
                    postFirst.next = first;
                } else if (postFirst != preSecond) {
                    second.next = postFirst;
                    preSecond.next = first;
                }
                break;
            }

            if (second == null)
                preSecond = iterator;
            if (first == null)
                preFirst = iterator;
            iterator = iterator.next;
        }
        return head.next;
    }
}
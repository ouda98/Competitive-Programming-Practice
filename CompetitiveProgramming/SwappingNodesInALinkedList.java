public class SwappingNodesInALinkedList {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapNodes(ListNode head, int k) {
        if(head==null || head.next == null)
            return head;
        ListNode front = new ListNode(0);
        front.next = head;
        int c = 1;
        ListNode prev = front;
        ListNode cur = front.next;
        int count = 0;
        ListNode cur2 = front.next;
        while(cur2!=null){
            cur2 = cur2.next;
            count++;
            if(c<k && cur!=null){
                c++;
                prev = prev.next;
                cur = cur.next;
            }
        }
        count = count - k;
        cur2 = front.next;
        ListNode pre = front;
        while(count>0){
            count--;
            cur2 = cur2.next;
            pre = pre.next;
        }
        if(cur == cur2)
            return head;
        prev.next = cur2;
        pre.next = cur;
        ListNode temp = cur.next;
        cur.next = cur2.next;
        cur2.next = temp;
        return front.next;
    }

}

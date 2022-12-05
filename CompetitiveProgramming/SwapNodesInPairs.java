public class SwapNodesInPairs {
    public static void main(String[] args) {

    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode swapPairs(ListNode head) {
        ListNode cur = head;
        ListNode next = null;
        boolean flag = true;
        ListNode previous = null;
        while(cur !=null && cur.next !=null){
            next = cur.next;
            cur.next = cur.next.next;
            next.next = cur;
            if(previous!=null)
                previous.next = next;
            previous = cur;
            cur = cur.next;
            if(flag){
                flag = false;
                head = next;
            }
            if(cur == null)
                break;
        }
        return head;
    }
}

public class RemoveLinkedListElements {
    public static void main(String[] args) {

    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode curr = new ListNode(val-1);
        curr.next = head;
        ListNode c = curr;
        helper(curr, curr.next, val);
        return c.next;
    }
    public void helper(ListNode cur,ListNode next, int val){
        if(next == null){
            cur.next = null;
            return;
        }
        if(next.val != val){
            cur.next = next;
            cur = cur.next;
        }
        helper(cur,next.next,val);
    }
}

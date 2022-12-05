public class OddEvenLinkedList {
    public static void main(String[] args) {

    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return null;
        ListNode even = head;
        ListNode odd = new ListNode(0);
        ListNode o = odd;
        while(even!=null && even.next!=null){
            o.next = even.next;
            o = o.next;
            if(even.next.next == null){
                break;
            }
            even.next = even.next.next;
            even = even.next;
        }
        if(o!=null)
            o.next = null;
        even.next = odd.next;
        return head;
    }
}

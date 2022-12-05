public class AddTwoIntNumbers {
    public static void main(String[] args) {

    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        int carry = 0;
        int sum =0;
        while(l1!=null && l2!=null){
            sum = l1.val + l2.val+carry;
            if(sum>9){
                carry = 1;
            }else
                carry = 0;
            current.next = new ListNode(sum%10);
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            sum = l1.val + carry;
            if(sum>9){
                carry = 1;
            }else
                carry = 0;
            current.next = new ListNode(sum%10);
            current = current.next;
            l1 = l1.next;
        }
        while(l2!=null){
            sum = l2.val + carry;
            if(sum>9){
                carry = 1;
            }else
                carry = 0;
            current.next = new ListNode(sum%10);
            current = current.next;
            l2 = l2.next;
        }
        if(carry == 1)
            current.next = new ListNode(1);

        return head.next;
    }
}

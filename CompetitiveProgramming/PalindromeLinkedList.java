public class PalindromeLinkedList {
    public static void main(String[] args) {

    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public boolean isPalindrome(ListNode head) {
        if(head.next == null)
            return true;
        ListNode current = head;
        int counter = 0;
        while(current!=null){
            current = current.next;
            counter++;
        }
        int mid = counter/2;
        if(counter%2 ==1)
            mid++;
        current = head;
        while(mid>0){
            current = current.next;
            mid--;
        }

        ListNode pervious = null;
        ListNode next;
        while(current.next!=null){
            next = current.next;
            current.next = pervious;
            pervious = current;
            current = next;
        }
        current.next = pervious;

        while(head!=null && current!=null){
            if(head.val != current.val)
                return false;
            head = head.next;
            current = current.next;
        }
        return true;

    }
}
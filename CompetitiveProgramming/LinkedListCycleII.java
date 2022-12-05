import java.util.HashSet;

public class LinkedListCycleII {
    public static void main(String[] args) {

    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode res = null;
        while(head!=null){
            if(set.contains(head))
                return head;
            set.add(head);
            head = head.next;
        }
        return res;
    }
}

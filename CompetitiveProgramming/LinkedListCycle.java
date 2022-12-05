import java.util.HashSet;

public class LinkedListCycle {
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
    // Solution 2 TC = O(n) SC = O(1)
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }

    // Solution 2 TC = O(n) SC = O(n)
    public boolean hasCycle1(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while(head!= null){
            if(!set.contains(head))
                set.add(head);
            else
                return true;
            head = head.next;
        }
        return false;
    }
}

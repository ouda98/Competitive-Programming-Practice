import java.util.ArrayList;
import java.util.Collections;

public class SortList {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l = sortList(head);
        ListNode r = sortList(slow);
        return merge(l,r);
    }
    public ListNode merge(ListNode l, ListNode r){
        ListNode res = new ListNode(0);
        ListNode p = res;
        while(l!=null && r!=null){
            if(l.val < r.val){
                p.next = l;
                l = l.next;
            }else{
                p.next = r;
                r = r.next;
            }
            p = p.next;
        }
        if(l!=null)
            p.next = l;
        if(r!=null)
            p.next = r;
        return res.next;
    }
}

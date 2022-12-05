import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaximumTwinSumOfALinkedList {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int pairSum(ListNode head) {
        Stack<Integer> s = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        int max = 0;
        while(head!=null){
            s.add(head.val);
            q.add(head.val);
            head = head.next;
        }
        int size = s.size();
        while(size-->0){
            max = Math.max(max, s.pop()+q.poll());
        }
        return max;
    }
}

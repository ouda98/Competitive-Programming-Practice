public class MergeNodesInBetweenZeros {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeNodes(ListNode head) {
        ListNode perv = head;
        ListNode cur = head.next;
        int sum = 0;
        while(cur!=null){
            if(cur.val != 0)
                sum+= cur.val;
            else{
                ListNode node = new ListNode(sum);
                perv.next = node;
                sum=0;
                perv = perv.next;
            }
            cur = cur.next;
        }
        return head.next;
    }
}

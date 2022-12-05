public class MergeInBetweenLinkedLists {
    public static void main(String[] args) {

    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = new ListNode(0);
        head.next = list1;
        ListNode curStart = list1;
        ListNode curEnd = list1;
        int cStart = 0;
        int cEnd = 0;
        while(curEnd!=null && cEnd++<=b){
            curEnd = curEnd.next;
            if(cStart++<a-1)
                curStart = curStart.next;
        }
        curStart.next = list2;
        ListNode endList2 = list2;
        while(endList2!=null && endList2.next!=null)
            endList2 = endList2.next;
        endList2.next = curEnd;
        return head.next;
    }
}

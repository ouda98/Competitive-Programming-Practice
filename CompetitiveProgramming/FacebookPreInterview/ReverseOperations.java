package FacebookPreInterview;

public class ReverseOperations {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node r = head;
        r.next = new Node(2);
        r = r.next;
        r.next = new Node(8);
        r = r.next;
        r.next = new Node(9);
        r = r.next;
        r.next = new Node(12);
        r = r.next;
        r.next = new Node(16);
        r = r.next;
        r.next = new Node(3);
//        while(head!=null){
//            System.out.println(head.data);
//            head = head.next;
//        }


        Node s = reverse(head);
        while(s!=null){
            System.out.println(s.data);
            s = s.next;
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    static Node reverse(Node head) {
        // Write your code here
        Node s = new Node(1);
        s.next = head;

        Node traverse = s;
        Node front = null;
        Node prefront = null;
        Node rear = null;
        Node postrear = null;

        while (traverse.next != null) {
            if (traverse.next.data % 2 == 1 && front == null) {
                traverse = traverse.next;
            } else if (front == null) {
                prefront = traverse;
                front = traverse.next;

                while (traverse.next != null && traverse.next.data % 2 == 0) {
                    traverse = traverse.next;
                }
                rear = traverse;
                traverse = traverse.next;
                postrear = traverse;
                rear.next = null;
                prefront.next = null;
                Node reversed = reverseR(front);
                Node tailReversed = reversed;
                while (tailReversed.next != null) {
                    tailReversed = tailReversed.next;
                }
                prefront.next = reversed;
                tailReversed.next = postrear;
                front = null;
                if(traverse==null)
                    break;
            }
        }
        return s.next;

    }

    static Node reverseR(Node node) {
        Node prev = null;
        Node cur = node;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}

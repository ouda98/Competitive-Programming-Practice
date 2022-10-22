import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class OddEvenLinkedList1292LinkedList {

    public void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);


        out.flush();
        out.close();
    }
//    public ListNode oddEvenList(ListNode head) {
//        // write your code here
//        ListNode n = new ListNode(head.val);
//        ListNode r = n;
//        int counter = 2;
//        ArrayList<Integer> evenPos = new ArrayList<>();
//        head = head.next;
//        while(head!=null){
//            if(counter%2==1){
//                r.next = new ListNode(head.val);
//                r = r.next;
//            }else{
//                evenPos.add(head.val);
//            }
//            head = head.next;
//            counter++;
//
//        }
//
//        for(int i=0;i<evenPos.size();i++){
//            r.next = new ListNode(evenPos.get(i));
//            r= r.next;
//        }
//        return n;
//
//    }
    public ListNode oddEvenList(ListNode head) {
        // write your code here

        int counter =1;
        ArrayList<Integer> evenPos = new ArrayList<>();
        ListNode n = null;
        ListNode r = null;
        ListNode m = null;
        ListNode c = null;
        while(head!=null){
            if(counter%2==1){
                if(counter==1){
                    n = new ListNode(head.val);
                    r=n;
                }
                else{
                    r.next = new ListNode(head.val);
                    r = r.next;
                }

            }else{
                if(counter==2){
                    m = new ListNode(head.val);
                    c=m;
                }
                else{
                    c.next = new ListNode(head.val);
                    c = c.next;
                }

            }
            head = head.next;
            counter++;

        }
        r.next = m;
        return n;

    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }



    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        Scanner(InputStream system) {
            br = new BufferedReader(new InputStreamReader(system));
        }

        Scanner(String file) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(file));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        char nextChar() throws IOException {
            return next().charAt(0);
        }

        Long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        boolean ready() throws IOException {
            return br.ready();
        }
    }
}




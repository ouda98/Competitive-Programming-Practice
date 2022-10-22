import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class PlusOneLinkedList904LinkedList {

    public void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        plusOne(new ListNode(5));
        out.flush();
        out.close();
    }
    public ListNode plusOne(ListNode head) {
        // Write your code here
        StringBuilder number = new StringBuilder();
        while(head!=null){
            number.append(head.val);
            head = head.next;
        }
        BigInteger n = new BigInteger(number.toString());
        n =n.add(new BigInteger("1"));
        String num = ""+n;
        ListNode h = null;
        ListNode t= h;
        for(int i=0;i<num.length();i++){
            if(i==0){
                h = new ListNode(num.charAt(i)-'0');
                t = h;
            }else{
                t.next = new ListNode(num.charAt(i)-'0');
                t = t.next;
            }

        }
        return h;
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



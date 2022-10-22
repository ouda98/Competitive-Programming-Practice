import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class LinkedListComponents1371LinkedList {

    public void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        ListNode n = new ListNode(5);
        int [] G = new int [5];
        numComponents(n, G);
        out.flush();
        out.close();
    }
    public int numComponents(ListNode head, int[] G) {
        // Write your code here
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<G.length;i++){
            set.add(G[i]);
        }
        int counter =0;
        int result = 0;
        while(head !=null){
            int v = head.val;
            if(set.contains(v))
                counter++;
            else if(counter>0){
                result++;
                counter=0;
            }


            head = head.next;
        }
        if(counter>0)
            result++;
        return result;
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



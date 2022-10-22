import java.io.*;
import java.util.*;

public class MergeKSortedLists104MergeSort {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        List<ListNode> r = new LinkedList<>();




        out.flush();
        out.close();
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists.size()==1){
            return lists.get(0);
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.size()+1, new SortValue());

        ListNode head = null;
        ListNode tail = head;
        for(int i=0;i<lists.size();i++){
            if(lists.get(i)!=null)
                pq.offer(lists.get(i));
        }
        ListNode cur = null;
        while(!pq.isEmpty()){
            cur = pq.poll();
            if(head== null){
                head = new ListNode(cur.val);
                tail = head;
            }else{
                tail.next = new ListNode(cur.val);
                tail = tail.next;
            }


            if(cur.next!=null){
                pq.offer(cur.next);
            }

        }
        return head;
    }
    class SortValue implements Comparator<ListNode> {
        public int compare(ListNode a, ListNode b)
        {
            return a.val - b.val;
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




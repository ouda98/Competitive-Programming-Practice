package CP_4_7_2_Trees;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Tree_UVa548 {
    static int[] in;
    static int[] post;
    static int min;
    static int result;
    static int postIndex;
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        while (sc.ready()) {
            String[] l = sc.nextLine().split(" ");
            in = new int[l.length];
            post = new int[l.length];
            for (int i = 0; i < l.length; i++)
                in[i] = Integer.parseInt(l[i]);
            for (int i = 0; i < l.length; i++)
                post[i] = sc.nextInt();
            map.clear();
            for (int i = 0; i < in.length; i++)
                map.put(in[i], i);
            postIndex = post.length - 1;
            Node root = buildUtil(in, post,0,in.length-1);
            Node s = root;
            min = Integer.MAX_VALUE;
            findMin(root,root.val);
            System.out.println(result);


        }


        out.flush();
        out.close();
    }


    private static Node buildUtil(int[] in, int[] post, int start, int end) {
        if(start>end)
            return null;
        int cur = post[postIndex];
        Node node = new Node(cur);
        postIndex--;

        if(start == end)
            return node;


        int pos = map.get(cur);
        node.right = buildUtil(in,post,pos+1,end);
        node.left = buildUtil(in,post,start,pos-1);
        return node;
    }

    private static void findMin(Node root, int sum) {
        if (root.left == null && root.right == null) {
            if (sum < min || (sum==min && result>root.val)) {
                min = sum;
                result = root.val;
            }
            return;
        }
        if (root.left != null)
            findMin(root.left, sum + root.left.val);
        if (root.right != null)
            findMin(root.right, sum + root.right.val);

    }


    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
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



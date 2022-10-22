package CP_4_7_2_Trees;

import java.io.*;
import java.util.*;

public class BinarySearchTree_UVa {
    static ArrayList<Integer> list;
    static int idx;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        list = new ArrayList<>();
        while (sc.ready()) {
            list.add(sc.nextInt());
        }
        idx = 0;
        Node root = solve(Integer.MAX_VALUE);
        Node s = root;
        traversePostOrder(root);
        out.flush();
        out.close();
    }

    private static void traversePostOrder(Node root) {
        if(root.left!=null)
            traversePostOrder(root.left);
        if(root.right!=null)
            traversePostOrder(root.right);
        System.out.println(root.val);
    }


    private static Node solve(int max) {
        Node node = new Node(list.get(idx));

        if (idx == list.size()-1)
            return node;

        if (list.get(idx + 1) < node.val) {
            idx++;
            node.left = solve(node.val);
        }
        if (idx == list.size()-1)
            return node;

        if (list.get(idx + 1) > node.val) {
            if (list.get(idx + 1) < max) {
                idx++;
                node.right = solve(max);
            }
        }

        return node;
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
package CP_4_7_2_Trees;

import java.io.*;
import java.util.*;

public class TreesOnTheLevel {
    static int count;
    static HashMap<String, Integer> map;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        while (sc.ready()) {
            map = new HashMap<>();
            String line = "";
            while (true) {
                String l = sc.nextLine();
                if (l.charAt(l.length() - 1) == ')' && l.charAt(l.length() - 2) == '(') {
                    line += " " + l;
                    break;
                }
                else
                    line += " " + l;
            }

            String[] list = line.trim().split(" ");

            int nodes = list.length - 1;
            int rootVal = -1;
            for (int i = 0; i < list.length - 1; i++) {
                String[] s = list[i].substring(1, list[i].length() - 1).split(",");
                if (s.length == 1)
                    rootVal = Integer.parseInt(s[0]);
                else
                    map.put(s[1], Integer.parseInt(s[0]));
            }
            if (rootVal == -1) {
                System.out.println("not complete");
                continue;
            }
            Node root = new Node(rootVal);
            Node s = root;
            count = 0;
            build(s, "");
            if (count != nodes - 1) {
                System.out.println("not complete");
                continue;
            }

            printLevel(root);


        }


        out.flush();
        out.close();

    }

    private static void printLevel(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            sb.append(" " + cur.val);
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
        System.out.println(sb.substring(1));

    }

    private static void build(Node root, String direction) {
        if (map.containsKey(direction + "L")) {
            root.left = new Node(map.get(direction + "L"));
            count++;
            build(root.left, direction + "L");
        }
        if (map.containsKey(direction + "R")) {
            root.right = new Node(map.get(direction + "R"));
            count++;
            build(root.right, direction + "R");
        }


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

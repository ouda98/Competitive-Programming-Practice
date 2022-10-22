package CP_9_18_LowestCommonAncestor;

import Template.template;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FleaCircus_UVa10938NotWorking {
    static ArrayList<Integer> path1;
    static ArrayList<Integer> path2;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        HashMap<Integer, Node> map = new HashMap<>();
        while (sc.ready()) {
            boolean f = false;
            int root = -1;
            int edges = sc.nextInt();
            if(edges==0)
                return;
            while (edges-- > 1) {
                int from = sc.nextInt();
                if (!f)
                    root = from;
                f = true;
                int to = sc.nextInt();
                Node nodeTo = new Node(to);
                Node nodeFrom = new Node(from);
                if (!map.containsKey(from)) {
                    nodeFrom.children = new ArrayList<>();
                    nodeFrom.children.add(nodeTo);
                    map.put(from, nodeFrom);
                } else {
                    nodeFrom = map.get(from);
                    if (nodeFrom.children == null)
                        nodeFrom.children = new ArrayList<>();
                    nodeFrom.children.add(nodeTo);
                    map.put(from, nodeFrom);
                }
                if (!map.containsKey(to))
                    map.put(to, nodeTo);
            }
            int quries = sc.nextInt();
            path1 = new ArrayList<>();
            path2 = new ArrayList<>();
            while (quries-- > 0) {
                path1.clear();
                path2.clear();
                int one = sc.nextInt();
                int two = sc.nextInt();
//                System.out.println(one+ " " + two);
                path1.add(root);
                getPass(map.get(root), one);
                path2.add(root);
                getPass2(map.get(root), two);
//                System.out.println(Arrays.toString(path1.toArray()));
//                System.out.println(Arrays.toString(path2.toArray()));
                int i = 0;
                while (i < path1.size() && i < path2.size() && path1.get(i) == path2.get(i)) {
                    i++;
                }
                i--;
                if (path2.size() == path1.size())
                    System.out.println("The fleas meet at " + path1.get(i) + ".");
                else if (path1.size() < path2.size()) {
                    int r = (path2.size() - 1) - (path1.size() - i) + 1;
                    boolean met = false;
                    while (i <= r) {
                        if (i == r) {
                            met = true;
                            System.out.println("The fleas meet at " + path2.get(r) + ".");
                            break;
                        } else {
                            i++;
                            r--;
                        }
                    }
                    if (!met) {
                        System.out.println("The fleas jump forever between " + path2.get(r) + " and " + path2.get(i) + ".");
                    }

                } else {
                    int r = (path1.size() - 1) - (path2.size() - i) + 1;
                    boolean met = false;
                    while (i <= r) {
                        if (i == r) {
                            met = true;
                            System.out.println("The fleas meet at " + path1.get(r) + ".");
                            break;
                        } else {
                            i++;
                            r--;
                        }
                    }
                    if (!met) {
                        System.out.println("The fleas jump forever between " + path1.get(r) + " and " + path1.get(i) + ".");
                    }

                }


            }
        }
        out.flush();
        out.close();
    }

    private static boolean getPass(Node node, int target) {
        if (node.val == target) {
            return true;
        }
        if (node.children == null)
            return false;

        for (int i = 0; i < node.children.size(); i++) {
            path1.add(node.children.get(i).val);
            if (getPass(node.children.get(i), target))
                return true;
            path1.remove(path1.size() - 1);
        }
        return false;
    }

    private static boolean getPass2(Node node, int target) {
        if (node.val == target) {
            return true;
        }
        if (node.children == null)
            return false;

        for (int i = 0; i < node.children.size(); i++) {
            path2.add(node.children.get(i).val);
            if (getPass2(node.children.get(i), target))
                return true;
            path2.remove(path2.size() - 1);
        }
        return false;
    }


    public static class Node {
        int val;
        ArrayList<Node> children;

        public Node(int val) {
            this.val = val;
            this.children = null;
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


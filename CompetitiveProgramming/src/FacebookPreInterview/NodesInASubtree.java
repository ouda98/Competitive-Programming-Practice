package FacebookPreInterview;

import java.util.*;

public class NodesInASubtree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.children.add(new Node(2));
        root.children.add(new Node(3));
        ArrayList<Query> e = new ArrayList<>();
        e.add(new Query(1,'a'));
        System.out.println(Arrays.toString(countOfNodes(root, e, "aba")));


    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
            val = 0;
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    static class Query {
        int u;
        char c;

        Query(int u, char c) {
            this.u = u;
            this.c = c;
        }
    }

    // Add any helper functions you may need here


    static int[] countOfNodes(Node root, ArrayList<Query> queries, String s) {
        // Write your code here
        int[] result = new int[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            Node copy = root;
            int targetNode = queries.get(i).u;
            char targetChar = queries.get(i).c;
            Node target = bfs(copy, targetNode);
            int count = countLetters(target, s, targetChar);
            result[i] = count;
        }
        return result;

    }


    public static int countLetters(Node target, String s, char targetChar) {
        int count = 0;
        Queue<Node> q = new LinkedList<>();
        System.out.println(s+" "+target);
        if (s.charAt(target.val - 1) == targetChar)
            count++;
        q.add(target);
        while (!q.isEmpty()) {
            Node top = q.poll();
            if (top.children != null) {
                for (Node r : top.children) {
                    if (s.charAt(r.val - 1) == targetChar)
                        count++;
                    q.add(r);
                }
            }
        }

        return count;
    }

    public static Node bfs(Node copy, int targetNode) {
        if(copy.val == targetNode)
            return copy;
        Queue<Node> q = new LinkedList<>();
        q.add(copy);
        while (!q.isEmpty()) {
            Node top = q.poll();
            if (top.children != null) {
                for (Node s : top.children) {
                    if (s.val == targetNode)
                        return s;
                    else
                        q.add(s);
                }
            }
        }
        return null;
    }
}

package CP_3_2_2_RecursiveCompeleteSearch;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GraphColoring_UVa00193 {
    static ArrayList<Integer>[] adjList;
    static int[] nodes;
    static int n;
    static int max;
    static int[] result;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        int cases = sc.nextInt();
        while (cases-- > 0) {
            n = sc.nextInt();
            nodes = new int[n + 1];
            visited = new boolean[n + 1];
            int edges = sc.nextInt();
            adjList = new ArrayList[n + 1];
            for (int i = 0; i < adjList.length; i++)
                adjList[i] = new ArrayList<>();

            //-1 not set, 0 white, 1 black

            for (int i = 0; i < edges; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                adjList[from].add(to);
                adjList[to].add(from);
            }
            max = 0;
            for(int i=1;i<nodes.length;i++) {
                Arrays.fill(nodes, -1);
                solve(i);
            }
            System.out.println(max);
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < result.length; i++) {
                if (result[i] == 1)
                    sb.append(i + " ");
            }
            System.out.println(sb.substring(0,sb.length()-1));

        }


        out.flush();
        out.close();
    }

    private static void solve(int idx) {
        if(adjList[idx].size()==0) {
            nodes[idx] = 1;
        }
        for (int next : adjList[idx]) {
            nodes[idx] = 0;
            if (nodes[next] == -1)
                solve(next);

            if (canBlack(idx)) {
                nodes[idx] = 1;
                if (nodes[next] == -1)
                    solve(next);
            }

        }
        for(int i=1;i<nodes.length;i++)
            if(nodes[i]==-1)
                solve(i);


        Pair base = allColored();
        if (base.color == 1) {
            if (max < base.node) {
                max = base.node;
                result = nodes.clone();
            }
            return;
        }
    }

    private static Pair allColored() {
        int sum = 0;
        for (int i = 1; i < nodes.length; i++) {
            if (nodes[i] == -1)
                return new Pair(1, -1);
            if (nodes[i] == 1)
                sum++;
        }
        return new Pair(sum, 1);
    }

    private static boolean canBlack(int idx) {
        for (int i = 0; i < adjList[idx].size(); i++)
            if (nodes[adjList[idx].get(i)] == 1)
                return false;
        return true;
    }

    public static class Pair {
        int node;
        int color;

        public Pair(int node, int color) {
            this.node = node;
            this.color = color;
        }

        public String toString() {
            return node + " " + color;
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



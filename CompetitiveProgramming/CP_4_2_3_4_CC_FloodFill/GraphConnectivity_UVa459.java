package CP_4_2_3_4_CC_FloodFill;

import java.io.*;
import java.util.*;

public class GraphConnectivity_UVa459 {
    static LinkedList<Integer>[] adjList;
    static boolean[] visited;
    static HashMap<String, Pair> paths;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/CP4_2_3/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int cases = sc.nextInt();
        sc.nextLine();
        int counter;
        for (int i = 0; i < cases; i++) {
            counter=0;
            int nodes = sc.nextChar() - 64;
            adjList = new LinkedList[nodes];
            visited = new boolean[nodes];
            for (int j = 0; j < adjList.length; j++)
                adjList[j] = new LinkedList<>();
            while (true) {
                String edge = sc.nextLine();
                if (edge== null || edge.length()==0)
                    break;
                int from = edge.charAt(0) - 65;
                int to = edge.charAt(1) - 65;
                adjList[from].add(to);
                adjList[to].add(from);
            }

            for (int j = 0; j < adjList.length; j++) {
                if (!visited[j]){
                    counter++;
                    dfs(j);

                }

            }
            out.println(counter);
            if(!(i==cases-1))
                out.println();
        }
        out.flush();
        out.close();
    }

    private static void dfs(int key) {
        visited[key] = true;
        for (int i = 0; i < adjList[key].size(); i++) {
            int to = adjList[key].get(i);
            if(!visited[to])
                dfs(to);
        }
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getRow() {
            return x;
        }

        public void setRow(int x) {
            this.x = x;
        }

        public int getValue() {
            return y;
        }

        public void setValue(int y) {
            this.y = y;
        }

        public String toString() {
            return "to " + this.x + " time " + this.y;
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


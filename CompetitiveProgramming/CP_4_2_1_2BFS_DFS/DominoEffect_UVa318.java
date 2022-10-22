package CP_4_2_1_2BFS_DFS;

import java.io.*;
import java.util.*;

public class DominoEffect_UVa318 {
    static LinkedList<Pair>[] adjList;
    static boolean[] visited;
    static HashMap<String, Pair> paths;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/CP4_2_1_2/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        visited = new boolean[505];
        paths = new HashMap<>();
        while (sc.ready()) {
            int keyDominoes = sc.nextInt();
            if (keyDominoes == 0) break;
            adjList = new LinkedList[keyDominoes + 1];
            for (int i = 0; i < adjList.length; i++) {
                adjList[i] = new LinkedList<>();
            }
            int rows = sc.nextInt();
            for (int i = 0; i < rows; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                int time = sc.nextInt();
//                System.out.println("from "+from +" to "+ to+" time "+time);
                adjList[from].add(new Pair(to, time));
//                adjList[to].add(new Pair(from,time));

            }
//            for(int i=0;i< adjList.length;i++){
//                System.out.println("from "+i+" "+adjList[i]);
//            }
            dfs(1, 0);

            for (String e : paths.keySet()) {
                System.out.println(e + " " + paths.get(e));
            }

            Arrays.fill(visited, false);
        }

        out.flush();
        out.close();
    }

    private static void dfs(int key, int count) {
        visited[key] = true;

        for (int i = 0; i < adjList[key].size(); i++) {
//            System.out.println(i+" "+key);
            int to = adjList[key].get(i).x;
            int time = adjList[key].get(i).y;
            paths.put(key + "" + to, new Pair(count, time));


            if (!visited[to]) {
                dfs(to, count + time);
            }
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


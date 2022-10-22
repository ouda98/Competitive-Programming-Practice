package CP_4_3_MST;

import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DarkRoads_UVa11631Prim_TLE {
    static LinkedList<Pair>[] adjList;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
        //        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        while (sc.ready()) {
            int nodes = sc.nextInt();
            int edges = sc.nextInt();
            if(nodes ==0 && edges ==0)
                break;
            int totalSum = 0;
            adjList = new LinkedList[nodes];
            for (int i = 0; i < adjList.length; i++)
                adjList[i] = new LinkedList<>();
            for (int i = 0; i < edges; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                int cost = sc.nextInt();
                totalSum += cost;
                adjList[from].add(new Pair(to, cost));
                adjList[to].add(new Pair(from, cost));
            }

            int e =0;
            int cur =0;
            boolean[]visited = new boolean[nodes];
            visited[cur] = true;
            queue.clear();
            while(e<nodes-1){
                for(int i=0;i< adjList[cur].size();i++)
                    queue.add(adjList[cur].get(i));

                while(!queue.isEmpty()){
                    Pair top = queue.poll();
                    if(!visited[top.to]){
                        visited[top.to]=true;
                        cur = top.to;
                        totalSum-=top.weight;
                        e++;
                        break;
                    }
                }
            }
            out.println(totalSum);
        }


        out.flush();
        out.close();
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return x + " " + y;
        }
    }

    static class Pair implements Comparable {
        int to;
        double weight;

        public Pair(int to, double weight) {
            this.to = to;
            this.weight = weight;
        }

        public String toString() {
            return to + " " + weight;
        }

        @Override
        public int compareTo(Object o) {
            if (this.weight == ((Pair) o).weight) {
                return this.to - ((Pair) o).to;
            }
            return Double.compare(this.weight, ((Pair) o).weight);
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




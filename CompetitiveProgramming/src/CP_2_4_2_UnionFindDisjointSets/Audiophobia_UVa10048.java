package CP_2_4_2_UnionFindDisjointSets;

import java.io.*;
import java.util.*;

public class Audiophobia_UVa10048 {
    static ArrayList<Triple> edges = new ArrayList<>();
    static LinkedList<Pair>[] adjList;
    static boolean[] visited;
    static boolean r;



    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
        //        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        boolean f = false;
        int caseN = 0;
        while (sc.ready()) {
            caseN++;

            int nodes = sc.nextInt();
            int eCount = sc.nextInt();
            int q = sc.nextInt();
            if (nodes == 0 && eCount == 0 && q == 0)
                break;
            if(f)
                System.out.println();
            f = true;
            edges.clear();
            for (int i = 0; i < eCount; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                int weight = sc.nextInt();
                edges.add(new Triple(from, to, weight));
            }
            Collections.sort(edges);
            UFDS sites = new UFDS(nodes + 1);
            int e = 0;
            int c = 0;
            adjList = new LinkedList[nodes + 1];
            visited = new boolean[nodes + 1];

            for (int i = 0; i < adjList.length; i++)
                adjList[i] = new LinkedList<>();

            while (e < nodes - 1 && c < edges.size()) {
                Triple current = edges.get(c);
                int x = sites.findSet(current.from);
                int y = sites.findSet(current.to);
                if (x != y) {
                    adjList[current.from].add(new Pair(current.to, current.weight));
                    adjList[current.to].add(new Pair(current.from, current.weight));
                    sites.unionSet(x, y);
                    e++;
                }
                c++;
            }
            System.out.println("Case #" + caseN);
            for (int i = 0; i < q; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                Arrays.fill(visited, false);
                r= false;
                dfs(start, end, 0);
                if(!r)
                    System.out.println("no path");
            }



        }


        out.flush();
        out.close();
    }

    private static void dfs(int start, int end, int max) {
        for (int i = 0; i < adjList[start].size(); i++) {
            if (!visited[adjList[start].get(i).to]) {
                visited[adjList[start].get(i).to] = true;
                if (max < adjList[start].get(i).weight)
                    max = adjList[start].get(i).weight;
                if (adjList[start].get(i).to == end) {
                    r = true;
                    System.out.println(max);
                    return;
                }
                dfs(adjList[start].get(i).to, end, max);
            }

        }
    }

    static class Pair {
        int to;
        int weight;

        public Pair(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        public String toString() {
            return to + " " + weight;
        }

    }

    static class Triple implements Comparable {
        int from;
        int to;
        int weight;

        public Triple(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public String toString() {
            return from + " " + to + " " + weight;
        }


        @Override
        public int compareTo(Object o) {
            return this.weight - ((Triple) o).weight;
        }
    }

    static class UFDS {

        private int numSets, p[], rank[], setSize[];

        public UFDS(int n) {
            this.numSets = n;
            this.p = new int[n];
            this.rank = new int[n];
            this.setSize = new int[n];
            for (int i = 0; i < n; ++i) {
                p[i] = i;
                rank[i] = 0;
                setSize[i] = 1;
            }
        }

        public int findSet(int i) {
            if (p[i] == i) return i;
            p[i] = findSet(p[i]);
            return p[i];
        }

        public boolean isSameSet(int i, int j) {
            return findSet(i) == findSet(j);
        }

        public void unionSet(int i, int j) {
            if (isSameSet(i, j))
                return;
            numSets--;
            int x = findSet(i), y = findSet(j);
            if (rank[x] > rank[y]) {
                p[y] = x;
                setSize[x] += setSize[y];
            } else {
                p[x] = y;
                setSize[y] += setSize[x];
                if (rank[x] == rank[y]) rank[y]++;
            }
        }

        public int numDisjointSets() {
            return numSets;
        }

        public int sizeOfSet(int i) {
            return setSize[findSet(i)];
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





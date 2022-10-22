package CP_4_3_MST;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class DarkRoads_UVa11631 {
    static ArrayList<Triple> edges = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
        //        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        boolean f = false;
        while (sc.ready()) {
            int nodes = sc.nextInt();
            int lines = sc.nextInt();
            if(nodes==0 && lines==0)
                break;
            edges.clear();
            int totalSum = 0;
            for (int i = 0; i < lines; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                int weight = sc.nextInt();
                totalSum += weight;
                edges.add(new Triple(from, to, weight));
            }
            Collections.sort(edges);
            UFDS sites = new UFDS(nodes + 1);
            int e = 0;
            int c = 0;
            int sum = 0;
            while (e < nodes - 1) {
                Triple current = edges.get(c++);
                int x = sites.findSet(current.from);
                int y = sites.findSet(current.to);
                if (x != y) {
                    sites.unionSet(x, y);
                    e++;
                    totalSum -= current.weight;
                }
            }
            out.println(totalSum);


        }


        out.flush();
        out.close();
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




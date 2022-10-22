package CP_4_3_MST;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ACMContestAndBlackout_UVa10600 {
    static ArrayList<Triple> edges = new ArrayList<Triple>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
        //        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int cases = sc.nextInt();
        while (cases-- > 0) {
            int schools = sc.nextInt();
            int lines = sc.nextInt();
            Point[] points = new Point[lines];
            edges.clear();
            for (int i = 0; i < lines; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                int distance = sc.nextInt();
                    edges.add(new Triple(from, to, distance));
                }

            ArrayList<Integer> visited = new ArrayList<>();
            Collections.sort(edges);
            UFDS networks = new UFDS(schools+1);
            int e = 0;
            int c = 0;
            int sum0 = 0;
            while (e < schools-1) {
                Triple top = edges.get(c);

                int x = networks.findSet(top.from);
                int y = networks.findSet(top.to);
                if (x != y) {
                    networks.unionSet(x, y);
                    visited.add(c);
                    e++;
                    sum0  += top.weight;
                }
                c++;
            }
            int min = Integer.MAX_VALUE;
            for(int i=0;i<visited.size();i++){
                networks = new UFDS(schools+1);
                e = 0;
                c = 0;
                int sum = 0;
                while (e < schools-1 && c<edges.size()) {
                    Triple top = edges.get(c);

                    int x = networks.findSet(top.from);
                    int y = networks.findSet(top.to);

                    if (x != y && c!=visited.get(i)) {
                        networks.unionSet(x, y);
                        e++;
                        sum  += top.weight;
                    }
                    c++;
                }
                if(e == schools-1)
                    if(min>sum)
                        min = sum;

            }
            System.out.println( sum0+" "+min);
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

    static class Triple implements Comparable {
        int from;
        int to;
        double weight;

        public Triple(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public String toString() {
            return from + " " + to + " " + weight;
        }


        @Override
        public int compareTo(Object o) {
            return Double.compare(this.weight, ((Triple) o).weight);
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




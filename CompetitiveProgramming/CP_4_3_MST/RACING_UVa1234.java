package CP_4_3_MST;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RACING_UVa1234 {
    static Triple[] edges;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
        //        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int cases = sc.nextInt();
        while(cases-->0){
            int nodes = sc.nextInt();
            if(nodes==0)
                break;
            int eCount = sc.nextInt();
            edges = new Triple[eCount];
            for(int i=0;i<eCount;i++){
                edges[i] = new Triple(sc.nextInt(),sc.nextInt(),sc.nextInt());
            }
            Arrays.sort(edges);
            UFDS roads = new UFDS(nodes+1);
            int e=0;
            int c=0;
            int sum =0;
            while(e<nodes-1){

                Triple top = edges[c++];
                int x = roads.findSet(top.from);
                int y = roads.findSet(top.to);
                if(x!=y){
                    e++;
                    roads.unionSet(x,y);
                }else{
                    sum+=top.weight;
                }
            }
            for(;c< edges.length;c++){
                sum+=edges[c].weight;
            }
            out.println(sum);
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
            return ((Triple) o).weight - this.weight;
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




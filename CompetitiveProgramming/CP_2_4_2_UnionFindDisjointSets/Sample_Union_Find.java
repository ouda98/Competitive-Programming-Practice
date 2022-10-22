package CP_2_4_2_UnionFindDisjointSets;

import java.io.*;
import java.util.StringTokenizer;

public class Sample_Union_Find {
    static Pair [] edges;
    static int v;
    static Rank[] subset;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
        //        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        v = sc.nextInt();
        int e = sc.nextInt();
        edges = new Pair[e];
        for(int i=0;i<e;i++){
            edges[i] = new Pair(sc.nextInt(),sc.nextInt());
        }
        System.out.println(isCycle());
        out.flush();
        out.close();
    }

    private static boolean isCycle() {
        subset = new Rank[v];
        for(int i=0;i<subset.length;i++)
            subset[i] = new Rank(i,0);

        for(int i=0;i<edges.length;i++){
            int x = find(edges[i].from);
            int y = find(edges[i].to);
            System.out.println(edges[i].from+" "+edges[i].to);
//            System.out.println(x+" "+y);
            if(x==y)
                return false;
            union(x,y);
        }

        return true;
    }

    private static void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if(subset[xRoot].rank<subset[yRoot].rank){
            subset[xRoot].parent = yRoot;
        }else if(subset[xRoot].rank>subset[yRoot].rank){
            subset[yRoot].parent = yRoot;
        }else{
            subset[xRoot].parent = yRoot;
            subset[yRoot].rank++;
        }
    }

    private static int find(int from) {
        if(subset[from].parent!=from)
            subset[from].parent = find(subset[from].parent);
        return subset[from].parent;
    }

    static class Rank{
        int parent;
        int rank;
        public Rank(int parent, int rank){
            this.parent = parent;
            this.rank = rank;
        }
        public String toString(){
            return parent+" "+rank;
        }
    }

    static class Pair{
        int from;
        int to;
        public Pair(int from, int to){
            this.from = from;
            this.to = to;
        }
        public String toString(){
            return from+" "+to;
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



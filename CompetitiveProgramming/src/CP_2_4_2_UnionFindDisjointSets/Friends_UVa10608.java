package CP_2_4_2_UnionFindDisjointSets;

import java.io.*;
import java.util.StringTokenizer;

public class Friends_UVa10608 {
    static Pair[] people;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
        //        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int cases = sc.nextInt();
        while(cases-->0){
            int pCount = sc.nextInt();
            int friendships = sc.nextInt();
            people = new Pair[pCount+1];
            for(int i=0;i<people.length;i++)
                people[i] = new Pair(i,0);
            for(int i=0;i<friendships;i++){
                int from = sc.nextInt();
                int to = sc.nextInt();
                int x = find(from);
                int y = find(to);
                union(x,y);
            }
            int [] count = new int[people.length];
            int max =0;
            for(int i=0;i< people.length;i++){
                int r = find(i);
                count[r]++;
                if(count[r]>max)
                    max = count[r];
            }
            out.println(max);
        }


        out.flush();
        out.close();
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if(people[rootX].rank<people[rootY].rank)
            people[rootX].parent = rootY;
        else if(people[rootX].rank>people[rootY].rank)
            people[rootY].parent = rootX;
        else{
            people[rootY].parent = rootX;
            people[rootX].rank++;
        }
    }

    private static int find(int from) {
        if(people[from].parent!=from)
            people[from].parent = find(people[from].parent);
        return people[from].parent;
    }

    static class Pair{
        int parent;
        int rank;
        public Pair(int parent, int rank){
            this.parent = parent;
            this.rank = rank;
        }
        public String toString(){
            return parent+" "+rank;
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




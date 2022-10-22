package CP_2_4_2_UnionFindDisjointSets;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class UbiquitousReligions_UVa10583 {
    static Pair[] religions;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
        //        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int c=1;
        while (sc.ready()) {
            int rCount = sc.nextInt();
            int lines = sc.nextInt();
            if(lines ==0 && rCount==0)
                break;
            religions = new Pair[rCount+1];
            for (int i = 1; i < religions.length; i++)
                religions[i] = new Pair(i, 0);

            for (int i = 0; i < lines; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                int x = find(from);
                int y = find(to);
                union(x, y);
            }
            HashSet<Integer> unique = new HashSet<>();
            int count = 0;

            for (int i = 1; i < religions.length; i++) {
                int root = find(religions[i].parent);
                if(religions[i]==null)
                    unique.add(i);
                else if (!unique.contains(root)){
                    count++;
                    unique.add(root);
                }

            }
            out.println("Case "+c+": "+count);
            c++;


        }


        out.flush();
        out.close();
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (religions[rootX].rank < religions[rootY].rank)
            religions[rootX].parent = rootY;
        else if (religions[rootX].rank > religions[rootY].rank)
            religions[rootY].parent = rootX;
        else {
            religions[rootY].parent = rootX;
            religions[rootX].rank++;
        }
    }

    private static int find(int from) {
        if (religions[from].parent != from)
            religions[from].parent = find(religions[from].parent);
        return religions[from].parent;
    }

    static class Pair {
        int parent;
        int rank;

        public Pair(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }

        public String toString() {
            return parent + " " + rank;
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




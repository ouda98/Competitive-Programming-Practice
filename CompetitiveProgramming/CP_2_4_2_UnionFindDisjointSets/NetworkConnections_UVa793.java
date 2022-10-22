package CP_2_4_2_UnionFindDisjointSets;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NetworkConnections_UVa793 {
    static Pair[] computers;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
        //        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int cases = sc.nextInt();

        while (cases-- > 0) {
            int right = 0;
            int wrong = 0;
            int compNo = sc.nextInt();

            computers = new Pair[compNo + 1];
            for (int i = 0; i < computers.length; i++)
                computers[i] = new Pair(i, 0);

            while (sc.ready()) {

                String line = sc.nextLine();
                if(line.isEmpty())
                    break;
                String[] s = line.split(" ");
                char letter = s[0].charAt(0);
                int from = Integer.parseInt(s[1]);
                int to = Integer.parseInt(s[2]);

                if (letter == 'q') {
                    if (find(from) == find(to))
                        right++;
                    else
                        wrong++;

                } else {
                    int x = find(from);
                    int y = find(to);
                    union(x, y);
                }
            }
            System.out.println(Arrays.toString(computers));
            out.println(right + "," + wrong);
            if(cases!=0)
                out.println();

        }


        out.flush();
        out.close();
    }

    private static void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (computers[xRoot].rank < computers[yRoot].rank)
            computers[xRoot].parent = yRoot;
        else if (computers[xRoot].rank > computers[yRoot].rank)
            computers[yRoot].parent = xRoot;
        else {
            computers[yRoot].parent = xRoot;
            computers[yRoot].rank++;
        }

    }

    private static int find(int from) {
        if (computers[from].parent != from)
            computers[from].parent = find(computers[from].parent);
        return computers[from].parent;
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



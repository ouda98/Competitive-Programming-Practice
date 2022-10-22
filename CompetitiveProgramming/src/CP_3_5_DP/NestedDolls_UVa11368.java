package CP_3_5_DP;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NestedDolls_UVa11368 {
    static Pair[] dolls;
    static int[] memo;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        int cases = sc.nextInt();
        while (cases-- > 0) {
            int n = sc.nextInt();
            dolls = new Pair[n];
            for (int i = 0; i < n; i++)
                dolls[i] = new Pair(sc.nextInt(), sc.nextInt());
            Arrays.sort(dolls);

            memo = new int[dolls.length + 1];
            int max = 1;
            memo[0] = 1;

            for (int i = 1; i < dolls.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (dolls[i].h <= dolls[j].h) {
                        memo[i] = Math.max(memo[i], memo[j] + 1);
                    }

                }
                if(memo[i]==0)
                    memo[i]=1;
                max = Math.max(max, memo[i]);
            }

            System.out.println(max);


        }

        out.flush();
        out.close();
    }


    static class Pair implements Comparable<Pair> {
        int w;
        int h;

        public Pair(int w, int h) {
            this.w = w;
            this.h = h;
        }

        public String toString() {
            return w + " " + h;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.w == o.w)
                return o.h - this.h;
            return this.w - o.w;
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


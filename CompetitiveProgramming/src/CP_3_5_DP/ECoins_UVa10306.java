package CP_3_5_DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ECoins_UVa10306 {
    static long[][][] memo = new long[101][1000][1000];
    static int eValue;
    static Pair[] arr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
//        PrintWriter out = new PrintWriter("src/txt.out");
        PrintWriter out = new PrintWriter(System.out);
        int cases = sc.nextInt();
        while (cases-- > 0) {
            int n = sc.nextInt();
            eValue = sc.nextInt();
            arr = new Pair[n];
            for (int i = 0; i < n; i++)
                arr[i] = new Pair(sc.nextInt(), sc.nextInt());

            for (int i = 0; i < memo.length; i++)
                for (int j = 0; j < memo[i].length; j++)
                    Arrays.fill(memo[i][j], -1);

            long r = solve(0, 0, 0);
            if (r == Integer.MAX_VALUE)
                out.println("not possible");
            else
                out.println(r);
        }


        out.flush();
        out.close();

    }

    private static long solve(int idx, int c, int t) {
//        SQRT(X ∗ X + Y ∗ Y ),
        double e = Math.sqrt((c * c) + (t * t));
//        System.out.println(e+" "+eValue+"  "+(e==eValue)+" "+c+" "+t);
        if (e == eValue)
            return 0;
        if (e > eValue || idx >= arr.length)
            return Integer.MAX_VALUE;
        if (memo[idx][c][t] != -1)
            return memo[idx][c][t];

        long result = Math.min(1 + solve(idx, c + arr[idx].x, t + arr[idx].y), solve(idx + 1, c, t));

        return memo[idx][c][t] = result;

    }

    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return x + " " + y;
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

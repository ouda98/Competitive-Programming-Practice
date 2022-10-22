package CP_3_5_DP;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BarCodes_UVa10721 {
    static int N;
    static int M;
    static long[][][][] memo = new long[51][51][51][2];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        while (sc.ready()) {
            N = sc.nextInt();


            int c = sc.nextInt();
            int m = sc.nextInt();
            M = m;
            for (int i = 0; i < memo.length; i++)
                for (int j = 0; j < memo[i].length; j++)
                    for (int k = 0; k < memo[i][j].length; k++)
                        Arrays.fill(memo[i][j][k], -1);

            System.out.println(solve(1, c-1, m-1, 0));
        }

        out.flush();
        out.close();
    }

    private static long solve(int n, int k, int m, int color) {
        if (n == N && k == 0) {
            return 1;
        }
        if (n >= N || k < 0 || m < 0)
            return 0;

        if (memo[n][k][m][color] != -1)
            return memo[n][k][m][color];

        long result = 0;
        if (m != 0)
            result = solve(n + 1, k, m - 1, color);
        result += solve(n + 1, k-1, M-1, (color == 0) ? 1 : 0);
        return memo[n][k][m][color] = result;
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

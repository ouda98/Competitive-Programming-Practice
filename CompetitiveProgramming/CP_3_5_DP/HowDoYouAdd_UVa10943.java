package CP_3_5_DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HowDoYouAdd_UVa10943 {
    static int[][] memo;
    static int N;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        while (sc.ready()) {
            int n = sc.nextInt();
            N = n;
            int k = sc.nextInt();
            if(n==0 && k==0)
                break;

            memo = new int[n + 1][k + 1];
            for (int i = 0; i < memo.length; i++)
                Arrays.fill(memo[i], -1);

            System.out.println(solve(n, k));
        }

        out.flush();
        out.close();
    }

    private static int solve(int n, int k) {
        if (k == 1)
            return 1;

        if (memo[n][k] != -1)
            return memo[n][k];

        int result = 0;
        for (int i = 0; i <=N;i++){
            if(n-i<0)
                break;
            result +=solve(n-i,k-1) % 1000000;

        }

        return memo[n][k] = result %1000000;


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




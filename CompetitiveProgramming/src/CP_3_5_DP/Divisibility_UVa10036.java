package CP_3_5_DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Divisibility_UVa10036 {
    static int d;
    static int[] arr;
    static long[][] memo = new long[10001][101];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        int cases = sc.nextInt();
        while (cases-- > 0) {
            int n = sc.nextInt();
            d = sc.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            for (int i = 0; i < memo.length; i++)
                Arrays.fill(memo[i], -1);

            if (solve(0, 0) == 0)
                System.out.println("Not divisible");
            else
                System.out.println("Divisible");

            for(int i=0;i< memo.length;i++)
                System.out.println(Arrays.toString(memo[i]));


        }
        out.flush();
        out.close();
    }

    private static long solve(int idx, int sum) {
        if (idx == arr.length && sum % d == 0) {
            System.out.println("here");
            return 1;
        }
        if (idx >= arr.length)
            return 0;

        if (memo[idx][sum] != -1)
            return memo[idx][sum];

        int s = ((sum + arr[idx]) % d + d) % d;
        int r = ((sum - arr[idx]) % d + d) % d;


        return memo[idx][sum] = solve(idx + 1, s) + solve(idx + 1, r);
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




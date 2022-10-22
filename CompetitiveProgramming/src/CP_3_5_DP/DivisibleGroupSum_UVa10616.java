package CP_3_5_DP;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DivisibleGroupSum_UVa10616 {
    static long[][][] memo = new long[201][21][21];
    static int[] arr;
    static int d;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        int c =1;
        while (sc.ready()) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            if (n == 0 && q == 0)
                break;
            arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            System.out.println("SET "+c+++":");
            for (int i = 0; i < q; i++) {
                d = sc.nextInt();
                int k = sc.nextInt();
                for (int j = 0; j < memo.length; j++)
                    for (int e = 0; e < memo[i].length; e++)
                        Arrays.fill(memo[j][e], -1);
                System.out.println("QUERY "+(i+1)+": "+solve(0, 0, k));

            }
        }


        out.flush();
        out.close();
    }

    private static long solve(int idx, int sum, int k) {
        if (k == 0 && sum % d == 0)
            return 1;

        if (k <= 0 || idx >= arr.length)
            return 0;
        if (memo[idx][sum][k] != -1)
            return memo[idx][sum][k];

        int s = ((sum + arr[idx]) % d + d) % d;


        return memo[idx][sum][k] = solve(idx + 1, s, k - 1) + solve(idx + 1, sum, k);
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




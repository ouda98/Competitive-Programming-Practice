package CP_6_5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LongestPalindrome_UVa11151 {
    static String line;
    static int[][] memo;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");

        int cases = sc.nextInt();
        while (cases-- > 0) {
            line = sc.nextLine();
            memo = new int[line.length() + 5][line.length() + 5];
            for (int i = 0; i < memo.length; i++) {
                Arrays.fill(memo[i], -1);
            }
            if (line.length() == 0)
                System.out.println(0);
            else
                System.out.println(solve(0, line.length() - 1));
        }


        out.flush();
        out.close();
    }

    private static int solve(int l, int r) {

        if (l == r)
            return 1;

        if (l + 1 == r)
            if (line.charAt(l) == line.charAt(r))
                return 2;
            else
                return 1;

        if (memo[l][r] != -1)
            return memo[l][r];


        if (line.charAt(l) == line.charAt(r))
            return memo[l][r] = 2 + solve(l + 1, r - 1);
        else
            return memo[l][r] = Math.max(solve(l + 1, r), solve(l, r - 1));
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




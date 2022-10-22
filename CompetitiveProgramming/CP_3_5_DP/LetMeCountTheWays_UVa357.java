package CP_3_5_DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LetMeCountTheWays_UVa357 {
    static long[][] memo = new long[6][30001];
    static int[] arr = {1, 5, 10, 25, 50};;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter("src/txt.out");
//        PrintWriter out = new PrintWriter(System.out);
        for (int i = 0; i < memo.length; i++)
            Arrays.fill(memo[i], -1);
        while (sc.ready()) {
            int change = sc.nextInt();



            for (int idx = arr.length - 1; idx >= 0; idx--) {
                for (int ch = 0; ch <= change; ++ch) {
                    solve(idx, ch);
                }
            }

            long result = solve(0, change);
            if(result==1)
                out.println("There is only "+result+" way to produce "+change+" cents change.");
            else
                out.println("There are "+result+" ways to produce "+change+" cents change.");
        }

        out.flush();
        out.close();

    }

    private static long solve(int idx, int change) {
        if (change == 0)
            return 1;
        if (idx >= arr.length)
            return 0;
        if (memo[idx][change] != -1)
            return memo[idx][change];

        long result = 0;
        if (arr[idx]<=change)
            result = solve(idx,change-arr[idx]);
        result+= solve(idx+1,change);

        return memo[idx][change]=result;

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

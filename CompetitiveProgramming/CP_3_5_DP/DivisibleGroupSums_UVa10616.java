package CP_3_5_DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DivisibleGroupSums_UVa10616 {
    static Pair[] arr;
    static int[][] memo;
    static boolean f = true;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        while (sc.ready()) {
            int n = sc.nextInt();
            if (n == 0)
                break;
            arr = new Pair[n];
            for (int i = 0; i < arr.length; i++)
                arr[i] = new Pair(sc.nextInt(), sc.nextInt());
            memo = new int[n + 1][6005];
            for (int i = 0; i < memo.length; i++)
                Arrays.fill(memo[i], -1);
            System.out.println(solve(0, 6002));

        }
        out.flush();
        out.close();
    }

    private static int solve(int idx, int min) {
        if (idx >= arr.length || min==0)
            return 0;

        if (memo[idx][min] != -1)
            return memo[idx][min];

        int result = 0;
        if (arr[idx].w <= min){
            result = 1 + solve(idx + 1, Math.min(min - arr[idx].w, arr[idx].l));
        }



        int r = solve(idx + 1, min);


        return memo[idx][min] = Math.max(result, r);

    }

    static class Pair {
        int w;
        int l;

        public Pair(int w, int l) {
            this.w = w;
            this.l = l;
        }

        public String toString() {
            return w + " " + l;
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




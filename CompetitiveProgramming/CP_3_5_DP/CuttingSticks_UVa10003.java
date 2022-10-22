package CP_3_5_DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CuttingSticks_UVa10003 {
    static int[] arr;
    static int memo[][];
    static int size;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        while (sc.ready()) {
            size = sc.nextInt();
            if (size==0)
                break;
            int n = sc.nextInt();
            arr = new int[n+2];
            arr[0] = 0;
            for (int i = 1; i < arr.length-1; i++)
                arr[i] = sc.nextInt();
            arr[n+1] = size;

            memo = new int[n + 3][n + 3];
            for (int i = 0; i < memo.length; i++)
                Arrays.fill(memo[i], -1);

            System.out.println("The minimum cutting is "+solve(0, arr.length-1)+".");
        }

        out.flush();
        out.close();
    }

    private static int solve(int left, int right) {
        if (left + 1 == right)
            return 0;

        if (memo[left][right] != -1)
            return memo[left][right];
        int result = Integer.MAX_VALUE;
        for(int i=left+1;i<right;i++){
            result = Math.min(result,solve(left, i) + solve(i, right) + (arr[right]-arr[left]));
        }

        return memo[left][right] = result;
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




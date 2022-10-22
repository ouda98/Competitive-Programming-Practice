package CP_3_5_DP;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class JillRidesAgain_UVa507MissingSolutionRecursiveTrialFailed {
    static int[] arr;
    static int[][] memo;
    static LinkedList<Integer> s;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int cases = sc.nextInt();
        int c=1;

        for (int i = 0; i < cases; i++) {
            int n = sc.nextInt();
            arr = new int[n - 1];
            for (int j = 0; j < arr.length; j++)
                arr[j] = sc.nextInt();

            memo = new int[n + 1][2];
            for (int j = 0; j < memo.length; j++)
                Arrays.fill(memo[j], -1);
            int result =Math.max(solve(0, 0), solve(0, 1));
//            for (int j = 0; j < memo.length; j++)
//                System.out.println(Arrays.toString(memo[j]));

            // TODO
            s = new LinkedList<>();

            int max = Math.max(solve(0, 0), solve(0, 1));

            if (max == solve(0, 0))
                trace(0, 0);
            else {
                trace(0, 1);
            }
            if(result>=0)
                System.out.println("The nicest part of route "+c+++" is between stops "+(s.getFirst()+1)+" and "+(s.getLast()+2));
            else
                System.out.println("Route "+c+++" has no nice parts");



        }


        out.flush();
        out.close();

    }

    private static int solve(int idx, int taken) {
        if (idx == arr.length && taken==1)
            return 0;
        if (idx == arr.length && taken==0)
            return -100000000;

        if (memo[idx][taken] != -1)
            return memo[idx][taken];

        if (taken == 1) {
            return memo[idx][taken] = Math.max(arr[idx] + solve(idx + 1, 1), arr[idx]);
        } else {
            return memo[idx][taken] = Math.max(arr[idx] + solve(idx + 1, 1), solve(idx + 1, 0));
        }
    }

    private static void trace(int idx, int taken) {
        if (idx == arr.length && taken==1)
            return;
        if (idx == arr.length && taken==0)
            return;

        if (taken == 1) {
            if (memo[idx][taken] == arr[idx] + solve(idx + 1, 1)) {
//                System.out.println(idx);
                trace(idx + 1, 1);
            } else {
                s.add(idx);
//                System.out.println(idx);
            }
        } else {
            if (memo[idx][taken] == arr[idx] + solve(idx + 1, 1)) {
                s.add(idx);
//                System.out.println(idx);
                trace(idx + 1, 1);
            } else {
                trace(idx + 1, 0);
            }
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

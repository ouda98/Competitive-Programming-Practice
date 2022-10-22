package CP_3_2_1_IterativeCompleteSearch;

import java.io.*;
import java.util.StringTokenizer;

public class Bars_UVa12455 {
    static int[] sums;
    static int target;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        int cases = sc.nextInt();
        while (cases-- > 0) {
            target = sc.nextInt();


            int n = sc.nextInt();
            sums = new int[n];

            for (int i = 0; i < n; i++)
                sums[i] = sc.nextInt();

            if(solve(0,0))
                System.out.println("YES");
            else
                System.out.println("NO");

        }


        out.flush();
        out.close();
    }

    private static boolean solve(int idx, int sum) {
        if(idx==sums.length && sum==target)
            return true;

        if(idx==sums.length)
            return false;

        boolean r = false;

        r |= solve(idx+1,sum+sums[idx]) | solve(idx+1,sum);
        return r;
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



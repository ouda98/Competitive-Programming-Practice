package CP_3_5_DP;

import java.io.*;
import java.util.StringTokenizer;

public class MaximumSum_UVa108 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        while (sc.ready()) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                    if (i > 0)
                        arr[i][j] += arr[i - 1][j];
                    if (j > 0)
                        arr[i][j] += arr[i][j - 1];

                    if (i > 0 && j > 0)
                        arr[i][j] -= arr[i - 1][j - 1];


                }
            }
//        for (int i = 0; i < n; i++)
//            System.out.println(Arrays.toString(arr[i]));

            int minValue = -127 * 100 * 100;
            int s = 0;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    for (int k = i; k < n; k++)
                        for (int l = j; l < n; l++) {
                            s = arr[k][l];
                            if (i > 0) s -= arr[i - 1][l];
                            if (j > 0) s -= arr[k][j - 1];
                            if (i > 0 && j > 0) s += arr[i - 1][j - 1];
                            minValue = Math.max(minValue, s);
                        }

            System.out.println(minValue);
        }


        out.flush();
        out.close();
    }
//    [0, -2, -9, -9]
//    [9, 9, -6, -13]
//    [5, 15, 5, -7]
//    [4, 27, 32, 23]


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



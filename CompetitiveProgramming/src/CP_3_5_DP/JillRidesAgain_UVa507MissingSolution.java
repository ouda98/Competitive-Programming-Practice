package CP_3_5_DP;

import java.io.*;
import java.util.StringTokenizer;

public class JillRidesAgain_UVa507MissingSolution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");

        int cases = sc.nextInt();
        int c = 1;
        while (cases-- > 0) {
            int nums = sc.nextInt();
            int[] arr = new int[nums - 1];
            for (int i = 0; i < arr.length; i++)
                arr[i] = sc.nextInt();

            int ans = 0;
            int sum = 0;
            int start = 1;
            int end = 1;
            int s = 0;

            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
//                System.out.println(sum);

                if (sum == ans) {
                    if (end - s < i + 2 - start) {
                        s = start;
                        end = i + 2;
                    }

                }
                if (sum > ans) {
                    ans = sum;
                    end = i + 2;
                    s = start;
                }


                if (sum < 0) {
                    start = i + 2;
                    sum = 0;

                }

            }
            if (ans == 0)
                System.out.println("Route " + c++ + " has no nice parts");
            else
                System.out.println("The nicest part of route " + c++ + " is between stops " + s + " and " + end);

        }

        out.flush();
        out.close();
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





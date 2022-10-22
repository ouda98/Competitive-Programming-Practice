package CP_3_2_1_IterativeCompleteSearch;

import java.io.*;
import java.util.StringTokenizer;

public class Division_UVa725 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
//        PrintWriter out = new PrintWriter(System.out);
        PrintWriter out = new PrintWriter("src/txt.out");
        boolean f = false;
        while (sc.ready()) {

            int N = sc.nextInt();
            if (N == 0)
                break;
            if (f)
                out.println();
            f = true;
            int used, temp;
            boolean have = false;
            for (int fghij = 1234; fghij <= 98765 / N; fghij++) {
                used = 0;
                int abcde = fghij * N;
                if (fghij < 10000)
                    used = 1;
                temp = abcde;
                while (temp != 0) {
                    used |= 1 << (temp % 10);
                    temp = temp / 10;
                }
                temp = fghij;
                while (temp != 0) {
                    used |= 1 << (temp % 10);
                    temp = temp / 10;
                }

                if (used == (1 << 10) - 1) {
                    have = true;
                    String r = "";
                    if(fghij<10000)
                        r = "0"+fghij;
                    else
                        r = ""+fghij;

                    out.printf("%d / "+r+" = %d\n", abcde, N);
                }
            }
            if (!have)
                out.printf("There are no solutions for %d.\n", N);
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

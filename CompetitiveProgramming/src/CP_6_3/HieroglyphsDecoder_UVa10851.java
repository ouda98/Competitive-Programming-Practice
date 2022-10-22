package CP_6_3;

import java.io.*;
import java.util.StringTokenizer;

public class HieroglyphsDecoder_UVa10851 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        int cases = sc.nextInt();
        while (cases-- > 0) {


            String[] line = sc.nextLine().split("");
            int l = line.length;

            String[][] s = new String[8][l - 2];

            for (int i = 0; i < s.length; i++) {
                line = sc.nextLine().split("");
                for (int j = 1; j < line.length - 1; j++)
                    s[i][j - 1] = line[j];
            }
            sc.nextLine();
            StringBuilder sb;
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < s[0].length; j++) {
                sb = new StringBuilder();
                for (int i = s.length - 1; i >= 0; i--) {
                    if (s[i][j].equals("\\"))
                        sb.append(1);
                    else
                        sb.append(0);
                }

                result.append((char) Integer.parseInt(sb.toString(), 2));
            }
            System.out.println(result);
            sc.nextLine();
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

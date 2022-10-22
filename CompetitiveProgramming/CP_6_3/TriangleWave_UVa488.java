package CP_6_3;

import Template.template;

import java.io.*;
import java.util.StringTokenizer;

public class TriangleWave_UVa488 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        int cases = sc.nextInt();
        while (cases-- > 0) {
            int n = sc.nextInt();
            int rep = sc.nextInt();

            StringBuilder s = new StringBuilder();
            String ss = "";
            StringBuilder a;
            for (int i = 1; i <= n; i++) {
                a = new StringBuilder();
                for (int j = 0; j < i; j++)
                    a.append(i);
                s.append(a);
                s.append("\n");
                if (i < n)
                    ss = a + "\n" + ss;
            }

            for(int i=0;i<rep;i++){
                System.out.print(s);
                if(i+1==rep && cases==0)
                    System.out.print(ss);
                else
                    System.out.println(ss);
            }
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

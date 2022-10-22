package CP_6_3;

import Template.template;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class StrangeIntegration_UVa10906 {
    static HashMap<Character, Pair> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");

        int cases = sc.nextInt();
        int c=1;
        while (cases-- > 0) {
            String[] line;
            int n = sc.nextInt();
            char letter = 'a';
            for (int i = 0; i < n; i++) {
                line = sc.nextLine().split(" ");
                if (!(line[2].charAt(0) >= '0' && line[2].charAt(0) <= '9')) {
                    Pair p = map.get(line[2].charAt(0));
                    if (line[3].charAt(0) == '*' && p.oper!='*')
                        line[2] = "(" + p.exp + ")";
                    else
                        line[2] = p.exp;
                }
                if (!(line[4].charAt(0) >= '0' && line[4].charAt(0) <= '9')) {
                    Pair p = map.get(line[4].charAt(0));
                    if (line[3].charAt(0) == '+' && p.oper!='*' || line[3].charAt(0) == '*')
                        line[4] = "(" + p.exp + ")";
                    else
                        line[4] = p.exp;
                }
                StringBuilder sb = new StringBuilder();
                for (int j = 2; j < line.length; j++) {
                    sb.append(line[j]);
                }
                letter = line[0].charAt(0);
                map.put(letter, new Pair(sb.toString(), line[3].charAt(0)));
            }
            System.out.println("Expression #"+c+++": "+map.get(letter).exp);
        }


        out.flush();
        out.close();
    }

    static class Pair{
        String exp;
        char oper;

        public Pair(String exp, char oper){
            this.exp = exp;
            this.oper = oper;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "exp='" + exp + '\'' +
                    ", oper=" + oper +
                    '}';
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




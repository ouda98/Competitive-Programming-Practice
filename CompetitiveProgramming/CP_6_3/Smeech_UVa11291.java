package CP_6_3;

import Template.template;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Smeech_UVa11291 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        while (sc.ready()) {
            String line = sc.nextLine();
            if (line.equals("()"))
                break;

            System.out.printf("%.2f", evaluate(line));
            System.out.println();

        }


        out.flush();
        out.close();
    }

    private static double evaluate(String line) {
        if (line.charAt(0) != '(')
            return Double.parseDouble(line);

        String[] s = getPEE(line);
        double probability = Double.parseDouble(s[0]);
        double e1 = evaluate(s[1]);
        double e2 = evaluate(s[2]);
        double r = probability*(e1+e2)+(1-probability)*(e1-e2);


        return r;
    }

    private static String[] getPEE(String line) {
        String[] exp = new String[3];
        StringBuilder sb = new StringBuilder();
        int i;
        for (i = 1; i < line.length(); i++) {
            if (line.charAt(i) == ' ')
                break;
            sb.append("" + line.charAt(i));
        }
        i++;
        exp[0] = sb.toString();
        int open = 0;
        int close = 0;
        sb = new StringBuilder();
        if(line.charAt(i)=='(') {
            for (; i < line.length(); i++) {
                sb.append("" + line.charAt(i));
                if (line.charAt(i) == '(')
                    open++;
                if (line.charAt(i) == ')')
                    close++;
                if (open == close) {
                    i++;
                    break;
                }
            }
        }else{
            for(;i<line.length();i++){
                if (line.charAt(i) == ' ')
                    break;
                sb.append("" + line.charAt(i));
            }
        }
        exp[1] = sb.toString();
        i++;

        sb = new StringBuilder();
        open = 0;
        close = 0;
        if(line.charAt(i)=='(') {
            for (; i < line.length(); i++) {
                sb.append("" + line.charAt(i));
                if (line.charAt(i) == '(')
                    open++;
                if (line.charAt(i) == ')')
                    close++;
                if (open == close)
                    break;
            }
        }else{
            for(;i<line.length();i++){
                if (line.charAt(i) == ')')
                    break;
                sb.append("" + line.charAt(i));
            }
        }
        exp[2] = sb.toString();

        return exp;
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




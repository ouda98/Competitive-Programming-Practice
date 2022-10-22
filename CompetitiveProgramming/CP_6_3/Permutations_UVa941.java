package CP_6_3;

import Template.template;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Permutations_UVa941 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        int cases = sc.nextInt();
        while(cases-->0){
            String line = sc.nextLine();
            LinkedList<Character> e = new LinkedList<>();
            for(int i=0;i<line.length();i++)
                e.add(line.charAt(i));
            Collections.sort(e);
            long nth = sc.nextLong();

            StringBuilder sb = new StringBuilder();
            for(int i=0;i<line.length();i++){
                long fact = factorial(line.length()-1-i);
                int r = (int) (nth/fact);
                nth = nth - (fact*r);
                sb.append(e.get(r));
                e.remove(r);
                Collections.sort(e);

            }
            System.out.println(sb);
        }



        out.flush();
        out.close();
    }
    public static long factorial(int n) {
        return (1 > n) ? 1 : n * factorial(n - 1);
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




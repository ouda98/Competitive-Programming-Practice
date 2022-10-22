package CP_3_2_1_IterativeCompleteSearch;

import java.io.*;
import java.util.StringTokenizer;

public class SimpleEquations_UVa11565 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");

        int cases = sc.nextInt();
        while (cases-->0){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            boolean solution = false;
            for(int x = -22;x<=22 && !solution;x++)
                if(x*x<C)
                    for(int y = -100;y<=100 && !solution;y++)
                        if(x!=y && x*x + y*y <C)
                            for(int z = -100;z<=100 && !solution;z++)
                                if(x!=y && x!=z && y!=z && x+y+z == A && x*y*z == B && x*x + y*y + z*z == C) {
                                    int min = Math.min(x,Math.min(y,z));
                                    int max = Math.max(x,Math.max(y,z));
                                    int mid = Math.max(Math.min(x,y), Math.min(Math.max(x,y),z));

                                    System.out.println(min + " " + mid + " " + max);
                                    solution= true;
                                }
            if(!solution)
                System.out.println("No solution.");
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

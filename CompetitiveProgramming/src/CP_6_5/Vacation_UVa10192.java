package CP_6_5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Vacation_UVa10192 {
    static int[][] memo;
    static String first;
    static String second;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        int c =1;
        while (sc.ready()) {
            first = sc.nextLine();
            if(first.equals("#"))
                break;
            second = sc.nextLine();
            int lenOne = first.length();
            int lenTwo = second.length();

            memo = new int[lenOne+1][lenTwo+1];


            for(int i=0;i<= lenOne;i++){
                for(int j=0;j<=lenTwo;j++){
                    if(i==0 || j==0)
                        memo[i][j]= 0;

                    else if(first.charAt(i-1)==second.charAt(j-1))
                        memo[i][j] = memo[i-1][j-1]+1;

                    else{
                        memo[i][j] = Math.max(memo[i][j-1],memo[i-1][j]);
                    }



                }

            }

            System.out.println("Case #"+c+++": you can visit at most "+memo[lenOne][lenTwo]+" cities.");


        }
        out.flush();
        out.close();
    }

    private static int min(int x, int y, int z) {
        if(x<=y && x<=z)
            return x;
        if(y<=x && y<=z)
            return y;
        return z;
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




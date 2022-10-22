package CP_3_2_2_RecursiveCompeleteSearch;

import java.io.*;
import java.util.StringTokenizer;

public class QueensChessProblem_UVa750 {
    static int counter;
    static int [] row = new int[8];
    static int a;
    static int b;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        int cases = sc.nextInt();
        boolean f =false;
        while (cases-->0){
            if (f)
                System.out.println();
            f=true;
            a = sc.nextInt()-1;
            b = sc.nextInt()-1;
            System.out.println("SOLN       COLUMN");
            System.out.println(" #      1 2 3 4 5 6 7 8");
            System.out.println();
            counter=1;
            solve(0);

        }


        out.flush();
        out.close();
    }

    private static void solve(int c) {
        if(c==8 && a==row[b]){
            System.out.print(((counter<10)?" "+counter:counter)+"     ");
            counter++;
            for(int i:row)
                System.out.print(" "+(i+1));
            System.out.println();

        }
        for(int i=0;i<8;i++){
            if(place(i,c)) {
                row[c] = i;
                solve(c + 1);
            }
        }
    }

    private static boolean place(int r, int c) {
        for(int i=0;i<c;i++){
            if(row[i]==r || Math.abs(row[i]-r)== Math.abs(i-c))
                return false;
        }
        return true;
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



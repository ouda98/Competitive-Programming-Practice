package CP_3_2_2_RecursiveCompeleteSearch;

import java.io.*;
import java.util.StringTokenizer;

public class BackToThe8Queens_UVa11085 {
    static int [] row = new int[8];
    static int counter = 0;
    static int [] input = new int [8];
    static int [][] valid = new int[92][8];
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        solve(0);
        int c=1;
        while (sc.ready()){
            for (int i=0;i<8;i++)
                input[i] = sc.nextInt();
            int min =10;
            for(int i=0;i<valid.length;i++){
                int sum =0;
                for(int j=0;j<input.length;j++){
                    if(input[j]!=valid[i][j])
                        sum++;
                }
                min = Math.min(min,sum);
            }
            System.out.println("Case "+c+++": "+min);
        }



        out.flush();
        out.close();
    }

    private static void solve(int idx) {
        if(idx==8) {
            valid[counter++] = row.clone();
            return;
        }

        for(int i=1;i<9;i++){
            if(place(i,idx)){
                row[idx]=i;
                solve(idx+1);
            }
        }

    }

    private static boolean place(int r, int idx) {
        for(int i=0;i<idx;i++){
            if(row[i]==r || Math.abs(r-row[i])==Math.abs(idx-i))
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




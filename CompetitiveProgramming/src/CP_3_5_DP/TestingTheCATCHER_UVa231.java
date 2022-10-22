package CP_3_5_DP;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TestingTheCATCHER_UVa231 {
    static ArrayList<Integer> arr = new ArrayList<>();
    static int[][] memo;
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        int c =1;
        while(sc.ready()){

            arr.clear();
            while(true){

                int in = sc.nextInt();
                if(arr.size()==0 && in == -1)
                    return;
                if(in==-1)
                    break;
                arr.add(in);
            }
            if(c!=1)
                System.out.println();

            memo = new int[arr.size()][32771];
            for(int i=0;i< memo.length;i++)
                Arrays.fill(memo[i],-1);
            System.out.println("Test #"+c+++":");
            System.out.println("  maximum possible interceptions: "+solve(0,32770));

        }

        out.flush();
        out.close();
    }

    private static int solve(int idx, int min) {
        if(idx>=arr.size())
            return 0;

        if(memo[idx][min]!=-1)
            return memo[idx][min];

        int result =0;
        if(min>=arr.get(idx))
            result = 1 + solve(idx+1, arr.get(idx));

        return memo[idx][min] = Math.max(result,solve(idx+1,min));
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




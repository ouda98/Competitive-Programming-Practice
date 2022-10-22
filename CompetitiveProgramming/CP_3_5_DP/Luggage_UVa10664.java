package CP_3_5_DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Luggage_UVa10664 {
    static int[] arr;
    static int[][] memo = new int [21][205];
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        int cases = sc.nextInt();
        while (cases-->0){
            String[] line = sc.nextLine().split(" ");
            arr = new int[line.length];
            int sum =0;
            for(int i=0;i<line.length;i++) {
                arr[i] = Integer.parseInt(line[i]);
                sum+=arr[i];
            }
            for(int i=0;i<memo.length;i++)
                Arrays.fill(memo[i],-1);
            int result = solve(0,sum/2);
            if(sum%2==1 || result==0)
                System.out.println("NO");
            else
                System.out.println("YES");

        }

        out.flush();
        out.close();

    }

    private static int solve(int idx, int left) {
        if(left==0)
            return 1;
        if(idx>= arr.length || left<0)
            return 0;

        if(memo[idx][left]!=-1)
            return memo[idx][left];

        int result = 0;
        if(left>=arr[idx])
            result = solve(idx+1,left-arr[idx]);
        result+= solve(idx+1,left);


        return memo[idx][left] = result;

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




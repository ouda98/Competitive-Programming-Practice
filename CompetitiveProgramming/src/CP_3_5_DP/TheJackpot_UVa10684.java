package CP_3_5_DP;


import java.io.*;
import java.util.StringTokenizer;

public class TheJackpot_UVa10684 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        while(sc.ready()){
            int n = sc.nextInt();
            if(n==0)
                break;
            int [] arr = new int[n];

            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();

            int ans = 0;
            int sum = 0;

            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
                ans = Math.max(ans,sum);
                if (sum<0)
                    sum=0;
            }
            if(ans==0)
                System.out.println("Losing streak.");
            else
                System.out.println("The maximum winning streak is "+ans+".");
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

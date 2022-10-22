package CP_3_2_1_IterativeCompleteSearch;

import java.io.*;
import java.util.StringTokenizer;

public class Lotto_UVa441 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        boolean fe = false;
        while (sc.ready()){
            int n = sc.nextInt();
            if(n==0)
                break;
            if(fe)
                out.println();
            fe = true;
            int [] arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();

            for(int a=0;a<n-5;a++)
                for(int b=a+1;b<n-4;b++)
                    for(int c=b+1;c<n-3;c++)
                        for(int d=c+1;d<n-2;d++)
                            for(int e=d+1;e<n-1;e++)
                                for(int f=e+1;f<n;f++)
                                    out.println(arr[a]+" "+arr[b]+" "+arr[c]+" "+arr[d]+" "+arr[e]+" "+arr[f]);
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




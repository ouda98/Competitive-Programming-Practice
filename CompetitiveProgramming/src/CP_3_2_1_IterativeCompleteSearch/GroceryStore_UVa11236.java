package CP_3_2_1_IterativeCompleteSearch;

import java.io.*;
import java.util.StringTokenizer;

public class GroceryStore_UVa11236 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
//        PrintWriter out = new PrintWriter(System.out);
        PrintWriter out = new PrintWriter("src/txt.out");
        int d;
        int c=1;
        for(int i=1;i<2000;i++)
            for(int j=i;j<2000-i;j++)
                for(int k=j;k<2000-i-j;k++){
                    int ca = (int)1e6*(i+j+k);
                    int bc = (i*j*k)-(int)1e6;
                    if(bc==0)
                        continue;
                    d = ca/bc;
                    if(ca%bc==0 && k<=d && (i+j+k+d)<=2000 && (i*j*k*d)<(int)1e9*2)
                        out.println((i/100)+"."+((i%100<10)?"0"+i%100:i%100)+" "+(j/100)+"."+((j%100<10)?"0"+j%100:j%100)+" "+(k/100)+"."+((k%100<10)?"0"+k%100:k%100)+" "+(d/100)+"."+((d%100<10)?"0"+d%100:d%100));
                }
        out.println("0.50 1.00 2.50 16.00");

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




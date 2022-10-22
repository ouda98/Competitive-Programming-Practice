package CP_3_5_DP;


import java.io.*;
import java.util.StringTokenizer;

public class TakeTheLand_UVa10074 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        while(sc.ready()){
            int r = sc.nextInt();
            int c = sc.nextInt();
            if(r==0 && c==0)
                break;
            int [][] arr = new int[r][c];

            for(int i=0;i<r;i++)
                for(int j=0;j<c;j++){
                    arr[i][j] = sc.nextInt();
                    if(i>0) arr[i][j] += arr[i-1][j];
                    if(j>0) arr[i][j] += arr[i][j-1];
                    if(i>0 && j>0) arr[i][j] -= arr[i-1][j-1];
                }

            int min = 0;
            int subSum;
            for(int i=0;i<r;i++)
                for(int j=0;j<c;j++)
                    for(int k=i;k<r;k++)
                        for(int l=j;l<c;l++){
                            subSum = arr[k][l];
                            if(i>0) subSum-= arr[i-1][l];
                            if(j>0) subSum-= arr[k][j-1];
                            if(i>0 && j>0) subSum+=arr[i-1][j-1];

                            if(subSum==0){
//                                System.out.println("here"+(k-i+1)*(l-j+1));
                                min = Math.max(min,(k-i+1)*(l-j+1));
                            }
                        }
            System.out.println(min);

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


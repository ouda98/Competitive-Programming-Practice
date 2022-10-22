package CP_3_2_1_IterativeCompleteSearch;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ThePathInTheColoredField_UVa10102 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        while(sc.ready()){
            int m = sc.nextInt();
            int [][] field = new int[m][m];
            ArrayList<Pair> ones = new ArrayList<>();
            for(int i=0;i<m;i++){
                String s = sc.nextLine();
                for(int j=0;j<m;j++){
                    field[i][j] = Integer.parseInt(s.charAt(j)+"");
                    if(field[i][j]==1)
                        ones.add(new Pair(i,j));
                }
            }
            int max =0;
            for(Pair one : ones){
                int x = one.x;
                int y = one.y;
                int min = (int)1e9;
                for(int u = x;u>=0;u--)
                    for(int l = y;l>=0;l--){
                        int i = Math.abs(x - u) + Math.abs(y - l);
                        if(field[u][l]==3 && i <min)
                            min = i;
                    }

                for(int u = x;u>=0;u--)
                    for(int r=y;r<m;r++){
                        int i = Math.abs(x - u) + Math.abs(y - r);
                        if(field[u][r]==3 && i <min)
                            min = i;
                    }

                for(int d =x;d<m;d++)
                    for(int l = y;l>=0;l--){
                        int i = Math.abs(x - d) + Math.abs(y - l);
                        if(field[d][l]==3 && i <min)
                            min = i;
                    }

                for(int d =x;d<m;d++)
                    for(int r=y;r<m;r++){
                        int i = Math.abs(x - d) + Math.abs(y - r);
                        if(field[d][r]==3 && i <min)
                            min = i;
                    }

                max = Math.max(max,min);

            }
            System.out.println(max);

        }



        out.flush();
        out.close();
    }

    public static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
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




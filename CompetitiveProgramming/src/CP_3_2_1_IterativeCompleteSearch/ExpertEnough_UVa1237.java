package CP_3_2_1_IterativeCompleteSearch;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ExpertEnough_UVa1237 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        int cases = sc.nextInt();
        boolean f = false;
        while(cases-->0){
            if(f)
                System.out.println();
            f = true;
            int dbSize = sc.nextInt();
            ArrayList<Triple> db = new ArrayList<>();
            for(int i=0;i<dbSize;i++)
                db.add(new Triple(sc.next(),sc.nextInt(),sc.nextInt()));

            int queries = sc.nextInt();
            for(int i=0;i<queries;i++){
                int number = sc.nextInt();
                int counter =0;
                String res = "";

                for(int j=0;j<db.size();j++){
                    Triple cur = db.get(j);
                    if(number>=cur.low && number<=cur.high) {
                        res += cur.maker;
                        counter++;
                    }
                }
                if(counter==1){
                    System.out.println(res);
                }else
                    System.out.println("UNDETERMINED");
            }


        }


        out.flush();
        out.close();
    }

    public static class Triple{
        String maker;
        int low;
        int high;
        public Triple( String maker, int low, int high){
            this.maker = maker;
            this.low = low;
            this.high = high;
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




package CP_3_2_1_IterativeCompleteSearch;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FractionsAgain_UVa10976 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        while(sc.ready()){
            int number = sc.nextInt();
            ArrayList<String> result = new ArrayList<>();
            for(int i=number+1;i<=number*2;i++){
                int numerator = i - number;
                int denominator = number * i;
                if(denominator%numerator==0)
                    result.add("1/"+number +" = "+ "1/"+(denominator/numerator)+" + 1/"+i);


            }
            System.out.println(result.size());
            for(String s: result){
                System.out.println(s);
            }
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




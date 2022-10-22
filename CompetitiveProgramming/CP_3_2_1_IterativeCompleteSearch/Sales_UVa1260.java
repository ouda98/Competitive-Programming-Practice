package CP_3_2_1_IterativeCompleteSearch;


import java.io.*;
import java.util.StringTokenizer;

public class Sales_UVa1260 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int cases = sc.nextInt();
        while (cases-->0){
            int size = sc.nextInt();
            int [] array = new int[size];
            for(int i=0;i<size;i++)
                array[i] = sc.nextInt();

            int sum = 0;
            for(int i=1;i<size;i++){
                int number = array[i];
                for(int j=0;j<i;j++){
                    if(number>=array[j])
                        sum++;
                }
            }
            System.out.println(sum);

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



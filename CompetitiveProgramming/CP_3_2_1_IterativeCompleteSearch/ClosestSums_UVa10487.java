package CP_3_2_1_IterativeCompleteSearch;

import java.io.*;
import java.util.StringTokenizer;

public class ClosestSums_UVa10487 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        int c =1;
        while (sc.ready()){
            int n = sc.nextInt();
            if(n==0)
                break;
            int[] arr = new int[n];
            for(int i=0;i<arr.length;i++)
                arr[i] = sc.nextInt();

            int q = sc.nextInt();
            int max;
            System.out.println("Case "+c+++":");
            for(int i=0;i<q;i++){
                int number = sc.nextInt();
                max = (int)1e9;
                for(int j=0;j<arr.length;j++){
                    for(int k=j+1;k<arr.length;k++){
                        if(Math.abs(number - max)> Math.abs(number-(arr[k]+arr[j])))
                            max = arr[k]+arr[j];

                    }

                }
                System.out.println("Closest sum to "+number+" is "+max+".");
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




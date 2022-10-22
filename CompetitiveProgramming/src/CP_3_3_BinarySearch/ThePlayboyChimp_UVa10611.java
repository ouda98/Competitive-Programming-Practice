package CP_3_3_BinarySearch;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ThePlayboyChimp_UVa10611 {
    static ArrayList<Long> girls;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int girlsCount = sc.nextInt();
        girls = new ArrayList<>();
        long lastNumber = -1;
        for (int i = 0; i < girlsCount; i++) {
            long next = sc.nextInt();
            if(next!=lastNumber)
                girls.add(next);
            lastNumber = next;
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            long query = sc.nextLong();
            int c = binarySearch(0, girls.size() - 1, query);

            if (girls.get(c) == query) {
                if (c > 0)
                    System.out.print(girls.get(c-1));
                else
                    System.out.print("X");
                if (c < girls.size() - 1)
                    System.out.println(" " + girls.get(c+1));
                else
                    System.out.println(" X");
            } else {
                if(girls.get(c)>query){
                    if(c>0)
                        System.out.print(girls.get(c-1));
                    else
                        System.out.print("X");
                    System.out.println(" "+girls.get(c));

                }else{
                    System.out.println(girls.get(c)+" X");
                }
                }




        }


        out.flush();
        out.close();
    }

    private static int binarySearch(int l, int r, long query) {
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (girls.get(mid) == query) {
                return mid;
            }
            if (l == r)
                return mid;
            if (girls.get(mid) < query)
                return binarySearch(mid + 1, r, query);

            else
                return binarySearch(l, mid, query);
        }
        return -1;
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



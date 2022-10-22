package CP_6_5;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PrinceAndPrincess_UVa10635TLE {
    static HashMap<String, Integer> memo;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        int c = 1;
        int cases = sc.nextInt();
        while (cases-- > 0) {
            sc.nextLine();
            String[] first = sc.nextLine().split(" ");
            String[] second = sc.nextLine().split(" ");

            int m = first.length;
            int n = second.length;
            memo = new HashMap<>();

            for (int i = 0; i <= first.length; i++) {
                for (int j = 0; j <= second.length; j++) {

                    if (i == 0 || j == 0)
                        memo.put(i + "" + j, 0);

                    else if (first[i - 1].equals(second[j - 1]))
                        memo.put(i + "" + j, memo.get((i-1)+""+(j-1)));

                    else
                        memo.put(i+""+j,Math.max(memo.get((i-1)+""+j), memo.get(i+""+(j-1))));
                }
            }
            System.out.println("Case " + c++ + ": " + memo.get(m+""+n));
        }

        out.flush();
        out.close();
    }

    private static int min(int x, int y, int z) {
        if (x <= y && x <= z)
            return x;
        if (y <= x && y <= z)
            return y;
        return z;
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




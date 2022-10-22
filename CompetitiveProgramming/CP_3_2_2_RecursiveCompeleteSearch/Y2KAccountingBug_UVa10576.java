package CP_3_2_2_RecursiveCompeleteSearch;


import java.io.*;
import java.util.StringTokenizer;

public class Y2KAccountingBug_UVa10576 {
    static int s;
    static int d;
    static int months = 12;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        while (sc.ready()){
            s = sc.nextInt();
            d = sc.nextInt();
            ;
            if(!solve(0,new int[12]))
                System.out.println("Deficit");
        }


        out.flush();
        out.close();
    }

    private static boolean solve(int idx, int[] m) {
            boolean f = true;
            int e = 0;
            if (idx >= 5) {
                int sum = 0;
                for (int i = 4; i < idx; i++) {
                    sum = 0;
                    for (int j = i - 4; j <= i; j++) {
                        sum += m[j];
                    }
                    if (sum > 0) {
                        return false;
                    }
                    if (i == 4)
                        e = sum;
                    else {
                        if (sum != e)
                            return false;
                    }

                }
            }
            if (idx == months) {
                int s = 0;
                for (int i = 0; i < m.length; i++)
                    s += m[i];
                if (s > 0) {
                    System.out.println(s);
                    return true;
                }
                return false;

            }


            m[idx] = s;
            if(solve(idx + 1, m))
                return true;
            m[idx] = -d;
            if (solve(idx + 1, m))
                return true;
        return false;
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




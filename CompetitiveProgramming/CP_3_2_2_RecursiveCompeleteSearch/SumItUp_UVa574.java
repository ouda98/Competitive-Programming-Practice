package CP_3_2_2_RecursiveCompeleteSearch;


import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SumItUp_UVa574 {
    static int target;
    static int[] list;
    static int n;
    static HashSet<String> set;
    static boolean f;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        while (sc.ready()) {
            f = false;
            set = new HashSet<>();
            target = sc.nextInt();
            n = sc.nextInt();
            if (target == 0 && n == 0)
                break;
            list = new int[n];
            for (int i = 0; i < n; i++)
                list[i] = sc.nextInt();
            System.out.println("Sums of "+target+":");
            solve(0, 0, "");
            if(!f)
                System.out.println("NONE");
        }


        out.flush();
        out.close();
    }

    private static void solve(int idx, int sum, String s) {
        if (idx == n) {
            if (sum == target)
                if (!set.contains(s.substring(1))) {
                    f=true;
                    System.out.println(s.substring(1));
                    set.add(s.substring(1));
                }

            return;
        }

        solve(idx + 1, sum + list[idx], s + "+" + list[idx]);
        solve(idx + 1, sum, s);


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




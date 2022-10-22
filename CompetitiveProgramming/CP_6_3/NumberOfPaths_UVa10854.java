package CP_6_3;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberOfPaths_UVa10854 {
    static ArrayList<String> arr;
    static long[] memo;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        int cases = sc.nextInt();
        while (cases-- > 0) {
            arr = new ArrayList<>();
            while (true) {
                arr.add(sc.nextLine());
                if (arr.get(arr.size() - 1).equals("ENDPROGRAM"))
                    break;
            }
            memo = new long[arr.size()];
            Arrays.fill(memo, -1);
            System.out.println(findPaths(0));

        }


        out.flush();
        out.close();
    }

    private static long findPaths(int idx) {
        if (idx == arr.size())
            return 1;
        long result = 0;
        if (memo[idx] != -1)
            return memo[idx];
        if (arr.get(idx).equals("IF")) {
            int i = findIndex(idx + 1);
            result += findPaths(idx + 1) + findPaths(i);
        } else if (arr.get(idx).equals("ELSE")) {
            int i = findI(idx);
            result += findPaths(i);
        } else
            result += findPaths(idx + 1);
//        System.out.println(result);

        return memo[idx] = result;
    }

    private static int findI(int idx) {
        int ifs = 0;
        int elses = 0;
        for (int i = idx; i < arr.size(); i++) {
            if (arr.get(i).equals("IF"))
                ifs++;
            if (arr.get(i).equals("END_IF"))
                elses++;
            if (elses - 1 == ifs)
                return i + 1;

        }
        return arr.size();
    }

    private static int findIndex(int idx) {
        int ifs = 0;
        int elses = 0;
        for (int i = idx; i < arr.size(); i++) {
            if (arr.get(i).equals("IF"))
                ifs++;
            if (arr.get(i).equals("ELSE"))
                elses++;
            if (elses - 1 == ifs)
                return i + 1;

        }
        return arr.size();
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

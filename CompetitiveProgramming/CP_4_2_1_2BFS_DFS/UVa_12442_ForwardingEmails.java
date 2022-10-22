package CP_4_2_1_2BFS_DFS;

import java.io.*;
import java.util.StringTokenizer;

public class UVa_12442_ForwardingEmails {

    static int a[] = new int[50001];
    static int sum[] = new int[50001];
    static boolean vis[] = new boolean[500001];

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner("src/CP4_2_1_2/txt.in");
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt(), cases = 1;

        while(t-- > 0) {
            int n = sc.nextInt();

            for(int i = 1; i <= n; i++) {
                a[sc.nextInt()] = sc.nextInt();
                sum[i] = -1;
            }

            int max = 0; int res = 100000;
            for(int i = 1; i <= n; i++) {
                if(sum[i] == -1) dfs(i);
                if(sum[i] > max) {
                    max = sum[i]; res = i;
                }
            }

            out.printf("Case %d: %d\n", cases++, res);
        }

        out.flush();
        out.close();
    }

    public static int dfs(int i) {
        vis[i] = true;
        int res = 1;
        int next = a[i];

        if(!vis[next])
            res += dfs(next);

        vis[i] = false;

        return sum[i] = res;
    }

    static class Pair implements Comparable<Pair>{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair p) {
            if(Integer.compare(this.x, p.x) == 0)
                return Integer.compare(this.y, p.y);
            return Integer.compare(this.x, p.x);
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

package CP_3_5_DP;

import java.io.*;
import java.util.*;

public class FlightPlanner_UVa10337 {
    static int arr[][];
    static int memo[][];
    static int[] dr = {1, 0, -1};
    static int[] dc = {1, 1, 1};
    static int miles;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        int cases = sc.nextInt();
        while (cases-- > 0) {



            miles = sc.nextInt() / 100;
            arr = new int[10][miles];
            memo = new int[10][miles];

            for (int i = 0; i < arr.length; i++)
                for (int j = 0; j < arr[i].length; j++)
                    arr[i][j] = sc.nextInt();

            for (int i = 0; i < memo.length; i++)
                Arrays.fill(memo[i], (int) 1e9);

            memo[9][0] = 0;

            PriorityQueue<Triple> q = new PriorityQueue<>();

            q.add(new Triple(0, 9, 0));

            while (!q.isEmpty()) {
                Triple top = q.poll();
                int x;
                int y;
                for (int i = 0; i < dr.length; i++) {
                    x = top.x + dr[i];
                    y = top.y + dc[i];
                    if (can(x, y)) {
                        int s = memo[top.x][top.y] - arr[top.x][top.y];
                        if (i == 0)
                            s += 20;
                        if (i == 1)
                            s += 30;
                        if (i == 2)
                            s += 60;
                        if (memo[x][y] > s) {
                            memo[x][y] = s;
                            q.add(new Triple(s, x, y));
                        }
                    }
                }

            }
            int sum = memo[8][miles-1] + 20 - arr[8][miles-1];
            int sum2 = memo[9][miles-1] + 30 - arr[9][miles-1];

            System.out.println(Math.min(sum,sum2));
            System.out.println();

//            for(int i=0;i<memo.length;i++)
//                System.out.println(Arrays.toString(memo[i]));
        }

        out.flush();
        out.close();
    }

    private static boolean can(int x, int y) {
        return x >= 0 && y >= 0 && x <= 9 && y < miles;
    }

    static class Triple implements Comparable<Triple> {
        int value;
        int x;
        int y;

        public Triple(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return x + " " + y + " " + value;
        }

        @Override
        public int compareTo(Triple o) {
            if (this.value == o.value)
                if (this.y == o.y)
                    return o.x - this.x;
                else
                    return this.y - o.y;
            return this.value - o.value;
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



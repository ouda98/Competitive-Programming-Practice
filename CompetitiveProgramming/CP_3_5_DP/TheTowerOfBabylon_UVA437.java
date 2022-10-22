package CP_3_5_DP;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TheTowerOfBabylon_UVA437 {
    static Block[] blocks;
    static int []memo;
    static int N;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        int c = 1;
        while (sc.ready()) {
            int n = sc.nextInt();
            if (n == 0)
                break;
            blocks = new Block[100];

            int x, y, z, a, b;
            int k = 0;
            for (int i = 0; i < n; i++) {
                    x = sc.nextInt();
                    y = sc.nextInt();
                    z = sc.nextInt();
                    a = (y > z) ? y : z;
                    b = (y > z) ? z : y;
                    blocks[k++] = new Block(a, b, x);
                    a = (x > z) ? x : z;
                    b = (x > z) ? z : x;
                    blocks[k++] = new Block(a, b, y);
                    a = (x > y) ? x : y;
                    b = (x > y) ? y : x;
                    blocks[k++] = new Block(a, b, z);
            }
            memo = new int[k];
            Arrays.sort(blocks,0,k);
            int max = 0;

            memo[0] = blocks[0].h;

            for (int i = 1; i < k; i++) {
                for (int j = 0; j < i; j++) {
                    if (blocks[i].y > blocks[j].y && blocks[i].x > blocks[j].x) {
                        memo[i] = Math.max(memo[i], memo[j] + blocks[i].h);
                    }
                }
                if(memo[i]==0)
                    memo[i]= blocks[i].h;
                max = Math.max(max, memo[i]);
            }

            System.out.println("Case "+c+++": maximum height = "+max);


        }

        out.flush();
        out.close();
    }



    private static int[] optimize(int idx, int l, int w) {
        int x = blocks[idx].x;
        int y = blocks[idx].y;
        if (blocks[idx].y < l && blocks[idx].x < w && (l - y) <= (l - x) && (w - y) <= (w - x))
            return new int[]{y, x};

        return new int[]{x, y};
    }

    static class Block implements Comparable<Block> {
        int x;
        int y;
        int h;

        public Block(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }

        public String toString() {
            return x + " " + y + " " + h;
        }

        @Override
        public int compareTo(Block o) {
            if (this.x == o.x)
                return o.y - this.y;
            return this.x - o.x;
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




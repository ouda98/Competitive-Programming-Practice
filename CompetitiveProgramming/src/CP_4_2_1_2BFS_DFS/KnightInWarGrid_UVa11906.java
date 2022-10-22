package CP_4_2_1_2BFS_DFS;

import java.io.*;
import java.util.*;

public class KnightInWarGrid_UVa11906 {
    static HashSet<String>[][] count;
    static boolean[][] visited;
    static HashSet<String> water = new HashSet<>();
    static int m;
    static int n;
    static int r;
    static int c;
    static Pair[] moves;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/CP4_2_1_2/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        moves = new Pair[4];
        moves[0] = new Pair(1, 1);
        moves[1] = new Pair(1, -1);
        moves[2] = new Pair(-1, 1);
        moves[3] = new Pair(-1, -1);
        count = new HashSet[101][101];
        visited = new boolean[101][101];
        for(int j=0;j<101;j++)
            for(int k=0;k<101;k++)
                count[j][k] = new HashSet<>();

        int cases = sc.nextInt();
        for (int i = 0; i < cases; i++) {
            r = sc.nextInt();
            c = sc.nextInt();
            m = sc.nextInt();
            n = sc.nextInt();
            int even = 0;
            int odd = 0;



            for(int j=0;j<101;j++)
                for(int k=0;k<101;k++){
                    count[j][k].clear();
                    Arrays.fill(visited[j],false);
                }


            int waterSpots = sc.nextInt();
            water.clear();
            for (int j = 0; j < waterSpots; j++) {
                int xWater = sc.nextInt();
                int yWater = sc.nextInt();
                water.add(xWater+","+yWater);
            }

            dfs(0, 0);

            for (int j = 0; j < count.length; j++) {
                for (int k = 0; k < count[j].length; k++) {
                    if (count[j][k].size() >= 0 && visited[j][k]) {
                        if (count[j][k].size() % 2 == 0)
                            even++;
                        else
                            odd++;
                    }

                }

            }
            System.out.println("Case " + (i + 1) + ": " + even + " " + odd);


        }
        out.flush();
        out.close();
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        int newX;
        int newY;
        for (int i = 0; i < moves.length; i++) {
            newX = x + (n * moves[i].x);
            newY = y + (m * moves[i].y);
//            System.out.println(newX+" "+newY);
//            System.out.println(water.contains(newX+","+newY));

            if (newX < r && newY < c && newX >= 0 && newY >= 0 && !water.contains(newX+","+newY)) {
                count[x][y].add(newX+","+newY);
                if (!visited[newX][newY]) {
                    dfs(newX, newY);
                }
            }
        }
            for (int i = 0; i < moves.length; i++) {
                newX = x + (m * moves[i].x);
                newY = y + (n * moves[i].y);

                if (newX < r && newY < c && newX >= 0 && newY >= 0 && !water.contains(newX+","+newY)) {
                    count[x][y].add(newX+","+newY);
                    if (!visited[newX][newY]) {
                        dfs(newX, newY);
                    }
                }
            }
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getRow() {
            return x;
        }

        public void setRow(int x) {
            this.x = x;
        }

        public int getValue() {
            return y;
        }

        public void setValue(int y) {
            this.y = y;
        }

        public String toString() {
            return "row " + this.x + " value " + this.y;
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


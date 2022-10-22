package CP_4_2_3_4_CC_FloodFill;

import java.io.*;
import java.util.StringTokenizer;

public class Battleships_UVa11953 {
    static char[][] grid;
    static boolean[][] visited;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/CP4_2_3_4/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String line;
        int cases = sc.nextInt();
        for(int k=0;k<cases;k++){
            int dimension = sc.nextInt();
            grid = new char[dimension][dimension];
            visited = new boolean[dimension][dimension];
            for(int i=0;i<dimension;i++){
                line = sc.nextLine();
                for(int j=0;j<line.length();j++)
                    grid[i][j] = line.charAt(j);
            }
            count =0;
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid.length;j++){
                    if(grid[i][j]=='x' && !visited[i][j]){
                        count++;
                        dfs(i,j);
                    }
                }
            }
            System.out.println("Case "+(k+1)+": "+count);

        }
        out.flush();
        out.close();
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        int newX;
        int newY;
        for (int i = 0; i < dc.length; i++) {
            newX = x + dr[i];
            newY = y + dc[i];

            if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid.length && !visited[newX][newY] && grid[newX][newY]!='.'){
                dfs(newX,newY);
            }

        }
    }


    static class Pair implements Comparable<Pair> {
        int x;
        char y;

        public Pair(char y, int x) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair p) {
            if (Integer.compare(p.x, this.x) == 0)
                return Character.compare(this.y, p.y);
            return Integer.compare(p.x, this.x);
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




package CP_4_2_3_4_CC_FloodFill;

import java.io.*;
import java.util.*;

public class RankTheLanguages_UVa10336 {
    static char[][] grid;
    static boolean[][] visited;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int maxCount = 0;
    static int c = 0;
    static TreeSet<Pair> statesCount;
    static TreeMap<Character,Integer> map;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/CP4_2_3_4/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int cases = sc.nextInt();
        for (int k = 0; k < cases; k++) {
            int rows = sc.nextInt();
            int columns = sc.nextInt();
            grid = new char[rows][columns];
            visited = new boolean[rows][columns];
            statesCount = new TreeSet<>();
            map = new TreeMap<>();
            for(int i=0;i<rows;i++){
                String line = sc.nextLine();
                for(int j=0;j<columns;j++){
                    grid[i][j]= line.charAt(j);
                }
            }

            for(int i=0;i<rows;i++){
                for(int j=0;j<columns;j++){
                    if(!visited[i][j]){
                        char a = grid[i][j];
                        dfs(i,j,a);
                        if(map.containsKey(a)){
                            int c= map.get(a);
                            map.put(a,c+1);
                            statesCount.remove(new Pair(a,c));
                            statesCount.add(new Pair(a,c+1));
                        }else{
                            map.put(a,1);
                            statesCount.add(new Pair(a,1));
                        }
                    }

                }
            }
            System.out.println("World #"+(k+1));
            for(Pair s: statesCount){
                System.out.println(s.y+": "+s.x);
            }

        }
        out.flush();
        out.close();
    }

    private static void dfs(int x, int y,char c) {
        visited[x][y] = true;
        int newX;
        int newY;
        for (int i = 0; i < dr.length; i++) {
            newX = x + dr[i];
            newY = y + dc[i];
            if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length && grid[newX][newY] == c && !visited[newX][newY]) {
                dfs(newX, newY,c);
            }
        }


    }
    static class Pair implements Comparable<Pair>{
        int x;
        char y;

        public Pair(char y, int x) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair p) {
            if(Integer.compare(p.x, this.x) == 0)
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



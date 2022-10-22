package CP_4_2_3_4_CC_FloodFill;

import java.io.*;
import java.util.*;

public class TheDieIsCast_UVa00657 {
    static char[][] grid;
    static boolean[][] visited;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int rows;
    static int columns;
    static int count;
    static ArrayList<Pair> imp = new ArrayList<>();
    static ArrayList<Pair> unImp = new ArrayList<>();;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/CP4_2_3_4/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        ArrayList<Integer> result;
        int c =0;
        while (sc.ready()) {
            columns = sc.nextInt();
            rows = sc.nextInt();
            result = new ArrayList<>();
            grid = new char[rows][columns];
            visited = new boolean[rows][columns];
            if (rows == 0 && columns == 0)
                break;
            for (int i = 0; i < rows; i++) {
                String line = sc.nextLine();
                for (int j = 0; j < line.length(); j++)
                    grid[i][j] = line.charAt(j);
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    count = 1;
                    imp.clear();
                    unImp.clear();
                    if (grid[i][j] == 'X' && !visited[i][j]) {
                        dfs(i, j,false);
                        result.add(count);
                    }
                }
            }
            Collections.sort(result);
            c++;
            System.out.println("Throw "+c);
            StringBuilder sb = new StringBuilder();
            for(Integer s: result){
                sb.append(s+" ");
            }
            System.out.println(sb.substring(0,sb.length()-1));
            System.out.println();
        }
        out.flush();
        out.close();
    }

    private static void dfs(int x, int y,boolean flag) {
//        System.out.println(grid[x][y]+" here "+x+" "+y+"  count "+count);
        visited[x][y] = true;
        int newX=0;
        int newY=0;
        for (int i = 0; i < dr.length; i++) {

            newX = x + dr[i];
            newY = y + dc[i];


            if (newX >= 0 && newY >= 0 && newX < rows && newY < columns && grid[newX][newY] != '.') {
                if (grid[newX][newY] == 'X' && !visited[newX][newY])
                    imp.add(new Pair(newX, newY));
                else if (grid[newX][newY] == '*' && !visited[newX][newY])
                    unImp.add(new Pair(newX, newY));
            }
        }
        for(int i=0;i<imp.size();i++){
            newX = imp.get(i).x;
            newY = imp.get(i).y;
            if(flag && grid[x][y]!='X' && !visited[newX][newY]) {
                count++;
                flag=false;
            }
            if(!visited[newX][newY]){
                dfs(newX,newY,false);
            }


        }
        for(int i=0;i<unImp.size();i++){
            newX = unImp.get(i).x;
            newY = unImp.get(i).y;
            if(!visited[newX][newY]){
                dfs(newX,newY,true);
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
            return "to " + this.x + " time " + this.y;
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


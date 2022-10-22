package CP_4_2_1_2BFS_DFS;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class StickerCollectorRobots_UVa11831 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/CP4_2_1_2/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        HashMap<Character, Pair> transitions = new HashMap<>();
        transitions.put('N', new Pair(0, -1));
        transitions.put('S', new Pair(0, 1));
        transitions.put('L', new Pair(1, 0));
        transitions.put('O', new Pair(-1, 0));
        HashMap<String,Character> directions = new HashMap<>();
        directions.put("ND",'L');
        directions.put("NE",'O');
        directions.put("SD",'O');
        directions.put("SE",'L');
        directions.put("OD",'N');
        directions.put("OE",'S');
        directions.put("LD",'S');
        directions.put("LE",'N');
        while (sc.ready()) {
            String[] input = sc.nextLine().split(" ");
            int rows = Integer.parseInt(input[0]);
            if (rows == 0) break;
            int columns = Integer.parseInt(input[1]);
            int InstructionsCount = Integer.parseInt(input[2]);
            char[][] grid = new char[rows][columns];
            int x = 0;
            int y = 0;
            char direction='a';
            for (int i = 0; i < rows; i++) {
                char[] line = sc.nextLine().toCharArray();
                for (int j = 0; j < line.length; j++) {
                    grid[i][j] = line[j];
                    if (!(line[j] == '.' || line[j] == '#' || line[j] == '*')) {
                        direction = line[j];
                        x = i;
                        y = j;
                    }
                }
            }
            String[] instructions = sc.nextLine().split("");
            int counter =0;
            int newX = 0;
            int newY = 0;
            for(String i:instructions){
//                System.out.println(x+" "+y+" "+direction+" "+counter);
                if(i.equals("F")){
//                    System.out.println(direction);
                    newX=x+ transitions.get(direction).y;
                    newY=y+ transitions.get(direction).x;
//                    System.out.println(newX+"  new  "+newY);
                    if (newX < rows && newY < columns && newX >= 0 && newY >= 0 && grid[newX][newY]!='#') {
//                        System.out.println("here");
                        x = newX;
                        y = newY;
                        if(grid[x][y]=='*'){
                            grid[x][y]='.';
                            counter++;
                        }

                    }
                }else{
//                    System.out.println(direction+""+i);
                    direction = directions.get(direction+""+i);
                }
            }
            System.out.println(counter);


        }
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
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

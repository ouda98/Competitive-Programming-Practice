package CP_4_2_1_2BFS_DFS;

import java.io.*;
import java.util.*;

public class RobotMotion_UVa10116 {
    static LinkedList<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/CP4_2_1_2/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        HashMap<Character, Pair> transitions = new HashMap<>();
        transitions.put('N', new Pair(0, -1));
        transitions.put('S', new Pair(0, 1));
        transitions.put('E', new Pair(1, 0));
        transitions.put('W', new Pair(-1, 0));
        while (sc.ready()) {
            String[] input = sc.nextLine().split(" ");
            int rows = Integer.parseInt(input[0]);
            if(rows==0)break;
            int columns = Integer.parseInt(input[1]);
            int x= Integer.parseInt(input[2]) - 1;
            int y = 0;
            int counter = 0;
            char[][] directions = new char[rows][columns];
            HashMap<String, Integer> visited = new HashMap<>();

            for (int i = 0; i < rows; i++) {
                String line = sc.nextLine();
                for (int j = 0; j < line.length(); j++) {
                    directions[i][j] = line.charAt(j);
                }
            }
            int newX = 0;
            int newY = 0;
            boolean loop = false;
            visited.put(x + "" + y, counter++);
            int loopExit = 0;
            while (true) {
                newX = x + transitions.get(directions[y][x]).x;
                newY = y + transitions.get(directions[y][x]).y;
                if (newX < columns && newY < rows && newX >= 0 && newY >= 0) {
                    x = newX;
                    y = newY;
                    if(visited.containsKey(newX+""+newY)){
                        loop = true;
                        loopExit = visited.get(newX+""+newY);
                        break;
                    }
                    visited.put(x + "" + y, counter++);
                } else {
                    break;
                }
            }
            if(!loop){
                out.println(counter+" step(s) to exit");
            }else{
                out.println(loopExit+" step(s) before a loop of "+ ((int)counter-loopExit)+" step(s)");
            }


        }


        out.flush();
        out.close();


    }
    static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
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
        public String toString(){
            return "row "+ this.x + " value "+ this.y;
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

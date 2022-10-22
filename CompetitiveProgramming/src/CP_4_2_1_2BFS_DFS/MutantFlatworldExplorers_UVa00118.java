package CP_4_2_1_2BFS_DFS;
import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class MutantFlatworldExplorers_UVa00118 {
    static LinkedList<Integer>[] adjList;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/CP4_2_1_2/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        HashMap<Character,Pair> transitions = new HashMap<>();
        transitions.put('N',new Pair(0,1));
        transitions.put('S',new Pair(0,-1));
        transitions.put('E',new Pair(1,0));
        transitions.put('W',new Pair(-1,0));
        HashMap<String,Character> directions = new HashMap<>();
        directions.put("NR",'E');
        directions.put("NL",'W');
        directions.put("SR",'W');
        directions.put("SL",'E');
        directions.put("WR",'N');
        directions.put("WL",'S');
        directions.put("ER",'S');
        directions.put("EL",'N');
        HashSet<String> lost = new HashSet<>();
        while (sc.ready()) {
            String[] input = sc.nextLine().split(" ");
            int rows = Integer.parseInt(input[1])+1;
            int columns = Integer.parseInt(input[0])+1;
            while (sc.ready()) {
                input = sc.nextLine().split(" ");
                int xPos = Integer.parseInt(input[0]);
                int yPos = Integer.parseInt(input[1]);
                char direction = input[2].charAt(0);
                String[] steps = sc.nextLine().split("");
                StringBuilder sb = new StringBuilder();
                for(String i:steps){

//                    System.out.println(xPos+" "+direction+" "+ rows);
//                    System.out.println(yPos+" "+direction+" "+ columns);
                    if(i.equals("F")){
                        int newX = xPos+transitions.get(direction).x;
                        int newY = yPos+transitions.get(direction).y;
//                        System.out.println("new"+ newX+" "+newY);
                        if(newX<columns && newY<rows && newX >=0 && newY>=0){
                            xPos = xPos+transitions.get(direction).x;
                            yPos = yPos+transitions.get(direction).y;
                        }else if(lost.contains(xPos+""+yPos)) {
                            continue;
                        }else{
                            lost.add(xPos+""+yPos);
                            sb.append(" LOST");
                            break;
                        }

                    }else{
                        direction = directions.get(direction+i);
                    }
                }
                out.println(xPos+" "+yPos+" "+direction+sb.toString());
            }

            out.flush();
            out.close();
        }

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

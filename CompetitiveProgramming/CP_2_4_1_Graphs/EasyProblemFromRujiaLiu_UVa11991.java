package CP_2_4_1_Graphs;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class EasyProblemFromRujiaLiu_UVa11991 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/CP2_4_1/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        while(sc.ready()){
            String[] input = sc.nextLine().split(" ");
            int len = Integer.parseInt(input[0]);
            int queries = Integer.parseInt(input[1]);
            ArrayList<Integer> adjList[] = new ArrayList[1000000];
            String[] numbers = sc.nextLine().split(" ");
            for(int i=0;i<numbers.length;i++){
                int row = Integer.parseInt(numbers[i]);
//                System.out.println(row);
                if(adjList[row]==null){
                    adjList[row] = new ArrayList<Integer>();
                    adjList[row].add(i+1);

                }else
                    adjList[row].add(i+1);
            }
//            for(int i=0;i<adjList.length;i++) {
//                System.out.println(adjList[i]);
//            }
            for(int i=0;i<queries;i++){
                input = sc.nextLine().split(" ");
                int occ = Integer.parseInt(input[0]);
                int value = Integer.parseInt(input[1]);
                if(adjList[value].size()>=occ){
                    out.println(adjList[value].get(occ-1));
                }else
                    out.println(0);
            }



        }
        out.flush();
        out.close();
    }

    private static int[] toInegerPos(String[] positions) {
        int [] pos = new int [positions.length-1];
        for(int i=1;i< positions.length;i++){
            pos[i-1] = Integer.parseInt(positions[i]);
        }
        return pos;
    }
    private static int[] toInegerVal(String[] values) {
        int [] val = new int [values.length];
        for(int i=0;i< values.length;i++){
            val[i] = Integer.parseInt(values[i]);
        }
        return val;
    }

    static class Pair{
        int row;
        int value;
        public Pair(int row, int value){
            this.row = row;
            this.value = value;
        }

        public int getRow() {
            return row;
        }
        public void setRow(int row) {
            this.row = row;
        }
        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }
        public String toString(){
            return "row "+ this.row + " value "+ this.value;
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

package CP_2_4_1_Graphs;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MatrixTranspose_UVa10895 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/CP2_4_1/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String input = "";
        while(sc.ready()){
            input = sc.nextLine();
            int rows = Integer.parseInt(input.charAt(0)+"");
            int columns = Integer.parseInt(input.charAt(2)+"");
            ArrayList<Pair>[] transpose = new ArrayList[columns+1];
            for(int i=0;i< transpose.length;i++){
                transpose[i]= new ArrayList<>();
            }
            for(int i=0;i<rows;i++){
                String [] positions = sc.nextLine().split(" ");
                if(positions[0].equals("0")){
                    sc.nextLine();
                    continue;
                }
                int[] pos = toInegerPos(positions);
                String[] values = sc.nextLine().split(" ");
                int [] val = toInegerVal(values);
                for(int j=0;j<pos.length;j++){
                    transpose[pos[j]].add(new Pair(i,val[j]));
                }
            }
            System.out.println(columns+" "+rows);

            for(int i=1;i<transpose.length;i++) {
                StringBuilder row1 = new StringBuilder();
                StringBuilder row2 = new StringBuilder();
                row1.append(transpose[i].size() + " ");

                for (int j = 0; j < transpose[i].size(); j++) {
                    row1.append(transpose[i].get(j).row + 1 + " ");
                    row2.append(transpose[i].get(j).value + " ");
                }
                if(row1.length()>1){
                    System.out.println(row1.substring(0, row1.length() - 1));
                }else{
                    System.out.println(row1);
                }
                if(row2.length()>1){
                    System.out.println(row2.substring(0, row2.length() - 1));
                }else{
                    System.out.println(row2);
                }
            }
        }
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

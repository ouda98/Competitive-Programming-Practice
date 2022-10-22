package CP_2_4_1_Graphs;

import java.io.*;
import java.util.StringTokenizer;

public class MyDearNeighbours_UVa10928 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/CP2_4_1/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int testCases = sc.nextInt();
        String input = "";

        for (int i = 0; i < testCases; i++) {
            int neighboursCount = sc.nextInt();
            int min = Integer.MAX_VALUE;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < neighboursCount; j++) {
                String[] neighbours = sc.nextLine().split(" ");
//                System.out.println(neighbours.length);
                if(min> neighbours.length){
                    sb = new StringBuilder();
                    sb.append(j+1);
                    min=neighbours.length;
                }else if(min == neighbours.length){
                    sb.append(" "+((int)j+1));
                }
            }
            out.println(sb.toString());
            sc.nextLine();
        }
        out.flush();
        out.close();

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

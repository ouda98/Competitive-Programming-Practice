package CP_2_4_1_Graphs;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class DemandingDilemma_UVa11550 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner("src/CP2_4_1/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int testCases = sc.nextInt();

        for (int i = 0; i < testCases; i++) {

            String[] dimensions = sc.nextLine().split(" ");
            int vertices = Integer.parseInt(dimensions[0]);
            int numberOfEdges = Integer.parseInt(dimensions[1]);
            int [] edgesCounter = new int[numberOfEdges];
            int [][] grid = new int[vertices][numberOfEdges];
            for(int j=0;j<vertices;j++){
                String [] edges = sc.nextLine().split(" ");
                for(int k=0;k<edges.length;k++){
                    if(edges[k].equals("1")){
                        edgesCounter[k]++;
                        grid[j][k]=1;
                    }

                }
            }
            boolean no = false;
            for(int j=0;j<edgesCounter.length;j++){
                if(!(edgesCounter[j]==2)){
                    out.println("No");
                    no = true;
                    break;
                }
            }
            if(!no){
                HashSet<String> compare = new HashSet<>();
                for(int j=0;j<grid[0].length;j++){
                    StringBuilder sb = new StringBuilder();
                    for(int k=0;k<grid.length;k++){
                        if(grid[k][j]==1)
                            sb.append(k);
                    }
                    if(compare.contains(sb.toString())){
                        out.println("No");
                        no = true;
                        break;
                    }else{
                        compare.add(sb.toString());
                    }
                }
            }
            if(!no)
                out.println("Yes");
//            out.println(Arrays.toString(edgesCounter));

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

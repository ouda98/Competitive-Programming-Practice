package CP_4_2_1_2BFS_DFS;
import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Vertex_UVa00280 {
    static LinkedList<Integer>[] adjList;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/CP4_2_1_2/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        while(sc.ready()){
            int verticesCount = sc.nextInt();
            if(verticesCount==0)
                break;
            adjList = new LinkedList[verticesCount+1];
            for (int i = 0; i < adjList.length; ++i)
                adjList[i] = new LinkedList();
            while (true){
                String[] input = sc.nextLine().split(" ");
                if(input[0].equals("0"))
                    break;
                int start = Integer.parseInt(input[0]);
//                System.out.println(Arrays.toString(input));
//                System.out.println(start);
                for(int i=1;i<input.length-1;i++){
                    adjList[start].add(Integer.parseInt(input[i]));
                }
            }
            String[] startVertices = sc.nextLine().split(" ");
            boolean[] visited;


            for(int i=1;i<startVertices.length;i++){
                int counter = 0;
                StringBuilder sb = new StringBuilder();
                visited = dfs(Integer.parseInt(startVertices[i]),new boolean[adjList.length]);
                for(int j=1;j<visited.length;j++){
                    if(visited[j]==false) {
                        counter++;
                        sb.append(" "+j);
                    }
                }
                out.println(counter+sb.toString());
            }


        }
        out.flush();
        out.close();
    }

    private static boolean[] dfs(int startVertex, boolean[] visited) {
        for(int u : adjList[startVertex]){
            if(!visited[u]){
                visited[u]= true;
                dfs(u, visited);
            }
        }
        return visited;
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

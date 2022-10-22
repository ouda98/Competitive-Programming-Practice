package CP_4_2_5_TopologicalSort;

import java.io.*;
import java.util.*;

public class Beverages_UVa11060 {
    static HashMap<String, Integer> map = new HashMap<>();
    static HashMap<Integer, String> inverseMap = new HashMap<>();
    static LinkedList<Integer>[] adjList;


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/CP_4_2_5/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int c=1;
        while (sc.ready()) {
            int bevCount = sc.nextInt();
            map.clear();
            inverseMap.clear();
            for (int i = 0; i < bevCount; i++) {
                String bev = sc.nextLine();
                map.put(bev, i);
                inverseMap.put(i, bev);
            }
            int edges = sc.nextInt();
            adjList = new LinkedList[bevCount];
            for(int i=0;i<adjList.length;i++)
                adjList[i]=new LinkedList<>();
            int[] degree = new int[bevCount];
            boolean [] visited = new boolean[bevCount];
            for(int i=0;i<edges;i++){
                String[] line = sc.nextLine().split(" ");
                adjList[map.get(line[0])].add(map.get(line[1]));
                degree[map.get(line[1])]++;
            }
            Queue<Integer> queue = new LinkedList<>();
            for(int i=0;i<degree.length;i++){
                if(degree[i]==0){
                    queue.add(i);
                    visited[i]=true;
                    break;
                }

            }
            StringBuilder sb = new StringBuilder();
            sb.append("Case #"+c+": Dilbert should drink beverages in this order:");
            while(!queue.isEmpty()){
                int top = queue.poll();
                visited[top]=true;
                sb.append(" "+inverseMap.get(top));
                for(int i=0;i<adjList[top].size();i++)
                    degree[adjList[top].get(i)]--;
                queue.clear();
                for(int i=0;i<degree.length;i++){
                    if(degree[i]==0 && !visited[i]){
                        queue.add(i);
                    }

                }




            }
            sb.append(".");
            System.out.println(sb);
            sc.nextLine();
            c++;
            System.out.println();
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

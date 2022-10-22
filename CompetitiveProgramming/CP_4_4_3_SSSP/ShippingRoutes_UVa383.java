package CP_4_4_3_SSSP;

import java.io.*;
import java.util.*;

public class ShippingRoutes_UVa383 {
    static HashMap<String, Integer> map = new HashMap<>();
    static LinkedList<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        int c = 1;
        Scanner sc = new Scanner("src/txt.in");
        //        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int cases = sc.nextInt();
        System.out.println("SHIPPING ROUTES OUTPUT");
        System.out.println();
        while (cases-- > 0) {
            int nodes = sc.nextInt();
            int edges = sc.nextInt();
            int queries = sc.nextInt();

            adjList = new LinkedList[nodes];
            for (int i = 0; i < adjList.length; i++)
                adjList[i] = new LinkedList<>();

            for (int i = 0; i < nodes; i++) {
                map.put(sc.next(), i);
            }
            for (int i = 0; i < edges; i++) {
                int from = map.get(sc.next());
                int to = map.get(sc.next());
                adjList[from].add(to);
                adjList[to].add(from);
            }
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[adjList.length];
            int[] dis = new int[adjList.length];
            System.out.println("DATA SET  " + c++);
            System.out.println();
            for (int i = 0; i < queries; i++) {
                int size = sc.nextInt();
                int src = map.get(sc.next());
                int des = map.get(sc.next());
                queue.clear();
                Arrays.fill(visited, false);
                Arrays.fill(dis, -1);
                queue.add(src);
                visited[src] = true;
                dis[src] = 0;
                while (!queue.isEmpty()) {
                    int top = queue.poll();
                    if (top == des)
                        break;
                    for (int j = 0; j < adjList[top].size(); j++) {
                        if (!visited[adjList[top].get(j)]) {
                            visited[adjList[top].get(j)] = true;
                            dis[adjList[top].get(j)] = dis[top] + 1;
                            queue.add(adjList[top].get(j));
                        }
                    }
                }
                if (dis[des] == -1) {
                    System.out.println("NO SHIPMENT POSSIBLE");
                } else
                    System.out.println("$" + (size * dis[des] * 100));

            }
            System.out.println();


        }

        System.out.println("END OF OUTPUT");
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



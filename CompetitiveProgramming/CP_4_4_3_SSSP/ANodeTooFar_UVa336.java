package CP_4_4_3_SSSP;

import java.io.*;
import java.util.*;

public class ANodeTooFar_UVa336 {
    static ArrayList<LinkedList<Integer>> adjList = new ArrayList<>();
    static HashMap<Integer, Integer> map = new HashMap<>();
    static HashMap<Integer, Integer> invMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
        //        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int c = 1;
        while (sc.ready()) {
            int edges = sc.nextInt();
            if (edges == 0)
                break;
            adjList = new ArrayList<>();
            map.clear();
            invMap.clear();
            int count = 0;
            for (int i = 0; i < edges; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                if (map.containsKey(from)) {
                    from = map.get(from);
                } else {
                    map.put(from, count);
                    invMap.put(count, from);
                    adjList.add(new LinkedList<>());
                    from = count;
                    count++;
                }
                if (map.containsKey(to)) {
                    to = map.get(to);
                } else {
                    map.put(to, count);
                    adjList.add(new LinkedList<>());
                    invMap.put(count, to);
                    to = count;
                    count++;
                }

                if (from != to)
                    adjList.get(to).add(from);

                adjList.get(from).add(to);

            }
            int[] dis = new int[adjList.size()];
            boolean[] visited = new boolean[adjList.size()];
            for (int i = 0; i < map.size(); i++) {
                dis[i] = Integer.MAX_VALUE;
            }

            while (true) {
                int src = sc.nextInt();
                int ttl = sc.nextInt();
//                System.out.println(src+" "+ttl);
                if (src == 0 && ttl == 0)
                    break;
                if (!map.containsKey(src)) {
                    System.out.println("Case " + c++ + ": " + map.size() + " nodes not reachable from node " + src + " with TTL = " + ttl + ".");
                    continue;
                }
                src = map.get(src);
                for (int i = 0; i < map.size(); i++) {
                    dis[i] = Integer.MAX_VALUE;
                    visited[i] = false;
                }
                visited[src] = false;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(src);
                visited[src] = true;
                dis[src] = 0;
                int counter = 1;
                while (!queue.isEmpty()) {
                    int top = queue.poll();
                    if (dis[top] == ttl)
                        break;
                    for (int i = 0; i < adjList.get(top).size(); i++) {
                        if (!visited[adjList.get(top).get(i)]) {
                            visited[adjList.get(top).get(i)] = true;
                            counter++;
                            dis[adjList.get(top).get(i)] = dis[top] + 1;
                            queue.add(adjList.get(top).get(i));
                        }

                    }

                }
                System.out.println("Case " + c++ + ": " + (map.size() - counter) + " nodes not reachable from node " + invMap.get(src) + " with TTL = " + ttl + ".");

            }


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




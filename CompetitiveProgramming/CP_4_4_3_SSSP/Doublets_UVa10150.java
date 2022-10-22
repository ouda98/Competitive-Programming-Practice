package CP_4_4_3_SSSP;

import java.io.*;
import java.util.*;

public class Doublets_UVa10150 {

    static HashMap<String, Integer> map = new HashMap<>();
    static HashMap<Integer, String> inMap = new HashMap<>();
    static ArrayList<LinkedList<Integer>> adjList;

    public static void main(String[] args) throws IOException {
        int c = 1;
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        ArrayList<String> dic = new ArrayList<>();
        adjList = new ArrayList<>();
        int count = 0;
        while (true) {
            String line = sc.nextLine();

            if (line == null || line.length() == 0)
                break;
            map.put(line, count);
            inMap.put(count, line);
            count++;
            adjList.add(new LinkedList<>());
            for (int i = 0; i < dic.size(); i++) {
                String s = dic.get(i);
                int dif = 0;
                if (s.length() == line.length()) {
                    for (int j = 0; j < s.length(); j++) {
                        if (s.charAt(j) != line.charAt(j))
                            dif++;
                    }
                }
                if (dif == 1) {
                    adjList.get(map.get(line)).add(map.get(s));
                    adjList.get(map.get(s)).add(map.get(line));
                }
            }
            dic.add(line);

        }
        Queue<Integer> queue = new LinkedList<>();
        String[] path = new String[adjList.size()];
        boolean[] visited = new boolean[adjList.size()];
        boolean f = false;
        while (true) {
            String line = sc.nextLine();

            if (line == null || line.length() == 0)
                break;
            if (f)
                System.out.println();
            f = true;
            String[] q = line.split(" ");
            int src = map.get(q[0]);
            int des = map.get(q[1]);

            queue.clear();
            Arrays.fill(visited, false);
            Arrays.fill(path, "");
            queue.add(src);
            visited[src] = true;
            path[src] = "";
            while (!queue.isEmpty()) {
                int top = queue.poll();
                if (top == des)
                    break;
                for (int j = 0; j < adjList.get(top).size(); j++) {
                    if (!visited[adjList.get(top).get(j)]) {
                        visited[adjList.get(top).get(j)] = true;
                        path[adjList.get(top).get(j)] = path[top] + " " + top;
                        queue.add(adjList.get(top).get(j));
                    }
                }
            }
            if (path[des].length() == 0)
                System.out.println("No solution.");
            else {
                String [] s = path[des].split(" ");
                for (int i = 1; i < s.length; i++)
                    System.out.println(inMap.get(Integer.parseInt(s[i])));
                System.out.println(q[1]);
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

package CP_4_4_3_SSSP;

import java.io.*;
import java.util.*;

public class WordTransformation_UVa429 {
    static HashMap<String, Integer> map = new HashMap<>();
    static ArrayList<LinkedList<Integer>> adjList;

    public static void main(String[] args) throws IOException {
        int c = 1;
        Scanner sc = new Scanner("src/txt.in");
        //        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int cases = sc.nextInt();
        ArrayList<String> dic = new ArrayList<>();
        adjList = new ArrayList<>();
        boolean f = false;
        while (cases-- > 0) {
            if(f)
                System.out.println();
            f=true;
            int count = 0;
            map.clear();
            adjList = new ArrayList<>();
            dic.clear();
            while (true) {
                String line = sc.nextLine();

                if (line.equals("*"))
                    break;
                map.put(line, count++);
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
//            for(int i=0;i<adjList.size();i++)
//                System.out.println(adjList.get(i));
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[adjList.size()];
            int[] dis = new int[adjList.size()];
            while (true) {
                String line = sc.nextLine();

                if (line == null || line.length()==0)
                    break;
                String[] q = line.split(" ");
                int src = map.get(q[0]);
                int des = map.get(q[1]);
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
                    for (int j = 0; j < adjList.get(top).size(); j++) {
                        if (!visited[adjList.get(top).get(j)]) {
                            visited[adjList.get(top).get(j)] = true;
                            dis[adjList.get(top).get(j)] = dis[top] + 1;
                            queue.add(adjList.get(top).get(j));
                        }
                    }
                }
                System.out.println(line +" "+ dis[des]);


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

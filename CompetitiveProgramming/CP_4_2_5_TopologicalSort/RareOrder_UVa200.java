package CP_4_2_5_TopologicalSort;

import java.io.*;
import java.util.*;


public class RareOrder_UVa200 {
    static LinkedList<Integer>[] grid;
    static boolean[] visited;
    static int count = 0;
    static Stack<Integer> stack = new Stack<>();
    static HashMap<Character, Integer> map = new HashMap<>();
    static HashMap<Integer, Character> inverseMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/CP_4_2_5/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int counter = 0;
        int c = 0;
        int from = 0;
        int to = 0;
        String first = "";
        String second = "";
        grid = new LinkedList[27];
        for (int i = 0; i < grid.length; i++)
            grid[i] = new LinkedList<>();
        visited = new boolean[27];
        while (sc.ready()) {

            if (counter == 0) {
                first = sc.nextLine();
                counter=-1;
            }
            else
                first = second;
            second = sc.nextLine();
            if (second!=null && second.equals("#")){


                for (int i = 0; i < count; i++) {
                    if (!visited[i]){
                        dfs(i);
                    }

                }
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty()){
                    sb.append(inverseMap.get(stack.pop()));
                }
                counter=0;
                Arrays.fill(visited,false);
                for (int i = 0; i < grid.length; i++)
                    grid[i] = new LinkedList<>();
                count=0;
                map.clear();
                inverseMap.clear();
                if(sb.length()==0)
                    sb.append(first.charAt(0));
                System.out.println(sb);
                continue;
            }

            c = 0;
            while (c < first.length() && c < second.length()) {
                char letterF = first.charAt(c);
                char letterS = second.charAt(c);
                if (letterF != letterS) {
                    if (map.containsKey(letterF))
                        from = map.get(letterF);
                    else {
                        from = count;
                        inverseMap.put(count,letterF);
                        map.put(letterF, count);
                        count++;

                    }

                    if (map.containsKey(letterS))
                        to = map.get(letterS);
                    else{
                        to = count;
                        inverseMap.put(count,letterS);
                        map.put(letterS, count);
                        count++;
                    }
                    grid[from].add(to);
                    break;
                }
                c++;
            }
        }


        out.flush();
        out.close();
    }

    private static void dfs(int x) {
        visited[x] = true;
        int next;
        for (int i = 0; i < grid[x].size(); i++) {
            next = grid[x].get(i);

            if (!visited[next])
                dfs(next);
        }
        stack.add(x);
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





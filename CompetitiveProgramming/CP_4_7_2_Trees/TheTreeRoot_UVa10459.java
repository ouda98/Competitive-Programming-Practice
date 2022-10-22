package CP_4_7_2_Trees;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class TheTreeRoot_UVa10459 {
    static int max;
    static int v;
    static ArrayList<Integer> [] adjList;
    static boolean[] visited;
    static HashSet<Integer> set;
    static int worst = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        while (sc.ready()){
            int n = sc.nextInt();
            adjList = new ArrayList[n+1];
            visited = new boolean[n+1];
            for(int i=1;i<=n;i++)
                adjList[i] = new ArrayList<>();
            for(int i=1;i<=n;i++){
                int edges = sc.nextInt();
                for(int j=0;j<edges;j++)
                    adjList[i].add(sc.nextInt());
            }
            max =0;
            solve(1,0);
            max = 0;
            Arrays.fill(visited,false);
            solve(v,0);
            worst = max;
            StringBuilder bad = new StringBuilder();
            StringBuilder good = new StringBuilder();
            int min = Integer.MAX_VALUE;
            set = new HashSet<>();
            for(int i=1;i<=n;i++){
                max = 0;
                Arrays.fill(visited,false);
                if(set.contains(i)) {
                    bad.append(" " + i);
                    continue;
                }

                solve(i,0);
                if(max==worst)
                    bad.append(" "+i);
                else if(max<min) {
                    min = max;
                    good = new StringBuilder();
                    good.append(" "+i);
                } else if(max == min){
                   good.append(" "+i);
                }
            }
            System.out.println("Best Roots  : "+good.substring(1));
            System.out.println("Worst Roots : "+bad.substring(1));

        }


        out.flush();
        out.close();
    }

    private static void solve(int value, int steps) {
        visited[value] = true;
        for(int i: adjList[value]) {
            if(!visited[i])
                solve(i, steps + 1);
        }
        if(steps>max){
            max = steps;
            v = value;
            if(max==worst)
                set.add(value);
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


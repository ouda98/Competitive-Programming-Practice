package CP_4_2_6_Bipartite_Graph;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PlaceTheGuards_UVa11080 {
    static LinkedList<Integer>[] grid;
    static int[] color1;
    static int[] color0;
    static int count = 0;
    static int counter0;
    static int counter1;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
        //        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        Queue<Integer> queue = new LinkedList<>();
        int cases = sc.nextInt();
        for (int k = 0; k < cases; k++) {
            int nodes = sc.nextInt();
            int edges = sc.nextInt();
            grid = new LinkedList[nodes];
            for (int i = 0; i < grid.length; i++) {
                grid[i] = new LinkedList<>();
            }

            for (int i = 0; i < edges; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                grid[from].add(to);
                grid[to].add(from);
            }


            color1 = new int[nodes];
            color0 = new int[nodes];
            Arrays.fill(color1, -1);
            Arrays.fill(color0, -1);
            queue.clear();
            counter1 = 0;
            counter0 = 0;
            int c=0;
            for (int i = 0; i < grid.length; i++) {

                if(color0[i]==-1 && color1[i]==-1){
//                    System.out.println("start "+i);
                    addZero(i);
                    addOne(i);
                }
//                System.out.println(counter1+" "+counter0);
                if(counter1==-1 && counter0==-1){
                    c=-1;
                    break;
                }
                else if(counter1==-1)
                    c+= counter0;
                else if(counter0==-1)
                    c+= counter1;
                else
                    c+= Math.min(counter1,counter0);

                counter1 = 0;
                counter0 = 0;

            }
            System.out.println(c);
        }
        out.flush();
        out.close();
    }

    private static void addZero(int x) {
        Queue<Integer> queue = new LinkedList<>();
        color0[x] = 0;
        if (grid[x].size() == 0)
            counter0++;
        else
            queue.add(x);
        while (queue.size() != 0) {
            int vertex = queue.poll();

            for (int i = 0; i < grid[vertex].size(); i++) {
                int top = grid[vertex].get(i);
                if (color0[top] == -1) {
                    color0[top] = 1 - color0[vertex];
                    counter0+=color0[top];
                    queue.add(top);
                } else if (color0[vertex] == color0[top]) {
                    counter0=-1;
                    queue.clear();
                    break;
                }

            }
        }

    }

    private static void addOne(int x) {
        Queue<Integer> queue = new LinkedList<>();
        color1[x] = 1;
        counter1++;
        queue.add(x);
        color1[x] = 1;
        queue.add(x);
        while (queue.size() != 0) {
            int vertex = queue.poll();

            for (int i = 0; i < grid[vertex].size(); i++) {

                int top = grid[vertex].get(i);

                if (color1[top] == -1) {
                    color1[top] = 1 - color1[vertex];
                    counter1 += color1[top];
                    queue.add(top);
                } else if (color1[vertex] == color1[top]) {
                    queue.clear();
                    counter1 = -1;
                    break;
                }

            }
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



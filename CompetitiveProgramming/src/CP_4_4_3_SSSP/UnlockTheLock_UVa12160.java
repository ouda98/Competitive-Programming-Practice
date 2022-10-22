package CP_4_4_3_SSSP;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class UnlockTheLock_UVa12160 {
    static int[] dist = new int[10000];
    static boolean[] visited = new boolean[10000];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int c=1;
        while (true) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int r = sc.nextInt();

            if (start == 0 && end == 0 && r == 0)
                break;
            int[] buttons = new int[r];
            for (int i = 0; i < r; i++) {
                buttons[i] = sc.nextInt();

            }
            for (int i = 0; i < visited.length; i++) {
                visited[i] = false;
                dist[i] = -1;
            }
            Queue<Integer> queue = new LinkedList<>();
            visited[start] = true;
            queue.add(start);
            dist[start] = 0;
            while (!queue.isEmpty()) {
                int top = queue.poll();
                if (top == end)
                    break;
                int nx = 0;
                for (int i = 0; i < buttons.length; i++) {
                    nx = (top + buttons[i]) % 10000;
                    if (!visited[nx]) {
                        visited[nx] = true;
                        dist[nx] = dist[top] + 1;
                        queue.add(nx);
                    }
                }
            }
            if (dist[end] == -1)
                System.out.println("Case "+c+++": Permanently Locked");
            else
                System.out.println("Case "+c+++": "+dist[end]);
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



package CP_2_4_1_Graphs;

import java.io.*;
import java.util.*;

public class TheForrestForTheTrees_UVa599 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/CP2_4_1/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int testCases = sc.nextInt();
        String input = "";

        for (int i = 0; i < testCases; i++) {
            LinkedList<Integer> adjList[] = new LinkedList[26];
            while (sc.ready()) {
                input = sc.nextLine();
                if (input.charAt(0) == '*') {
                    break;
                }
                int start = input.charAt(1) - 'A';
                int end = input.charAt(3) - 'A';
                if (adjList[start] == null) {
                    adjList[start] = new LinkedList<Integer>();
                }
                if (adjList[end] == null) {
                    adjList[end] = new LinkedList<Integer>();
                }
                adjList[start].add(end);
                adjList[end].add(start);
            }
//            for (int k = 0; k < adjList.length; k++) {
//                System.out.println(k + " : " + adjList[k]);
//            }
            String[] alphabet = sc.nextLine().split(",");
            HashSet<Integer> alpha = new HashSet<>();
            for (int j = 0; j < alphabet.length; j++) {
                alpha.add(alphabet[j].charAt(0) - 65);
            }
            Bfs(adjList, alpha);
        }
        out.flush();
        out.close();
    }

    private static void Bfs(LinkedList<Integer>[] adjList, HashSet<Integer> alpha) {
        int acrons = 0;
        int trees = 0;
        boolean[] visited = new boolean[26];
        Queue<Integer> traverse = new LinkedList<>();
        for (int i = 0; i < adjList.length; i++) {
            if (adjList[i] == null && alpha.contains(i)) {
                acrons++;
                visited[i] = true;
            } else if (adjList[i] == null || visited[i] == true) {
                continue;
            } else {
                for (int j = 0; j < adjList[i].size(); j++) {
                    traverse.add(adjList[i].get(j));
//                    System.out.println(adjList[i].get(j));
                }
                visited[i] = true;
                while (!traverse.isEmpty()) {
                    int top = traverse.poll();
                    visited[top] = true;
                    if (adjList[top] != null) {
                        for (int j = 0; j < adjList[top].size(); j++) {
                            if (!visited[adjList[top].get(j)])
                                traverse.add(adjList[top].get(j));
                        }
                    }
                }

                trees++;

            }
        }
        System.out.printf("There are %d tree(s) and %d acorn(s).\n", trees, acrons);

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

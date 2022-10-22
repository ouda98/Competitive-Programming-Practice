package Algorithms;

import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {
    static LinkedList<Integer>[] grid;
    static boolean[] visited;
    static Stack<Integer> stack = new Stack<>();
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
}

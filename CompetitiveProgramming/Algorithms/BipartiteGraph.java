package Algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    static LinkedList<Integer>[] grid;
    static int[] color;

    public static void main(String[] args) {
        boolean flag = false;
        color[0] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (queue.size() != 0) {
            int vertex = queue.poll();

            for (int i = 0; i < grid[vertex].size(); i++) {

                int top = grid[vertex].get(i);
                if (color[top] == -1) {
                    color[top] = 1 - color[vertex];
                    queue.add(top);
                } else if (color[vertex] == color[top]) {
                    flag = false;
                    break;
                }

            }
        }
    }
}

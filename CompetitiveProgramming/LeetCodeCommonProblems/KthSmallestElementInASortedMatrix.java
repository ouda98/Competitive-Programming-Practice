package LeetCodeCommonProblems;

import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Pair> q = new PriorityQueue<>();
        for (int i = 0; i < matrix.length; i++) {
            q.add(new Pair(i, 0, matrix[i][0]));
        }
        int c = 0;
        Pair top = null;
        while (c++ < k) {
            top = q.poll();
            System.out.println(top.value);
            if (top.j + 1 >= matrix.length)
                continue;
            q.add(new Pair(top.i, top.j + 1, matrix[top.i][top.j + 1]));
        }
        return top.value;
    }

    public static class Pair implements Comparable<Pair> {
        int i;
        int j;
        int value;

        public Pair(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }

        public String toString() {
            return i + " " + j + " " + value;
        }

        public int compareTo(Pair other) {
            return this.value - other.value;
        }
    }
}

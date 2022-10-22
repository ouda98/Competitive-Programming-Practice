import java.util.*;

public class DirectedGraphLoop {
    public static void main(String[] args) {
        int[] start = {1};
        int[] end = {2};
        boolean f = isCyclicGraph(start, end);
        System.out.println(f);
    }

    public static boolean isCyclicGraph(int[] start, int[] end) {
        // Write your code here
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        HashMap<Integer, Integer> indegree = new HashMap<>();
        for (int i = 0; i < start.length; i++) {
            if (!adj.containsKey(start[i]))
                adj.put(start[i], new ArrayList<>());

            if (!indegree.containsKey(end[i]))
                indegree.put(end[i], 0);

            adj.get(start[i]).add(end[i]);
            indegree.put(end[i], indegree.get(end[i]) + 1);
        }

        Queue<Integer> q = new LinkedList<>();
        for (Integer i : adj.keySet()) {
            if (!indegree.containsKey(i))
                q.add(i);
        }

        while (!q.isEmpty()) {
            int top = q.poll();
            if(!adj.containsKey(top))
                continue;
            for (Integer i : adj.get(top)) {
                indegree.put(i, indegree.get(i) - 1);
                if (indegree.get(i) == 0) {
                    q.add(i);
                    indegree.remove(i);
                }
            }
        }
        return indegree.size()!=0;
    }
}

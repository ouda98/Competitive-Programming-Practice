package LintCodeBacktracking;

import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    static List<List<Integer>> s;
    static int [][]graph;
    public static void main(String[] args) {
        graph = new int[][]{{1, 3}, {2}, {3}, {}};
        s = new LinkedList<>();

        solve(0, new LinkedList<>());
        System.out.println(s);

    }

    private static void solve(int idx, List<Integer> r) {
        r.add(idx);
        if(r.get(r.size()-1)==graph.length-1){

            List<Integer> e = new LinkedList<>();
            e.addAll(r);
            s.add(e);
            r.remove(r.size()-1);
            return;
        }
        for(int i=0;i<graph[idx].length;i++){
            solve(graph[idx][i],r);
        }
        r.remove(r.size()-1);

    }

}

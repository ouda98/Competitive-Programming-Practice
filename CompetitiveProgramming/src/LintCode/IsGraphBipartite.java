package LintCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
    public static void main(String[] args) {

    }
    public class Solution {
        /**
         * @param graph: the given undirected graph
         * @return:  return true if and only if it is bipartite
         */
        public boolean isBipartite(int[][] graph) {
            // Write your code here
            int[] color = new int [graph.length];
            Arrays.fill(color, -1);

            Queue<Integer> q = new LinkedList<>();
            for(int j=0;j<graph.length;j++){
                color[j] = 1;
                q.add(j);
                while(!q.isEmpty()){
                    int top = q.poll();
                    for(int i=0;i<graph[top].length;i++){
                        if(color[graph[top][i]] == -1){
                            q.add(graph[top][i]);
                            color[graph[top][i]] = 1 - color[top];
                        }else if(color[graph[top][i]] == color[top])
                            return false;
                    }
                }
                q.clear();
                Arrays.fill(color, -1);
            }
            return true;

        }
    }
}

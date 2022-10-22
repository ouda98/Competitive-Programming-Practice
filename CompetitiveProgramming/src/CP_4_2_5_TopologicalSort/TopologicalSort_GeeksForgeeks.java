package CP_4_2_5_TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort_GeeksForgeeks {
    public static void main(String[] args) {

    }
    class Solution
    {
        //Function to return list containing vertices in Topological order.
        static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
        {
            // add your code here
            int [] indegree = new int[V];
            for(int i = 0;i < adj.size();i++){
                for(int j = 0;j < adj.get(i).size();j++){
                    indegree[adj.get(i).get(j)]++;
                }
            }
            Queue<Integer> q = new LinkedList<>();
            for(int i=0;i<indegree.length;i++)
                if(indegree[i] == 0)
                    q.add(i);
            int [] result = new int [V];
            int count = 0;

            while(!q.isEmpty()){
                int top = q.poll();
                result[count++] = top;

                for(int i=0;i<adj.get(top).size();i++){
                    indegree[adj.get(top).get(i)]--;
                    if(indegree[adj.get(top).get(i)] == 0)
                        q.add(adj.get(top).get(i));
                }

            }
            return result;
        }
    }
}

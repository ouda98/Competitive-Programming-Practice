import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {
    public static void main(String[] args) {

    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<Integer>());
        int[] indegrees = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegrees[prerequisites[i][0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[numCourses];
        int x = 0;
        for(int i=0;i<indegrees.length;i++){
            if(indegrees[i] == 0){
                q.add(i);
                result[x++] = i;
            }
        }
        while(!q.isEmpty()){
            int p = q.poll();
            for(int n : adj.get(p)){
                indegrees[n]--;
                if(indegrees[n] == 0){
                    q.add(n);
                    result[x++] = n;
                }
            }
        }
        if(x == numCourses)
            return result;
        return new int[0];
    }

}

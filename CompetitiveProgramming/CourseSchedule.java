import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    public class Solution {
        /**
         * @param numCourses: a total of n courses
         * @param prerequisites: a list of prerequisite pairs
         * @return: true if can finish all courses or false
         */
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            // write your code here
            if(prerequisites == null || prerequisites.length==0)
                return true;
            ArrayList<Integer>[] adj = new ArrayList[numCourses];
            for(int i=0;i<adj.length;i++)
                adj[i] = new ArrayList<>();

            int [] indegrees = new int[numCourses];
            for(int i=0;i<prerequisites.length;i++){
                adj[prerequisites[i][1]].add(prerequisites[i][0]);
                indegrees[prerequisites[i][0]]++;
            }
            Queue<Integer> q = new LinkedList<>();
            int counter =0;
            for(int i=0;i<numCourses;i++){
                if(indegrees[i] == 0){
                    q.add(i);
                    counter++;
                }
            }
            while(!q.isEmpty()){
                int top = q.poll();
                for(int i=0;i<adj[top].size();i++){
                    indegrees[adj[top].get(i)]--;
                    if(indegrees[adj[top].get(i)] == 0){
                        q.add(adj[top].get(i));
                        counter++;
                    }
                    if(counter==numCourses)
                        return true;
                }
            }

            return false;
        }
    }
}

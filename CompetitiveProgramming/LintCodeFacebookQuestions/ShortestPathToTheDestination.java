package LintCodeFacebookQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathToTheDestination {
    public class Solution {
        /**
         * @param targetMap:
         * @return: nothing
         */
        static int [] dr = {1, 0, -1, 0};
        static int [] dc = {0, 1, 0, -1};
        public int shortestPath(int[][] targetMap) {
            // Write your code here
            boolean [][] visited = new boolean[targetMap.length][targetMap[0].length];
            Queue<Triple> q = new LinkedList<>();
            q.add(new Triple(0,0,0));
            visited[0][0] = true;
            while(!q.isEmpty()){
                Triple top = q.poll();
                int x,y;
                for(int i=0;i<dr.length;i++){
                    x = top.x +dr[i];
                    y = top.y +dc[i];
                    if(can(x,y,targetMap) && !visited[x][y]){
                        if(targetMap[x][y]==2)
                            return top.steps+1;
                        visited[x][y] = true;
                        q.add(new Triple(x,y,top.steps+1));
                    }
                }

            }
            return -1;
        }

        public boolean can(int x, int y, int[][] targetMap){
            if(x>=0 && x<targetMap.length && y>=0 && y< targetMap[0].length && targetMap[x][y]!=1)
                return true;
            return false;
        }

        public class Triple{
            int x;
            int y;
            int steps;
            public Triple(int x, int y, int steps){
                this.x = x;
                this.y = y;
                this.steps = steps;
            }
        }
    }
}

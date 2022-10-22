import java.util.LinkedList;
import java.util.Queue;

public class Portal {
    public class Solution {
        /**
         * @param Maze:
         * @return: nothing
         */
        static int [] dr = {1, -1, 0, 0};
        static int [] dc = {0, 0, 1, -1};
        public int Portal(char[][] Maze) {
            int x = 0;
            int y =0;
            for(int i=0;i<Maze.length;i++){
                for(int j=0;j<Maze[0].length;j++){
                    if(Maze[i][j]=='S'){
                        x = i;
                        y = j;
                    }
                }
            }
            Queue<Triple> q = new LinkedList<>();
            q.add(new Triple(x,y,0));
            while(!q.isEmpty()){
                Triple top = q.poll();
                int nx, ny;
                for(int i=0;i<dr.length;i++){
                    nx = top.x + dr[i];
                    ny = top.y + dc[i];
                    if(can(Maze, nx, ny)){
                        if(Maze[nx][ny] == 'E')
                            return top.steps +1;
                        Maze[nx][ny] = '#';
                        q.add(new Triple(nx,ny,top.steps +1));
                    }
                }

            }
            return -1;
        }

        public static boolean can(char[][]Maze, int x, int y){
            return x>=0 && y>=0 && x<Maze.length && y<Maze[0].length && Maze[x][y] != '#';
        }

        public static class Triple{
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

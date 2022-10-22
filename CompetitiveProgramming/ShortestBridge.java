import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    public class Solution {
        static int [] dr = {0,0,1,-1};
        static int [] dc = {1, -1,0,0};
        static Queue<Triple> q;
        public int ShortestBridge(int[][] A) {
            int x = 0;
            int y = 0;
            boolean f = false;
            q = new LinkedList<>();
            for(int i=0;i<A.length && !f;i++)
                for(int j=0;j<A[0].length && !f;j++)
                    if(A[i][j]==1){
                        x = i;
                        y = j;
                        f = true;
                        dfs(A,x,y);
                        break;
                    }


            A[x][y] = -1;
            while(!q.isEmpty()){
                Triple top = q.poll();
                int nx,ny;
                for(int i=0;i<dr.length;i++){
                    nx = top.x + dr[i];
                    ny = top.y + dc[i];
                    if(valid(A,nx,ny)){
                        if(A[nx][ny] == 1)
                            return top.d;
                        else if (A[nx][ny] == 0){
                            A[nx][ny] = -1;
                            q.add(new Triple(nx, ny, top.d+1));
                        }
                    }
                }

            }
            return -1;

        }

        public static boolean valid(int [][]A, int x, int y){
            return x>=0 && y>=0 && x<A.length && y<A[0].length;
        }

        public static void dfs(int [][]A, int x ,int y){
            A[x][y] = 2;
            q.add(new Triple(x,y,0));
            int nx, ny;
            for(int i=0;i<dr.length;i++){
                nx = x + dr[i];
                ny = y + dc[i];
                if(valid(A,nx,ny) && A[nx][ny] == 1)
                    dfs(A, nx, ny);
            }
        }

        public static class Triple{
            int x;
            int y;
            int d;

            public Triple(int x, int y, int d){
                this.x = x;
                this.y = y;
                this.d = d;
            }
        }
    }
}

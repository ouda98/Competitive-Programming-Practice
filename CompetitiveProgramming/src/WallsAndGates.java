import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    public static void main(String[] args) {

    }
    static int[] h = new int[]{0,1,0,-1};
    static int[] v = new int[]{1,0,-1,0};
    static boolean[][] visited;
    public class Pair{
        int x;
        int y;
        int distance;
        public Pair(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    public void wallsAndGates(int[][] rooms) {
        // write your code here
        visited = new boolean[rooms.length][rooms[0].length];
        for(int i=0;i<rooms.length;i++){
            for(int j=0;j<rooms[i].length;j++){
                if(rooms[i][j] != 0 && rooms[i][j]!=-1){
                    visited = new boolean[rooms.length][rooms[0].length];
                    visited[i][j] = true;
                    rooms[i][j] = bfs(i,j,rooms);
                }
            }
        }

    }
    public int bfs(int x, int y, int[][] rooms){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x,y,0));
        Pair r;
        while(!q.isEmpty()){
            r = q.poll();
            for(int i=0;i<h.length;i++){
                if(valid(r.x,r.y,h[i],v[i],rooms)){
                    if(rooms[r.x+h[i]][r.y+v[i]] == 0)
                        return r.distance+1;
                    visited[r.x+h[i]][r.y+v[i]] = true;
                    q.add(new Pair(r.x+h[i],r.y+v[i],r.distance+1));
                }

            }
        }
        return rooms[x][y];
    }
    public boolean valid(int x, int y, int i, int j, int[][] rooms){
        return x+i >= 0 && x+i < rooms.length && y+j >= 0 && y+j < rooms[x+i].length && rooms[x+i][j+y] != -1 && !visited[x+i][j+y];
    }
}

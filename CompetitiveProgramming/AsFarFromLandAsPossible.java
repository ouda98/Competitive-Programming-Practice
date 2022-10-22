import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible {
    static int [] dr = {1,-1,0,0};
    static int [] dc = {0,0,-1,1};
    public static void main(String[] args) {
        int [][]grid = {{1,0,1},{0,0,0},{1,0,1}};
        System.out.println(maxDistance(grid));
    }
    static public int maxDistance(int[][] grid) {
        // Write your code here.
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) {
                    q.add(new Pair(i, j));
                    visited.add(i+""+j);
                }
            }
        }
        int steps = -1;
        while(!q.isEmpty()){
            steps++;
            int size = q.size();
            for(int i=0;i<size;i++){
                Pair top = q.poll();
                int newX;
                int newY;
                for(int j=0;j<dr.length;j++){
                    newX = top.row + dr[j];
                    newY = top.column + dc[j];
                    Pair newLocation = new Pair(newX,newY);
                    if(can(grid, newX,newY) && !visited.contains(newX+""+newY)){
                        q.add(newLocation);
                        visited.add(newX+""+newY);
                    }
                }
            }
        }
        return (steps == 0)?-1 : steps;
    }
    public static boolean can(int[][] grid, int newX, int newY){
        return newX>=0 && newY>= 0 && newX<grid.length && newY<grid.length;

    }
    public static class Pair{
        int row;
        int column;
        public Pair(int row, int column){
            this.row = row;
            this.column = column;
        }
    }
}

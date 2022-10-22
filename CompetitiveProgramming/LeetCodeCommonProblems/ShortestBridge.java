package LeetCodeCommonProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    public static void main(String[] args) {
        int[][] arr = {{1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 1},
                        {1, 0, 1, 0, 1},
                        {1, 0, 0, 0, 1},
                        {1, 1, 1, 1, 1}};
        int v = ShortestBridge(arr);
        System.out.println(v);
    }
    static int[] dr = {0,0,1,-1};
    static int[] dc = {1,-1,0,0};
    static ArrayList<Pair> start;
    public static int ShortestBridge(int[][] A) {
        start = new ArrayList<>();
        boolean found = false;
        for(int i=0;i<A.length && !found;i++){
            for(int j=0;j<A[0].length && !found;j++){
                if(A[i][j]==1){
                    dfs(A, i, j);
                    found = true;
                }
            }
        }
        for(int i=0;i<A.length;i++)
            System.out.println(Arrays.toString(A[i]));
        int min = Integer.MAX_VALUE;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean [A.length][A[0].length];
        System.out.println(Arrays.toString(start.toArray()));
        for(Pair p : start){
            q.clear();
            q.add(p);
            for(int i=0;i<visited.length;i++)
                Arrays.fill(visited[i],false);
            boolean way = false;
            while(!q.isEmpty() && !way){
                Pair top = q.poll();
                int x,y;
                for(int i=0;i<dr.length;i++){
                    x = top.x + dr[i];
                    y = top.y + dc[i];
                    if(valid(A,x,y)){
                        if(A[x][y] == 1){
                            min = Math.min(min,top.distance);
                            way = true;
                            break;
                        }
                        if(A[x][y]==0 && !visited[x][y]){
                            visited[x][y] = true;
                            q.add(new Pair(x,y,top.distance+1));
                        }


                    }
                }
            }
        }
        return min;
    }
    public static class Pair{
        int x;
        int y;
        int distance;
        public Pair(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
        public String toString(){
            return x+" "+y+" "+distance;
        }
    }
    public static void dfs(int[][] arr, int i, int j){
        start.add(new Pair(i,j,0));
        arr[i][j] =2;
        int x,y;
        for(int k=0;k<dr.length;k++){
            x = i + dr[k];
            y = j + dc[k];
            if(valid(arr,x,y) && arr[x][y] == 1)
                dfs(arr,x,y);
        }
    }

    public static boolean valid(int [][]arr, int x, int y){
        return x>=0 && y>=0 && x<arr.length && y<arr[0].length;
    }
}

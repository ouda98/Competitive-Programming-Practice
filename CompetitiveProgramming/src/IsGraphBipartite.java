import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
    public static void main(String[] args) {

    }
    public boolean isBipartite(int[][] graph) {
        int [] color = new int[graph.length];
        Arrays.fill(color, -1);
        Queue<Integer> q = new LinkedList<>();
        int r;
        for(int i=0;i<graph.length;i++){
            if(color[i] == -1){
                q.add(i);
                color[i] = 0;
            }
            while(!q.isEmpty()){
                r = q.poll();
                for(int j=0;j<graph[r].length;j++){
                    if(color[graph[r][j]] == color[r])
                        return false;
                    if(color[graph[r][j]] == -1){
                        q.add(graph[r][j]);
                        color[graph[r][j]] = 1 - color[r];
                    }
                }
            }
        }
        return true;
    }
}

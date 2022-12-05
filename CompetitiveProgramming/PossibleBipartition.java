import java.util.*;

public class PossibleBipartition {
    public static void main(String[] args) {

    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n+1];
        Arrays.fill(color, -1);
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<dislikes.length;i++){
            adj.get(dislikes[i][0]).add(dislikes[i][1]);
            adj.get(dislikes[i][1]).add(dislikes[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<color.length;i++){
            if(color[i] !=-1)
                continue;
            color[i] = 0;
            q.add(i);
            while(!q.isEmpty()){
                int polled = q.poll();
                for(int nums : adj.get(polled)){
                    if(color[nums] == -1){
                        color[nums] = 1 - color[polled];
                        q.add(nums);
                    }else if(color[nums] == color[polled])
                        return false;
                }
            }
        }
        return true;
    }
}

package GeeksForGeeks;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathFrom1ton {
    public static void main(String[] args) {

    }
    public static class Pair{
        int val;
        int distance;
        public Pair(int val, int distance){
            this.val = val;
            this.distance = distance;
        }
    }

    static int minStep(int n){
        //complete the function here
        HashSet<Integer> visited = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(n,1));
        visited.add(n);
        Pair r;
        while(!q.isEmpty()){
            r = q.poll();
            if(r.val-1== 1 || (r.val % 3 == 0 && r.val/3 == 1))
                return r.distance;
            if( r.val % 3 == 0 && r.val/3>1 && !visited.contains(r.val/3)){
                q.add(new Pair(r.val/3, r.distance+1));
                visited.add(r.val/3);
            }
            else if(r.val-1> 1 && !visited.contains(r.val-1)){
                q.add(new Pair(r.val-1,r.distance+1));
                visited.add(r.val-1);
            }
        }
        return -1;
    }
}

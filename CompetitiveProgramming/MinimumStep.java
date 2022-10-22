import java.util.*;

public class MinimumStep {
    public static void main(String[] args) {

    }
    public class Solution {
        /**
         * @param colors: the colors of grids
         * @return: return the minimum step from position 0 to position n - 1
         */
        public int minimumStep(List<Integer> colors) {
            // write your code here
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            for(int i=0;i<colors.size();i++){
                if(map.containsKey(colors.get(i))){
                    map.get(colors.get(i)).add(i);
                }else{
                    ArrayList v = new ArrayList();
                    v.add(i);
                    map.put(colors.get(i),v);
                }
            }
            Queue<Triple> q = new LinkedList<>();
            boolean [] visited = new boolean[colors.size()];
            q.add(new Triple(0, colors.get(0),0));
            visited[0] = true;
            while(!q.isEmpty()){
                Triple top = q.poll();
                if(top.pos == colors.size()-1)
                    return top.distance;
                if(top.pos>0 && !visited[top.pos-1]){
                    q.add(new Triple(top.pos-1,colors.get(top.pos-1),top.distance+1));
                }
                if(top.pos<colors.size()-1 && !visited[top.pos+1]){
                    visited[top.pos+1] = true;
                    if(top.pos+1 == colors.size()-1)
                        return top.distance +1;
                    q.add(new Triple(top.pos+1,colors.get(top.pos+1),top.distance+1));
                }
                ArrayList<Integer> list = map.get(top.color);
                for(int i:list){
                    if(!visited[i]){
                        if(i == colors.size()-1)
                            return top.distance+1;
                        visited[i] = true;
                        q.add(new Triple(i,colors.get(i),top.distance+1));
                    }
                }
            }
            return 0;

        }

        public static class Triple{
            int pos;
            int color;
            int distance;
            public Triple(int pos, int color, int distance){
                this.pos = pos;
                this.color = color;
                this.distance = distance;
            }
        }
    }
}

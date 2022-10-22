import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MineSweeping {
    public static void main(String[] args) {

    }
    public class Solution {
        /**
         * @param Mine_map: an matrix represents the map.
         * @param Start: the start position.
         * @return: return an array including all reachable positions.
         */
        public List<List<Integer>> Mine_sweeping(int[][] Mine_map, int[] Start) {
            // write your code here
            int [] dr = {0,0,1,-1};
            int [] dc = {1,-1,0,0};
            List<List<Integer>> output = new ArrayList<>();
            List<Integer> first = new ArrayList<>();
            first.add(Start[0]);
            first.add(Start[1]);
            output.add(first);
            Queue<Pair> queue = new LinkedList<>();
            if(Mine_map[Start[0]][Start[1]] == 0){
                return output;
            }
            first = new ArrayList<>();
            queue.add(new Pair(Start[0],Start[1]));
            while(!queue.isEmpty()){
                Pair top = queue.poll();
                Mine_map[top.x][top.y] = -1;
                int x, y;
                for(int i=0;i<dr.length;i++){
                    x = top.x + dr[i];
                    y = top.y + dc[i];

                    if(can(x, y, Mine_map)){
                        first.clear();
                        first.add(x);
                        first.add(y);
                        List<Integer> q = new ArrayList<>(first);
                        output.add(q);
                        if(Mine_map[x][y] == 1)
                            queue.add(new Pair(x,y));
                        Mine_map[x][y] = -1;
                    }
                }

            }
            return output;
        }
        public static boolean can(int x, int y, int[][] Mine_map){
            return x>=0 && y>=0 && x< Mine_map.length && y < Mine_map[0].length && Mine_map[x][y]!=-1;
        }

        public static class Pair{
            int x;
            int y;
            public Pair(int x, int y){
                this.x = x;
                this.y = y;
            }
        }
    }
}

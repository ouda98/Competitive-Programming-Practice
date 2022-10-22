import java.util.HashMap;
import java.util.List;

public class BrickWall {
    public class Solution {
        /**
         * @param wall: a list of rows
         * @return: the number of crossed bricks
         */
        public int leastBricks(List<List<Integer>> wall) {
            // write your code here
            HashMap<Integer, Integer> map = new HashMap<>();
            int sum;
            int max =0;
            for(int i=0;i<wall.size();i++){
                sum =0;
                for(int j=0;j<wall.get(i).size()-1;j++){
                    sum += wall.get(i).get(j);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                    max = Math.max(max, map.get(sum));
                }
            }
            return wall.size() - max;
        }
    }
}

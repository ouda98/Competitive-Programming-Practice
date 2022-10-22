import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumWeightedSumPath {
    public static void main(String[] args) {

    }
    public class Solution {
        /**
         * @param nums:
         * @return: nothing
         */
        static int dr[] = {0,1};
        static int dc[] = {-1,0};
        public int maxWeight(int[][] nums) {
            int [][] distance = new int [nums.length][nums[0].length];
            Queue<Triple> q = new LinkedList<>();
            q.add(new Triple(0,nums[0].length-1,nums[0][nums[0].length-1]));
            distance[0][nums[0].length-1] = nums[0][nums[0].length-1];
            while(!q.isEmpty()){
                Triple top = q.poll();
                if(distance[top.x][top.y] > top.distance)
                    continue;
                int x, y;
                for(int i=0;i<dr.length;i++){
                    x = top.x + dr[i];
                    y = top.y + dc[i];
                    if(can(nums,x,y) && distance[x][y] < top.distance + nums[x][y]){
                        distance[x][y] = top.distance + nums[x][y];
                        q.add(new Triple(x,y, distance[x][y]));
                    }
                }
            }
            return distance[nums.length-1][0];
        }

        public static boolean can(int [][]nums, int x, int y){
            return x >= 0 && y >= 0 && x < nums.length && y < nums[0].length;
        }
        public static class Triple implements Comparable<Triple>{
            int x;
            int y;
            int distance;
            public Triple(int x, int y, int distance){
                this.x = x;
                this.y = y;
                this.distance = distance;
            }
            public int compareTo(Triple other){
                return other.distance - this.distance;
            }
        }
    }
}
/*
[5,16,8,8,4],
[6,0,4,0,5],
[16,0,0,7,5],
[15,6,5,14,16],
[17,9,11,2,4]
 */
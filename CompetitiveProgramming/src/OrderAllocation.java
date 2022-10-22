import java.util.Arrays;

public class OrderAllocation {
    public static void main(String[] args) {
    }
    public class Solution {
        /**
         * @param score: When the j-th driver gets the i-th order, we can get score[i][j] points.
         * @return: return an array that means the array[i]-th driver gets the i-th order.
         */
        static int max;
        static int[] result;
        public int[] orderAllocation(int[][] score) {
            // write your code here
            max =0;
            result = new int[score.length];
            dfs(score, 0,new int[score.length],0);
            return result;
        }

        public static void dfs(int [][]score, int sum, int[] orders, int idx){
            if(idx == score.length){
                if(sum> max){
                    max = sum;
                    result = orders.clone();
                }
                return;
            }
            boolean found;
            for(int i=0;i<score[idx].length;i++){
                found = false;
                for(int j=0;j<idx;j++){
                    if(orders[j] == i)
                        found = true;
                }
                if(!found){
                    orders[idx] = i;
                    dfs(score, sum + score[idx][i], orders, idx+1);
                }
            }
        }
    }
}

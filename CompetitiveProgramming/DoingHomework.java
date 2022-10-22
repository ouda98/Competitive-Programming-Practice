public class DoingHomework {
    public class Solution {
        /**
         * @param cost: the cost
         * @param val: the val
         * @return: the all cost
         */
        public long doingHomework(int[] cost, int[] val) {
            // Write your code here.
            for(int i=1;i< cost.length;i++)
                cost[i]+=cost[i-1];
            long sum = 0;
            for(int i=0;i<val.length;i++){
                sum += bs(val[i],cost);
            }
            return sum;
        }
        public static long bs(int target, int[] cost){
            int left = 0;
            int right = cost.length-1;
            long result = 0;
            while(left<=right){
                int mid = left + (right- left)/2;
                if(cost[mid] <= target){
                    result = cost[mid];
                    left = mid +1;
                }else{
                    right = mid-1;
                }
            }
            return result;
        }
    }
}

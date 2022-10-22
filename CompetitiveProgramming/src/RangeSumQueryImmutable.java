public class RangeSumQueryImmutable {
    class NumArray {
        int [] sum;
        public NumArray(int[] nums) {
            this.sum = new int [nums.length];
            sum[0] = nums[0];
            for(int i=1;i<nums.length;i++){
                sum[i] = nums[i] + sum[i-1];
            }
        }

        public int sumRange(int i, int j) {
            if(i==0)
                return sum[j];
            return sum[j] - sum[i-1];
        }
    }
}

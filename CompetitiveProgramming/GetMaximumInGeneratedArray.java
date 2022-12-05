public class GetMaximumInGeneratedArray {
    public static void main(String[] args) {

    }
    public int getMaximumGenerated(int n) {
        if(n==0)
            return 0;
        int[] nums = new int[3*n+1];
        int max = 1;
        nums[0] = 0;
        nums[1] = 1;
        for(int i=1;i<=n;i++){
            nums[2*i] = nums[i];
            nums[2*i +1] = nums[i] + nums[i+1];
            max = Math.max(max,nums[i]);
        }
        return max;
    }

}

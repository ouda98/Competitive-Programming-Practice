public class SumOfAbsoluteDifferencesInASortedArray {
    public static void main(String[] args) {

    }
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] result = new int[nums.length];
        int rightSum =0;
        int leftSum = 0;
        for(int n: nums)
            rightSum+=n;
        for(int i=0;i<nums.length;i++){
            rightSum-=nums[i];
            leftSum+= (i==0)?0:nums[i-1];
            result[i] = (rightSum - (nums[i] * (nums.length-1-i))) + ((nums[i]*i) - leftSum);
        }
        return result;
    }
}

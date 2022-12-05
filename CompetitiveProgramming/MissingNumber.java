public class MissingNumber {
    public static void main(String[] args) {

    }
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+= nums[i];
        }
        int total = ((nums.length+1)*(nums.length))/2 - sum;
        return total;
    }
}

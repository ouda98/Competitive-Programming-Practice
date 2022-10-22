public class MaxConsecutiveOnes {
    public static void main(String[] args) {

    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for(int n: nums){
            if(n ==1)
                count++;
            else{
                max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(count, max);
    }
}

package LintCodeFacebookQuestions;

public class TotalHammingDistance {
    public static void main(String[] args) {
        int[] arr = {4, 14, 2};
        totalHammingDistance(arr);

    }
    public static int totalHammingDistance(int[] nums) {
        // Write your code here
        int count = 0;
        for(int i=0;i<32;i++){
            int ones =0;
            for(int j=0;j<nums.length;j++){
                ones+= (nums[j] >> i) & 1;
            }
            count+= ones *(nums.length - ones);
        }
        return count;
    }
}

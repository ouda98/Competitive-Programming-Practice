import java.util.Arrays;

public class LongestSubsequenceWithLimitedSum {
    public static void main(String[] args) {

    }
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++)
            nums[i+1]+= nums[i];
        int i=0;
        for(int n : queries)
            queries[i++] = bin(nums, n) +1;
        return queries;
    }
    public int bin(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int res = -1;
        while(left <= right){
            int mid = (right-left)/2 + left;
            if(nums[mid] <= target){
                res = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return res;
    }
}

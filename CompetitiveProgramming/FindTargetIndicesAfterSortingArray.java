import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTargetIndicesAfterSortingArray {
    public static void main(String[] args) {

    }
    // O(n) Solution
    public List<Integer> targetIndices(int[] nums, int target) {
        int count = 0;
        int lessThan = 0;
        for(int n: nums){
            if(n == target)
                count++;
            else if(n < target)
                lessThan++;
        }
        List<Integer> res = new ArrayList<>();
        while(count>0){
            res.add(lessThan++);
            count--;
        }
        return res;
    }

    // O(n log(n)) Solution
    public List<Integer> targetIndices1(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        int ind = -1;
        while(left<=right){
            int mid = (right-left)/2 +left;
            if(nums[mid] == target){
                ind = mid;
                right = mid-1;
            }else if(nums[mid] < target)
                left = mid+1;
            else
                right = mid-1;
        }
        List<Integer> res = new ArrayList<>();
        while(ind<nums.length && ind>=0){
            if(nums[ind] == target)
                res.add(ind++);
            else
                break;
        }
        return res;
    }
}

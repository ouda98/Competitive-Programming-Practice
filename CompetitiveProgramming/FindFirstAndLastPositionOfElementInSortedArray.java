import java.util.ArrayList;
import java.util.List;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {

    }
    public List<Integer> searchRange(List<Integer> nums, int target) {
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = nums.size()-1;
        int subResultStart = -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums.get(mid) == target){
                subResultStart = mid;
                right = mid-1;
            }
            else if (nums.get(mid) > target)
                right = mid-1;
            else
                left = mid + 1;
        }
        left = 0;
        right = nums.size()-1;
        int subResultEnd = -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums.get(mid) == target){
                subResultEnd = mid;
                left = mid+1;
            }
            else if (nums.get(mid) > target)
                right = mid-1;
            else
                left = mid + 1;
        }
        result.add(subResultStart);
        result.add(subResultEnd);
        return result;
    }
}

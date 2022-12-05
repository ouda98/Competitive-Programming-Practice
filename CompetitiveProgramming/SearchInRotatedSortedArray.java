public class SearchInRotatedSortedArray {
    public static void main(String[] args) {

    }
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = (right - left)/2 + left;
            if(nums[mid] == target)
                return mid;
            if(nums[left]<=nums[mid]){
                if(target>=nums[left] && target<= nums[mid])
                    right = mid-1;
                else
                    left = mid+1;
            }else{
                if (target <= nums[right] && target >= nums[mid])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }
}

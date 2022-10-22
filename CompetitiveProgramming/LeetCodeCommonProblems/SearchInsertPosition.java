package LeetCodeCommonProblems;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int pos = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
                pos = mid;
            } else {
                end = mid - 1;
            }
        }
        return pos + 1;

    }
}

package LeetCodeCommonProblems;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int r = removeDuplicates(arr);
        System.out.println(r);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;

        int old = nums[0];
        int shifts = 0;
        int i = 1;
        for (; i < nums.length; i++) {
            if (old == nums[i]) {
                shifts++;
            } else {
                old = nums[i];
                nums[i - shifts] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return i - shifts;
    }
}

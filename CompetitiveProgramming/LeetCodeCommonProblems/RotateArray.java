package LeetCodeCommonProblems;

import java.util.Arrays;
import java.util.LinkedList;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {-1,-100,3,99};
        int k = 3;
        rotate(arr, k);
    }

    public static void rotate(int[] nums, int k) {
        if (nums.length == 0)
            return;
        k = k % nums.length;
        if (k == 0)
            return;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k , nums.length-1);
        System.out.println(Arrays.toString(nums));

    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

}

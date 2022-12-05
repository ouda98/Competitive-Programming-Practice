import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {

    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subResult = new ArrayList<>();
        int previous = -1000000;
        for(int i=0;i<nums.length-2;i++){
            if(nums[i] == previous)
                continue;
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                if(nums[i] + nums[left]+ nums[right] == 0){
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    int l = nums[left];
                    while(left< nums.length && nums[left]==l)
                        left++;
                    int r = nums[right];
                    while(right>= 0 && nums[right]==r)
                        right--;
                }else if(nums[i] + nums[left]+ nums[right] < 0)
                    left++;
                else
                    right--;
            }
            previous = nums[i];
        }
        return result;
    }
}

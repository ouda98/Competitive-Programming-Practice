import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args) {

    }
    // Solution 1 TC = O(nlog(n)) SC = O(1)
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    //Solution 2 TC = O(n) SC = O(1)
    public int majorityElement(int[] nums) {
        int result = 0;
        int count = 0;
        for(int i : nums){
            if(count == 0){
                result = i;
                count++;
            }
            else if(i == result)
                count++;
            else if(i != result)
                count--;
        }
        return result;
    }

}

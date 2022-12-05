public class RearrangeArrayElementsBySign {
    public static void main(String[] args) {

    }
    public int[] rearrangeArray(int[] nums) {
        int i=0;
        int j = nums.length-1;
        int left = 0;
        int right = nums.length-1;
        int [] res = new int[nums.length];
        while(i<nums.length){
            if(nums[i]>0){
                res[left] = nums[i];
                left+=2;
            }
            if(nums[j]<0){
                res[right] = nums[j];
                right-=2;
            }
            i++;
            j--;
        }
        return res;
    }
}

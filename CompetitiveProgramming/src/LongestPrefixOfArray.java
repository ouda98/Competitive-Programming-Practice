public class LongestPrefixOfArray {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1};
        int x = 2;
        int y = 10;
        int r =LongestPrefix(x,y,nums);
        System.out.println(r);
    }
    public static int LongestPrefix(int X, int Y, int[] nums) {
        // write your code here
        int pos = -1;
        int xs =0;
        int ys = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==X)
                xs++;
            if(nums[i]==Y)
                ys++;
            if(xs>0 && ys>0 && xs==ys)
                pos = i;
        }
        return pos;
    }
}

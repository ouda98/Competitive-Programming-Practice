package LintCodeFacebookQuestions;

public class ThirdMaximumNumber {
    public static void main(String[] args) {
        int [] nums = {1,2,-2147483648};
        System.out.println(thirdMax(nums));
    }
    public static int thirdMax(int[] nums) {
        // Write your code here.
        if(nums.length==0)
            return 0;
        int first =-1;
        int second = -1;
        int third = -1;
        for(int i : nums){
            if(i==first || i == second || i == third)
                continue;
            else if(first == -1 || i>first){
                third = second;
                second = first;
                first = i;

            }
            else if(second == -1 ||i>second){
                third = second;
                second = i;
            }
            else if (third == -1 ||i>third)
                third = i;

        }
        if(third!=-1)
            return third;
        return first;
    }

}

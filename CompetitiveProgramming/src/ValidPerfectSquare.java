public class ValidPerfectSquare {
    public static void main(String[] args) {
        int r = 1000000;
        isPerfectSquare(r);
    }
    public static boolean isPerfectSquare(int num) {
        // write your code here
        long left = 0;
        long right = num;
        while(left<=right){
            long mid = left + (right - left)/2;
            if(mid*mid == num)
                return true;
            if(mid*mid < num)
                left = mid+1;
            else
                right = mid-1;
        }
        return false;
    }
}

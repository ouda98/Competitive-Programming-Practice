public class Sqrtx {
    public static void main(String[] args) {

    }
    public int mySqrt(int x) {
        int left = 0;
        int right = (int) 46340;
        int result = 0;
        int mid;
        while(left<=right){
            mid = (right - left)/2 + left;
            if(mid*mid<=x){
                result = mid;
                left = mid+1;
            }else
                right = mid-1;
        }
        return result;
    }
}

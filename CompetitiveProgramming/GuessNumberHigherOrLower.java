public class GuessNumberHigherOrLower {
    public static void main(String[] args) {

    }
    public int guessNumber(int n) {
        int left = 0;
        int right = n;
        while(left <= right){
            int mid = (right - left)/2 + left;
            if(guess(mid) == 0)
                return mid;
            else if(guess(mid) == -1)
                right= mid - 1;
            else
                left = mid + 1;
        }
        return n;
    }
    public int guess(int n){
        return 0;
    }
}

package LeetCodeCommonProblems;

public class ReverseInteger {
    public static void main(String[] args) {
        int x = 123;
        int r = reverse(x);
        System.out.println(r);

    }

    public static int reverse(int x) {
        int res = 0;
        while(x!=0){
            int mod = x%10;
            x /= 10;
            if(res> Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && mod>7))
                return 0;
            if(res< Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10 && mod<-8))
                return 0;
            res = res*10 + mod;
        }
        return res;
    }
}

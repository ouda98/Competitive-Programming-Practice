package Algorithms;

public class Power {
    public static void main(String[] args) {
        int x = 5;
        int power = 5;
        int res = power(x,power);
        System.out.println(res);
    }
    public static int power(int x, int power){
        if(power == 0)
            return 1;

        int temp;
        temp = power(x,power/2);
        if(power%2==0)
            return temp*temp;
        else
            return temp*temp*x;
    }

}

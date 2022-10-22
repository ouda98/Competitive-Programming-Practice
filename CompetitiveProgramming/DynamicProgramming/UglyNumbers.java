package DynamicProgramming;

import java.util.Arrays;

public class UglyNumbers {
    static int[] memo;
    static int pos = 2;

    public static void main(String[] args) {
        int n = 68;
        memo = new int [n];

        int r =calculateUgly(n);

        System.out.println(Arrays.toString(memo));
        System.out.println(r);

    }

    private static int calculateUgly(int n) {
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        memo[0] = 1;
        int m2 = 2;
        int m3 = 3;
        int m5 = 5;
        int next=0;
        for(int i=1;i<n;i++){
            next = Math.min(m2,Math.min(m3,m5));
            memo[i]=next;

            if(next == m2){
                i2++;
                m2 = memo[i2]*2;
            }
            if(next == m3){
                i3++;
                m3 = memo[i3]*3;
            }
            if(next == m5){
                i5++;
                m5 = memo[i5]*5;
            }
        }
        return next;

    }
}

package DynamicProgramming;

import java.math.BigInteger;
import java.util.Arrays;

public class NthCatalanNumber {
    static BigInteger[] memo;
    public static void main(String[] args) {
        int n = 5;
        memo = new BigInteger[n+1];
        Arrays.fill(memo,BigInteger.ZERO);
        memo[0]=BigInteger.ONE;
        memo[1]=BigInteger.ONE;
        catalan(new BigInteger(n+""));
        System.out.println(Arrays.toString(memo));

//        System.out.println(memo[n.intValueExact()]);
    }

    private static BigInteger catalan(BigInteger n) {
        if(!memo[n.intValueExact()].equals(BigInteger.ZERO))
            return memo[n.intValueExact()];

        for(int i=0;i<n.intValueExact();i++){
            BigInteger w = new BigInteger(i+"");
            BigInteger s = catalan(w).multiply(catalan(n.subtract(w).subtract(BigInteger.ONE)));
            memo[n.intValue()] = memo[n.intValue()].add(s);
        }
        return memo[n.intValueExact()];
    }
}

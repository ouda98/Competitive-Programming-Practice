package DynamicProgramming;

public class NthFibonacciNumber {
    static long[] memo;
    static int pos = 0;
    static long orignalN;

    public static void main(String[] args) {
        long n = 656;
        orignalN = n - 1;
        memo = new long[(int) (n + 1)];
        pos = 0;
        long r = fib(n);
        System.out.println(memo[(int) orignalN]);
    }

    private static long fib(long n) {
        if (n == 0 || n == 1)
            return memo[(int) n] = 1;
        if (memo[(int) n] != 0)
            return memo[(int) n];

        return memo[(int) n] = (fib(n - 1) + fib(n - 2))% 1000000007;


    }
}

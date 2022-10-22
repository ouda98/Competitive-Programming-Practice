package LintCodeBacktracking;

public class CountNumbersWithUniqueDigits {
    public static void main(String[] args) {
        int n = 8;
        int s = countNumbersWithUniqueDigits(n);
        System.out.println(s);
    }
    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int sum = 10;
        int pre = 9;
        for (int i = 2; i <= n; i++) {
            pre = pre * (11 - i);
            sum += pre;
        }
        return sum;
    }
}

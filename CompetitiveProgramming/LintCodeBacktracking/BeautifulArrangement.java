package LintCodeBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BeautifulArrangement {
    static int count = 0;

    public static void main(String[] args) {
        int N = 4;
        helper(new int[N], N);
        System.out.println(count);
    }

    private static void helper(int[] res, int N) {
        if (N == 0) {
            count++;
            return;
        }

        for (int i = 0; i < res.length; ++i) {
            if (res[i] == 0 && (N % (i + 1) == 0 || (i + 1) % N == 0)) {
                res[i] = N;
                helper(res, N - 1);
                res[i] = 0;
            }
        }
    }
}

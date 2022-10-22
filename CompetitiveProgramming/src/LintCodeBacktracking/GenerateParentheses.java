package LintCodeBacktracking;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
    static List<String> s;

    public static void main(String[] args) {
        s = new LinkedList<>();
        solve(0, 0, "", 3);
        System.out.println("here " + s);
    }

    private static void solve(int open, int close, String r, int n) {
        if (open + close == n * 2) {
            System.out.println(r);
            s.add(r);
            return;
        }
        if (open < n)
            solve(open + 1, close, r + "(", n);
        if (close < n && close<open)
            solve(open, close + 1, r + ")", n);
    }
}

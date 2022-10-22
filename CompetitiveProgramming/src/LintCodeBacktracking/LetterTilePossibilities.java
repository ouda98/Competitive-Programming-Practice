package LintCodeBacktracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LetterTilePossibilities {
    static HashSet<String> set;
    static int counter;
    static int[] factorial;

    public static void main(String[] args) {
        factorial = new int[8];
        int sum = 1;
        for (int i = 1; i < factorial.length; i++)
            factorial[i] = sum *= i;

        set = new HashSet<>();
        counter = 0;
        String tiles = "CDC";
        solve(0, tiles, "");
        System.out.println(counter);

    }

    private static void solve(int idx, String tiles, String s) {
        if (s.length() != 0 && !set.contains(s)) {
            permutation("",s);

            HashMap<Character, Integer> c = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (c.containsKey(s.charAt(i)))
                    c.put(s.charAt(i), c.get(s.charAt(i)) + 1);
                else
                    c.put(s.charAt(i), 1);
            }
            int total = factorial[s.length()];
            for(Character t : c.keySet())
                total/=factorial[c.get(t)];
            counter+=total;
        }
        if (idx == tiles.length())
            return;
        solve(idx + 1, tiles, s + tiles.charAt(idx));
        solve(idx + 1, tiles, s);
    }
    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0)
            set.add(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }
}

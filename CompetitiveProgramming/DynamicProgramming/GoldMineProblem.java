package DynamicProgramming;

import java.util.Arrays;

public class GoldMineProblem {
    static int[][] memo;
    static int[] dr = {-1, 1, 0};
    static int[] dc = {-1, -1, -1};

    public static void main(String[] args) {
        int n = 3;
        int m = 4;
        int[][] M = {{1, 3, 3,4},
                {2, 1, 4,2},
                {0, 6, 4,1}};

        memo = new int[n][m];
        int max = 0;
        for (int j = 0; j < M.length; j++)
            Arrays.fill(memo[j], -1);
        for (int i = 0; i < memo.length; i++) {

            max = Math.max(max, mine(M, i,m - 1));
        }

        System.out.println(max);

    }

    private static int mine(int[][] M, int x, int y) {

        if (y == 0)
            return memo[x][y] = M[x][y];
        if (memo[x][y] != -1)
            return memo[x][y];

        int tr = 0;
        int r = 0;
        int br = 0;
        if (x + dr[0] >= 0 && x + dr[0] < M.length && y + dc[0] >= 0)
            tr = M[x][y] + mine(M, x + dr[0], y + dc[0]);

        if (x + dr[2] >= 0 && x + dr[2] < M.length && y + dc[2] >= 0)
            r = M[x][y] + mine(M, x + dr[2], y + dc[2]);

        if (x + dr[1] >= 0 && x + dr[1] < M.length && y + dc[1] >= 0)
            br = M[x][y] + mine(M, x + dr[1], y + dc[1]);

        return memo[x][y] = Math.max(tr, Math.max(r, br));

    }

}

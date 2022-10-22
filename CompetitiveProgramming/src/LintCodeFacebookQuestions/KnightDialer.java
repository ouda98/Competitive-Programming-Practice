package LintCodeFacebookQuestions;

import java.util.Arrays;

public class KnightDialer {
    public class Solution {

        static int [][] dial;
        static int[] dr = {-1, -1, -2, -2, 1,  1,  2, 2};
        static int[] dc = {-2,  2, -1,  1, -2, 2, -1, 1};
        static int[][][] memo;
        public int knightDialer(int N) {
            //
            int sum =0;
            memo = new int[5005][5][5];
            for(int i=0;i<memo.length;i++)
                for(int j=0;j<memo[0].length;j++)
                    Arrays.fill(memo[i][j],-1);
            for(int i=0;i<4;i++)
                for(int j=0;j<3;j++){
                    if(i==3 && (j==0 || j==2))
                        continue;
                    sum =  (sum+solve(i,j,N)) % (int)(((int) 1e9)+7);

                }
            return (int)sum;
        }

        public static int solve(int ox, int oy,int N){
            if(N==1)
                return 1;

            if(memo[N][ox][oy]!=-1)
                return memo[N][ox][oy];

            int result =0;
            int x,y;
            for(int k=0;k<dr.length;k++){
                x = ox + dr[k];
                y = oy + dc[k];
                if(can(x,y)){
                    result=(result + solve(x,y,N-1)) % (((int) 1e9)+7);
                }

            }
            return memo[N][ox][oy] = result;
        }
        public static boolean can(int x, int y){
            if(x>=0 && x<=3 && y>=0 && y<=2)
                if(x==3 && (y==0 || y==2))
                    return false;
                else
                    return true;
            return false;
        }
    }
}

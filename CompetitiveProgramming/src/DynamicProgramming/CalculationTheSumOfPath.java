package DynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;

public class CalculationTheSumOfPath {
    public static void main(String[] args) {
        int l = 1896;

        int w = 1771;
        Point[] points = new Point[3];
        points[0] = new Point(430,378);
        points[1] = new Point(1062,1020);
        points[2] = new Point(1896,1771);
        long r = calculationTheSumOfPath(l,w,points);
        System.out.println(r);
    }
    static HashSet<String> set;
    static long [][][]dp;
    public static long calculationTheSumOfPath(int l, int w, Point[] points) {
        // Write your code here
        set = new HashSet<>();
        dp = new long[l + 1][w + 1][4];
        for(int i=0;i<dp.length;i++)
            for(int j=0;j<dp[i].length;j++)
            Arrays.fill(dp[i][j],-1);
        for(Point p: points)
            set.add(p.x+" "+p.y);
        int counter = 3;
        if(set.contains(l+" "+w))
            counter--;
        return solve(l,w,counter);
    }

    private static long solve(int l, int w, int counter) {
        if(l==1 && w==1 && counter==0)
            return 1;

        if(l==1 && w==1 && counter >0)
            return 0;

        if(dp[l][w][counter]!=-1) {
            return dp[l][w][counter];
        }

        long a = 0;
        if(l>1){
            if(set.contains(l-1+" "+w))
                a = (a%((int)1e9+7) + solve(l-1, w,counter-1)%((int)1e9+7))%((int)1e9+7);
            else
                a = (a%((int)1e9+7) + solve(l-1, w,counter)%((int)1e9+7))%((int)1e9+7);
        }
        if(w>1){
            if(set.contains(l+" "+(w-1)))
                a = (a%((int)1e9+7) + solve(l, w-1,counter-1)%((int)1e9+7))%((int)1e9+7);
            else
                a = (a%((int)1e9+7) + solve(l, w-1,counter)%((int)1e9+7))%((int)1e9+7);
        }
        return dp[l][w][counter] = a%((int)1e9+7);
    }

    static class Point {
        int x;
        int y;
        Point() {
            x = 0;
            y = 0;
        }
        Point(int a, int b) {
            x = a;
            y = b;
        }
        @Override
        public boolean equals(Object other){
            Point o = (Point) other;
            return this.x == o.x && this.y == o.y;
        }
    }

}

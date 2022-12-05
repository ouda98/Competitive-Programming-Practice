public class MinimumTimeVisitingAllPoints {
    public static void main(String[] args) {

    }
    public int minTimeToVisitAllPoints(int[][] points) {
        int sum = 0;
        for(int i= 1;i<points.length;i++){
            sum+= Math.max(Math.abs(points[i-1][0] - points[i][0]), Math.abs(points[i-1][1] - points[i][1]));
        }
        return sum;
    }
}

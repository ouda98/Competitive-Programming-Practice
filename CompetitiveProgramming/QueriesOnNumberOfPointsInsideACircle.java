public class QueriesOnNumberOfPointsInsideACircle {
    public static void main(String[] args) {

    }
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        int count;
        for(int i=0;i<queries.length;i++){
            count = 0;
            for(int j=0;j<points.length;j++){
                if(Math.sqrt(Math.pow(queries[i][0]-points[j][0],2) + Math.pow(queries[i][1]-points[j][1],2))<=queries[i][2])
                    count++;
            }
            res[i] = count;
        }
        return res;
    }
}

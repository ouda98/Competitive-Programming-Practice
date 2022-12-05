public class LargestTriangleArea {
    public static void main(String[] args) {

    }
    public double largestTriangleArea(int[][] points) {
        double max = 0;
        for(int i=0;i<points.length-2;i++)
            for(int j=i+1;j<points.length-1;j++)
                for(int k=j+1;k<points.length;k++)
                    max = Math.max(max, Math.abs(calc(points[i],points[j],points[k])));
        return max;
    }
    public double calc(int[] i, int[] j, int[] k){
        return 0.5 *Math.abs(i[0]*(j[1]-k[1])+j[0]*(k[1]-i[1])+k[0]*(i[1]-j[1]));
    }
}

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {

    }
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int[] point: points){
            pq.add(new Pair(Math.sqrt((point[0]*point[0])+(point[1]*point[1])),point));
        }
        int i = 0;
        while(k-->0)
            result[i++] = pq.poll().p;
        return result;
    }
    public class Pair implements Comparable{
        double x;
        int[] p;
        public Pair(double x, int[] p){
            this.x = x;
            this.p = new int[]{p[0],p[1]};
        }
        public int compareTo(Object o){
            return Double.compare(this.x, ((Pair)o).x);
        }
    }
}

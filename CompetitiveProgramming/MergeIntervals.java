import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    public static void main(String[] args) {

    }
    public int[][] merge(int[][] intervals) {
        Pair[] p = new Pair[intervals.length];
        int j=0;
        for(int[] interval : intervals)
            p[j++] = new Pair(interval[0],interval[1]);
        Arrays.sort(p);
        Pair pair = p[0];
        j=0;
        int[][] result = new int[intervals.length][2];
        for(int i=1;i<p.length;i++){
            if((pair.start <= p[i].start && pair.end >= p[i].start) ||
                    (pair.end >= p[i].end && pair.start <= p[i].end))
                pair = new Pair(Math.min(pair.start, p[i].start),Math.max(pair.end,p[i].end));
            else{
                result[j++] = new int[]{pair.start, pair.end};
                pair = p[i];
            }
        }
        result[j++] = new int[]{pair.start, pair.end};
        return Arrays.copyOfRange(result, 0, j);
    }
    public class Pair implements Comparable{
        int start;
        int end;
        public Pair(int start, int end){
            this.start = start;
            this.end = end;
        }
        public int compareTo(Object o){
            if(Integer.compare(this.start, ((Pair)o).start) == 0)
                return Integer.compare(this.end, ((Pair)o).end);
            return Integer.compare(this.start, ((Pair)o).start);
        }
    }
}

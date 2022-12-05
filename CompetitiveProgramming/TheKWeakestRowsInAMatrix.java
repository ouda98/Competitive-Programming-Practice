import java.util.ArrayList;
import java.util.Collections;

public class TheKWeakestRowsInAMatrix {
    public static void main(String[] args) {

    }
    public int[] kWeakestRows(int[][] mat, int k) {
        ArrayList<Pair> res = new ArrayList<>();
        int row = 0;
        for(int[] n : mat)
            res.add(bin(n,row++));
        int[] result = new int[k];
        Collections.sort(res);
        for(int i=0;i<k;i++)
            result[i] = res.get(i).r;
        return result;
    }
    public Pair bin(int[] nums, int row){
        int left = 0;
        int right = nums.length-1;
        int index = -1;
        while(left<=right){
            int mid = (right - left)/2 + left;
            if(nums[mid] >= 1){
                index = mid;
                left = mid+1;
            }else
                right = mid-1;
        }
        return new Pair(row, index +1);
    }
    public class Pair implements Comparable{
        int r;
        int c;
        public Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
        public int compareTo(Object o){
            if(Integer.compare(this.c, ((Pair)o).c) == 0)
                return Integer.compare(this.r, ((Pair)o).r);
            return Integer.compare(this.c, ((Pair)o).c);
        }
    }
}

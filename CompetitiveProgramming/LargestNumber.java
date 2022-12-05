import java.util.ArrayList;
import java.util.Collections;

public class LargestNumber {
    public static void main(String[] args) {

    }
    public String largestNumber(int[] nums) {
        ArrayList<Pair> list = new ArrayList<>();
        for(int n : nums){
            list.add(new Pair(n));
        }
        Collections.sort(list, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(Pair p : list)
            sb.append(p.x);
        if(sb.toString().charAt(0) == '0')
            return "0";
        return sb.toString();
    }
    public class Pair implements Comparable{
        int x;
        public Pair(int x){
            this.x = x;
        }
        public int compareTo(Object o){
            String s = ""+this.x+((Pair)o).x;
            String r = ""+((Pair)o).x+this.x;
            return s.compareTo(r);
        }
    }
}

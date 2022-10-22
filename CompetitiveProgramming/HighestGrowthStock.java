import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighestGrowthStock {
    public class Solution {
        /**
         * @param Stock: Stock information
         * @return: return id
         */
        public String highestGrowth(List<List<String>> Stock) {
            // Write your code here
            List<Pair> r = new ArrayList<>();
            for(int i = 0; i<Stock.size();i++){
                String id = Stock.get(i).get(0);
                double rate = Double.parseDouble(Stock.get(i).get(1)) / Double.parseDouble(Stock.get(i).get(2));
                r.add(new Pair(id,rate));
            }
            Collections.sort(r);
            return r.get(0).id;
        }

        public static class Pair implements Comparable<Pair>{
            String id;
            double rate;
            public Pair(String id, double rate){
                this.id = id;
                this.rate = rate;
            }
            public int compareTo(Pair other){
                return Double.compare(this.rate, other.rate);
            }
        }
    }
}

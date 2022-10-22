import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class SmartSale {
    public class Solution {
        /**
         * @param ids: ID number of items
         * @param m: The largest number of items that can be remove
         * @return: the result of the min item
         */
        public int minItem(List<Integer> ids, int m) {
            // write your code here
            HashMap<Integer,Integer> map = new HashMap<>();
            int counter =0;
            for(Integer i : ids){
                if(map.containsKey(i))
                    map.put(i,map.get(i)+1);
                else{
                    counter++;
                    map.put(i, 1);
                }
            }
            PriorityQueue<Pair> q = new PriorityQueue<>();
            for(Integer num : map.keySet())
                q.add(new Pair(num,map.get(num)));
            while(!q.isEmpty()){
                if(m>=q.peek().count){
                    m-= q.peek().count;
                    q.poll();
                }else{
                    break;
                }
            }
            return q.size();

        }
        public static class Pair implements Comparable<Pair>{
            int n;
            int count;
            public Pair(int n, int count){
                this.n = n;
                this.count = count;
            }
            public int compareTo(Pair other){
                return this.count - other.count;
            }
        }
    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static void main(String[] args) {

    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums)
            map.put(num,map.getOrDefault(num, 0)+1);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> set :
                map.entrySet()) {
            if(pq.size() == k && set.getValue() > pq.peek().f){
                pq.poll();
                pq.add(new Pair(set.getKey(),set.getValue()));
            }else if (pq.size()<k)
                pq.add(new Pair(set.getKey(),set.getValue()));
        }
        int[] result = new int[k];
        int i=0;
        while(!pq.isEmpty())
            result[i++] = pq.poll().x;
        return result;
    }

    public class Pair implements Comparable{
        int x;
        int f;
        public Pair(int x, int f){
            this.x = x;
            this.f = f;
        }
        public int compareTo(Object o){
            return Integer.compare(this.f, ((Pair)o).f);
        }
    }
}

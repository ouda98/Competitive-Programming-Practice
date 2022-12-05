import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReduceArraySizeToTheHalf {
    public static void main(String[] args) {

    }
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
            pq.add(set.getValue());
        }
        int res = 0;
        int sum = 0;
        while (sum < arr.length / 2) {
            sum += pq.poll();
            res++;
        }
        return res;
    }
}

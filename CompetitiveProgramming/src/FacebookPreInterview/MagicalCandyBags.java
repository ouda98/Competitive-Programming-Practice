package FacebookPreInterview;

import java.util.Collections;
import java.util.PriorityQueue;

public class MagicalCandyBags {
    public static void main(String[] args) {
        int[] arr = {2, 1, 7, 4, 2};
        System.out.println(maxCandies(arr,3));

    }
    static int maxCandies(int[] arr, int k) {
        // Write your code here
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: arr) {
            queue.add(i);
        }
        int sum =0;
        while(k-->0){
            sum += queue.peek();
            queue.add(queue.poll()/2);
        }
        return sum;
    }
}

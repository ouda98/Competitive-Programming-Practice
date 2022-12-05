import java.util.PriorityQueue;

public class SmallestNumberInInfiniteSet {
    public static void main(String[] args) {

    }
    class SmallestInfiniteSet {
        int pointer;
        PriorityQueue<Integer> pq;

        public SmallestInfiniteSet() {
            pointer = 1;
            pq = new PriorityQueue<>();
        }

        public int popSmallest() {
            if(!pq.isEmpty())
                return pq.poll();
            return pointer++;
        }

        public void addBack(int num) {
            if(pointer>num && !pq.contains(num))
                pq.add(num);
        }
    }
}

import java.util.Collections;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public static void main(String[] args) {

    }
    public String frequencySort(String s) {
        int [] rep = new int[80];
        for(int i=0;i<s.length();i++){
            rep[s.charAt(i)-'0']++;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<rep.length;i++){
            if(rep[i]>0)
                pq.add(new Pair((char) ('0'+i),rep[i]));
        }
        StringBuilder sb = new StringBuilder();
        char ch;
        int r;
        while(!pq.isEmpty()){
            ch = pq.peek().c;
            r = pq.poll().count;
            while(r-->0)
                sb.append(ch+"");
        }
        return sb.toString();
    }
    public class Pair implements Comparable{
        char c;
        int count;
        public Pair(char c, int count){
            this.c = c;
            this.count = count;
        }
        public int compareTo(Object o){
            return Integer.compare(count, ((Pair)o).count);
        }
    }
}

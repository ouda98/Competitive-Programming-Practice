import java.util.ArrayList;
import java.util.Collections;

public class SortingTheSentence {
    public static void main(String[] args) {

    }
    public String sortSentence(String s) {
        String[] array = s.split(" ");
        ArrayList<Pair> list = new ArrayList<>();
        for(int i=0;i<array.length;i++)
            list.add(new Pair((int)array[i].charAt(array[i].length()-1),array[i].substring(0,array[i].length()-1)));
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(Pair p : list)
            sb.append(p.s+" ");

        return sb.toString().substring(0,sb.toString().length()-1);
    }
    public class Pair implements Comparable{
        int x;
        String s;
        public Pair(int x, String s){
            this.x = x;
            this.s = s;
        }
        public int compareTo(Object o){
            return Integer.compare(x,((Pair)o).x);
        }
    }
}

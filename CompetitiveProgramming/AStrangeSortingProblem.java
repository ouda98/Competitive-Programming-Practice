import java.util.*;

public class AStrangeSortingProblem {
    public static void main(String[] args) {
        List<Integer> map = new ArrayList<>();
        map.add(3);
        map.add(5);
        map.add(4);
        map.add(6);
        map.add(2);
        map.add(7);
        map.add(9);
        map.add(8);
        map.add(0);
        map.add(1);
        List<String> s = new ArrayList<>();
        s.add("990");
        s.add("332");
        s.add("32");
        s.add("333333332");
        List<String> r = strangeSort(map, s);
        System.out.println(Arrays.toString(r.toArray()));
    }
    public static List<String> strangeSort(List<Integer> mapping, List<String> nums) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<mapping.size();i++)
            map.put(mapping.get(i),i);
        List<Pair> s = new ArrayList<>();
        for(int i=0;i<nums.size();i++){
            String num = nums.get(i);
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<num.length();j++){
                if(map.get(num.charAt(j)-'0') != 0 || (map.get(num.charAt(j)-'0') == 0 && sb.length()!=0))
                    sb.append(map.get(num.charAt(j)-'0'));
            }
            s.add(new Pair(sb.toString(),num));
        }
        Collections.sort(s);
        List<String> result = new ArrayList<>();
        for(Pair p : s) {
            System.out.println(p.in+" "+ p.encode);
            result.add(p.in);
        }
        return result;
    }

    public static class Pair implements Comparable<Pair>{
        String encode;
        String in;
        public Pair(String encode, String in){
            this.encode = encode;
            this.in = in;
        }
        public int compareTo(Pair other){
            if(this.encode.length() != other.encode.length())
                return this.encode.length() - other.encode.length();
            return this.encode.compareTo(other.encode);
        }
    }
}

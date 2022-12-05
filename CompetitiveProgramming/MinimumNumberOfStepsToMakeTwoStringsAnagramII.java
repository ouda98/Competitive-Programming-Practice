import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfStepsToMakeTwoStringsAnagramII {
    public static void main(String[] args) {

    }
    public int minSteps(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            res++;
        }
        for(int i=0;i<t.length();i++){
            if(!map.containsKey(t.charAt(i)))
                res++;
            else{
                map.put(t.charAt(i),map.get(t.charAt(i))-1);
                res--;
                if(map.get(t.charAt(i)) == 0)
                    map.remove(t.charAt(i));
            }
        }
        return res;
    }
}

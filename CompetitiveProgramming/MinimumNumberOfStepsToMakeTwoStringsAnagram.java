import java.util.HashMap;

public class MinimumNumberOfStepsToMakeTwoStringsAnagram {
    public static void main(String[] args) {

    }
    public int minSteps(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        int res = 0;
        for(int i=0;i<t.length();i++){
            if(!map.containsKey(t.charAt(i)))
                res++;
            else{
                map.put(t.charAt(i),map.get(t.charAt(i))-1);
                if(map.get(t.charAt(i)) == 0)
                    map.remove(t.charAt(i));
            }
        }
        return res;
    }
}

package GeeksForGeeks;

import java.util.HashMap;
import java.util.Map;

public class SecondMostRepeatedStringInASequence {
    public static void main(String[] args) {

    }
    String secFrequent(String arr[], int N)
    {
        // your code here
        int max = 0;
        Map<String, Integer> map = new HashMap<>();
        for(String s : arr){
            map.put(s, map.getOrDefault(s,0)+1);
            max = Math.max(max,map.get(s));
        }
        int second = -1;
        String result = "";
        for (Map.Entry<String, Integer> set :
                map.entrySet()) {
            if(set.getValue()<max && set.getValue()>second){
                result = set.getKey();
                second = set.getValue();
            }
        }
        return result;

    }
}

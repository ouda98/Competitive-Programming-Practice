package LeetCodeCommonProblems;

import java.util.HashMap;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),s.length()+4);
            else
                map.put(s.charAt(i),i);
        }
        int min = Integer.MAX_VALUE;
        for(Character i : map.keySet()){
            if(map.get(i)>s.length())
                continue;
            min = Math.min(min, map.get(i));
        }
        return (min == Integer.MAX_VALUE)?-1:min;
    }
}

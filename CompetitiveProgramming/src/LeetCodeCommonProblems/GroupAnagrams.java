package LeetCodeCommonProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String value = sort(strs[i]);
            if(!map.containsKey(value))
                map.put(value,new ArrayList<>());
            map.get(value).add(strs[i]);
        }
        List<List<String>> list = new ArrayList<>();
        for(String key: map.keySet()){
            list.add(map.get(key));
        }
        return list;

    }
    public String sort(String in){
        char[] arr = in.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}

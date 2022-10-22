import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String a, String b) {
        ArrayList<String> res = new ArrayList<>();
        Map<String,Integer> table = new HashMap<>();
        String[] aSplit = a.split(" ");
        String[] bSplit = b.split(" ");
        for(String s: aSplit){
            if(!table.containsKey(s)){
                table.put(s, 1);
            }else{
                table.put(s, table.get(s)+1);
            }
        }
        for(String s: bSplit){
            if(!table.containsKey(s)){
                table.put(s, 1);
            }else{
                table.put(s, table.get(s)+1);
            }
        }
        for (Map.Entry<String, Integer> set :
                table.entrySet()) {
            if(set.getValue() ==1)
                res.add(set.getKey());
        }
        return res.toArray(new String[res.size()]);
    }
}

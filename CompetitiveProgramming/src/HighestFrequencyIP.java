import java.util.HashMap;
import java.util.Map;

public class HighestFrequencyIP {
    public static void main(String[] args) {

    }
    public String highestFrequency(String[] ipLines) {
        // Write your code here
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<ipLines.length;i++){
            map.put(ipLines[i],map.getOrDefault(ipLines[i], 0)+1);
        }
        int max = 0;
        String result = "";
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue()>max){
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
}

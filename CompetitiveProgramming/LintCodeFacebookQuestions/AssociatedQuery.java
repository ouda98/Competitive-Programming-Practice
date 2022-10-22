package LintCodeFacebookQuestions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AssociatedQuery {
    public static void main(String[] args) {

    }
    public List<List<String>> getList(List<List<String>> datalist1, List<List<String>> datalist2) {
        // write your code here
        HashMap<String,String> map = new HashMap<>();
        List<List<String>> result = new LinkedList<>();
        for(int i=0;i<datalist1.size();i++){
            map.put(datalist1.get(i).get(0),datalist1.get(i).get(1));
        }

        for(int i=0;i<datalist2.size();i++){
            List<String> subResult = new LinkedList<>();
            String name = map.get(datalist2.get(i).get(0));
            int sum = 0;
            subResult.add(name);
            for(int j=2;j<datalist2.get(i).size();j++){
                if(j%2==0) {
                    subResult.add(datalist2.get(i).get(j));
                    sum += Integer.parseInt(datalist2.get(i).get(j));
                }
            }
            subResult.add(""+sum);
            result.add(subResult);
        }

        return result;
    }

}

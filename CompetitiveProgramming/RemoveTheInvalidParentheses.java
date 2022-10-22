import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveTheInvalidParentheses {
    public static void main(String[] args) {
       String s = "a(b(c(de)fgh)";
       String r = removeParentheses(s);
        System.out.println(r);
    }
    public static String removeParentheses(String s) {
        // write your code here.
        int countOpen = 0;
        List<Character> result = new ArrayList<>();
        List<Integer> pos = new ArrayList();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) =='('){
                countOpen++;
                pos.add(result.size());
            }if(s.charAt(i) == ')'){
                if(countOpen>0)
                    countOpen--;
                else
                    continue;
            }
            result.add(s.charAt(i));
        }
        while(countOpen-->0){
            int remove = pos.get(pos.size()-1);
            result.remove(remove);
            pos.remove(pos.size()-1);
        }
        StringBuilder sb = new StringBuilder();
        for(Character c : result){
            sb.append(c);
        }
        return sb.toString();
    }
//    public static String removeParentheses(String s) {
//        // write your code here.
//        List<Character> list = new ArrayList();
//        for(int i=0;i<s.length();i++){
//            list.add(s.charAt(i));
//        }
//        List<Integer> open = new ArrayList();
//        int countOpen = 0;
//        for(int i=0;i<s.length();i++){
//            if(s.charAt(i) == '('){
//                countOpen++;
//                open.add(i);
//            }
//            if(s.charAt(i) == ')'){
//                if(countOpen==0)
//                    list.remove(i);
//                else
//                    countOpen--;
//            }
//
//        }
//        while(countOpen-->0){
//            int r = open.get(open.size()-1);
//            list.remove(r);
//            open.remove(open.size()-1);
//        }
//        StringBuilder sb = new StringBuilder();
//        for(int i=0;i<list.size();i++)
//            sb.append(list.get(i));
//        return sb.toString();
//    }
}

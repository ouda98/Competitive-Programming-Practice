import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public static void main(String[] args) {

    }
    static List<String> result;
    public List<String> letterCasePermutation(String s) {
        result = new ArrayList<>();
        dfs(s, 0,"");
        return result;
    }
    public void dfs(String s, int pointer, String res){
        if(pointer == s.length()){
            result.add(res);
            return;
        }
        if(isNumber(s.charAt(pointer))){
            dfs(s, pointer+1, res+s.charAt(pointer));
        }else{
            dfs(s, pointer+1, res+(s.charAt(pointer)+"").toLowerCase());
            dfs(s, pointer+1, res+(s.charAt(pointer)+"").toUpperCase());
        }

    }
    public boolean isNumber(char n){
        return n>='0' && n<='9';
    }
}

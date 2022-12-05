import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {

    }
    static List<List<String>> result;
    static List<String> subResult;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        subResult = new ArrayList<>();
        dfs(s);
        return result;
    }
    public void dfs(String s){
        if(s.length() == 0){
            result.add(new ArrayList<>(subResult));
            return;
        }
        for(int i=0;i<s.length();i++){
            if(palindrome(s.substring(0,i+1))){
                subResult.add(s.substring(0,i+1));
                dfs(s.substring(i+1));
                subResult.remove(subResult.size()-1);
            }
        }
    }
    public boolean palindrome(String s){
        int left = 0;
        int right = s.length()-1;
        while(left<=right)
            if(s.charAt(left++) != s.charAt(right--))
                return false;
        return true;
    }
}

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {

    }
    static List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        dfs(n,0,0,"");
        return res;
    }
    public void dfs(int n, int open, int close,String pr){
        if(open == n && close == n && pr.length() == 2*n){
            res.add(pr);
            return;
        }
        if(open < n)
            dfs(n,open+1,close,pr+"(");
        if(open>close)
            dfs(n,open,close+1,pr+")");
    }
}

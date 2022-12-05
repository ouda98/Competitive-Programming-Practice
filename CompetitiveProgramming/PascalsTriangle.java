import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {

    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList r;
        for(int i=1;i<=numRows;i++){
            r = new ArrayList<Integer>();
            for(int j=0;j<i;j++){
                if(i<=2)
                    r.add(1);
                else{
                    if(j==0)
                        r.add(1);
                    else if(j == (i-1))
                        r.add(1);
                    else
                        r.add(result.get(i-2).get(j-1)+result.get(i-2).get(j));
                }
            }
            result.add(r);
        }
        return result;
    }
}

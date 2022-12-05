import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPositiveIntegerSolutionForAGivenEquation {
    public static void main(String[] args) {

    }
    public class CustomFunction{
        public int f(int x, int y){
            return 0;
        }
    };
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=1;i<=1000;i++){
            bin(result, i,customfunction,z);
        }
        return result;
    }
    public void bin(List<List<Integer>> result, int x, CustomFunction customfunction, int z){
        int left = 1;
        int right = 1000;
        while(left<=right){
            int mid = (right-left)/2 + left;
            int r = customfunction.f(x,mid);
            if(r == z){
                result.add(new ArrayList<Integer>(Arrays.asList(x,mid)));
                return;
            }else if(r<z){
                left = mid+1;
            }else
                right = mid-1;
        }
    }
}

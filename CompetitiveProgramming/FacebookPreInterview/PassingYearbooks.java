package FacebookPreInterview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class PassingYearbooks {
    public static void main(String[] args) {
        int []arr = {4,3,2,5,1};
//        int []arr = {2, 1};
//        int []arr = {1, 2};
        System.out.println(Arrays.toString(findSignatureCounts(arr)));
    }
    static int[] findSignatureCounts(int[] arr) {
        // Write your code here
        int [] res = new int[arr.length];
        HashSet<Integer> visited = new HashSet<>();
        for(int k : arr){
            HashSet<Integer> cycle = new HashSet<>();
            while(!visited.contains(k)){
                cycle.add(k);
                visited.add(k);
                k = arr[k-1];
            }
            for(int n : cycle){
                res[n-1] = cycle.size();
            }
        }
        return res;
    }
}

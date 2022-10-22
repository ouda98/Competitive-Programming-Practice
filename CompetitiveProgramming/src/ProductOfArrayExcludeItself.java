import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ProductOfArrayExcludeItself {
    public class Solution {
        /*
         * @param nums: Given an integers array A
         * @return: A long long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
         */
        public List<Long> productExcludeItself(List<Integer> nums) {
            // write your code here
            HashSet<Integer> zeros = new HashSet<>();
            List<Long> result = new ArrayList<>();
            long r = 1;

            for(int i=0;i<nums.size();i++){
                if(nums.get(i) == 0)
                    zeros.add(i);
                else
                    r*= nums.get(i);
            }

            for(int i=0;i<nums.size();i++){
                if(zeros.size() == 0){
                    long s = (long)(r/ nums.get(i));
                    result.add(s);
                }
                else if (zeros.size()==1 && zeros.contains(i)){
                    result.add(r);
                }else
                    result.add((long)0);

            }
            return result;
        }
    }

}

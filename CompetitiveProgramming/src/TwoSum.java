import java.util.HashMap;

public class TwoSum {
    public class Solution {
        /**
         * @param numbers: An array of Integer
         * @param target: target = numbers[index1] + numbers[index2]
         * @return: [index1, index2] (index1 < index2)
         */
        public int[] twoSum(int[] numbers, int target) {
            // write your code here
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i=numbers.length-1;i>0;i--){
                map.put(numbers[i],i);
            }
            for(int i=0;i<numbers.length;i++){
                if(map.containsKey(target-numbers[i]) && map.get(target-numbers[i]) != i){
                    int [] result = {i,map.get(target - numbers[i])};
                    return result;
                }
            }
            return new int[0];
        }
    }
}

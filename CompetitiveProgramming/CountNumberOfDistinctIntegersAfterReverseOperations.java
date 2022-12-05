import java.util.HashSet;

public class CountNumberOfDistinctIntegersAfterReverseOperations {
    public static void main(String[] args) {

    }
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int value;
        for(int n: nums){
            set.add(n);
            value = 0;
            while(n!=0){
                value = value*10+(n%10);
                n/=10;
            }
            set.add(value);
        }
        return set.size();
    }
}

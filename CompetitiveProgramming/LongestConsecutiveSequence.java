import java.util.TreeSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {

    }
    public int longestConsecutive(int[] nums) {
        if(nums.length ==0)
            return 0;
        TreeSet<Integer> set = new TreeSet<>();
        for(int n: nums)
            set.add(n);
        int max = 1;
        int count = 1;
        int value = set.higher(Integer.MIN_VALUE);
        int next = 0;
        while(set.higher(value)!=null){
            next = set.higher(value);
            if(next != value+1)
                count = 0;
            count++;
            value = next;
            if(max< count)
                max = count;
        }
        return max;
    }
}

import java.util.HashSet;

public class FindUniqueBinaryString {
    public static void main(String[] args) {

    }
    static String result;
    static HashSet<String> set;
    public String findDifferentBinaryString(String[] nums) {
        set = new HashSet<>();
        for(String n: nums)
            set.add(n);
        dfs(nums[0].length(), "");
        return result;
    }
    public boolean dfs(int size, String res){
        if(size == 0){
            if(!set.contains(res)){
                result = res;
                return true;
            }
            return false;
        }
        return dfs(size-1, res+"0") || dfs(size-1, res+"1");
    }
}

import java.util.HashMap;

public class FourSumII {
    public static void main(String[] args) {

    }
    static int count;
    static HashMap<String, Integer> dp;
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int[][] val = new int[4][2];
        val[0] = nums1;
        val[1] = nums2;
        val[2] = nums3;
        val[3] = nums4;
        count = 0;
        dp = new HashMap<>();
        return dfs(val, 0, 0);
    }
    public int dfs(int[][] val, int arr, int sum){
        if(arr == 4){
            if(sum == 0)
                return 1;
            return 0;
        }
        if(dp.containsKey(arr+","+sum))
            return dp.get(arr+","+sum);
        int a = 0;
        for(int n : val[arr]){
            a += dfs(val,arr+1,sum+n);
        }
        dp.put(arr+","+sum,a);
        return a;
    }
}
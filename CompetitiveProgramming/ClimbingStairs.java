import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {

    }
    public int climbStairs(int n) {
        int[] result = new int[n+1];
        Arrays.fill(result, -1);
        for(int i=1;i<=n;i++){
            result[i] = find(i,result);
        }
        return result[n];
    }
    public int find(int n, int[] result){
        if(n<0)
            return 0;
        if(n==0){
            return 1;
        }
        if(result[n] != -1){
            return result[n];
        }
        return find(n-1,result) + find(n-2,result);
    }

}

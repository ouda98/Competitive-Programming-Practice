package FacebookPreInterview;

public class ChangeInAForeignCurrency {
    public static void main(String[] args) {
        System.out.println(canGetExactChange(75, new int[]{4, 17, 29}));
    }
    static int[][] memo;
    static boolean canGetExactChange(int targetMoney, int[] denominations) {
        // Write your code here
        memo = new int[targetMoney+1][denominations.length+1];
        return solve(targetMoney, denominations, 0);

    }

    static boolean solve(int targetMoney, int[] denominations, int idx){
        if(idx == denominations.length && targetMoney == 0){
            return true;
        }
        if(idx == denominations.length)
            return false;
        if(memo[targetMoney][idx] !=0) {
            return (memo[targetMoney][idx] == 1) ? true : false;
        }

        boolean f = false;
        if(denominations[idx] <= targetMoney){
            f|= solve(targetMoney- denominations[idx],denominations, idx);
        }
        f|= solve(targetMoney,denominations, idx+1);
        if(f==false){
            memo[targetMoney][idx] = -1;
        }else
            memo[targetMoney][idx] = 1;
        return f;
    }

}

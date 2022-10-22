import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int [] coins = {186,419,83,408};
        int amount = 6249;
        int result = coinChange(coins,amount);
        System.out.println(result);
    }
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int sum = 0;
        for(int i=coins.length-1;i>=0;i--){
            sum+=amount/coins[i];
            amount = amount%coins[i];
        }
        if(amount !=0)
            return -1;
        return sum;

    }
}

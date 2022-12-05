public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices) {
        int minBuy = prices[0];
        int maxProfit = 0;
        for(int current: prices){
            minBuy = Math.min(minBuy,current);
            maxProfit = Math.max(maxProfit, current- minBuy);
        }
        return maxProfit;
    }
}

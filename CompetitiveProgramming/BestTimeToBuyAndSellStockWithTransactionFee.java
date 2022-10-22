public class BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args) {
        int [] arr = {1, 4, 6, 2, 8, 3, 10, 14};
        System.out.println(maxProfit(arr,2));
    }
    public static int maxProfit(int[] prices, int fee) {
        int sell = 0;
        int own = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            sell = Math.max(sell, own + prices[i] - fee);
            own = Math.max(own, sell - prices[i]);
        }
        return sell;
    }
}

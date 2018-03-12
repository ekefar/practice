package dynamic;

/**
 * @author : Alexander Serebriyan
 *         https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */
public class BestStockPrice {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 4, 3, 6}));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int buyIndex = 0;
        int maxProfit = 0;


        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[buyIndex]) {
                buyIndex = i;
            } else {
                maxProfit = Math.max(prices[i] - prices[buyIndex], maxProfit);
            }
        }

        return maxProfit;
    }
}

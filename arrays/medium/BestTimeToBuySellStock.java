package arrays.medium;

public class BestTimeToBuySellStock {

    /**
     * Brute Force Approach: O(n^2)
     * Try all buy-sell pairs.
     */
    public static int maxProfitBrute(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;

        for (int i = 0; i < n; i++) {             // buy day
            for (int j = i + 1; j < n; j++) {     // sell day
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    /**
     * Optimal Approach: O(n)
     * Track minimum price so far and compute profit greedily.
     */
    public static int maxProfitOptimal(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }

    // Quick demo
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};

        System.out.println("Brute Force Profit: " + maxProfitBrute(arr));   // 5
        System.out.println("Optimal Profit: " + maxProfitOptimal(arr));     // 5
    }
}
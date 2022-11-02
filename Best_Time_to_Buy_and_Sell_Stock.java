public class Best_Time_to_Buy_and_Sell_Stock {
    /**
     * O(N) Solution
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE;
        int low_index = -1;
        int high = Integer.MIN_VALUE;
        int high_index = -1;
        int profit = 0;
        int current = 0;
        for (int i = 0; i < prices.length; i++) {
            current = prices[i];
            if (current < low) {
                low = current;
                low_index = i;
            }
            if (current > high || high_index < low_index) {
                high = current;
                high_index = i;
            }
            int difference = high - low;
            if (difference > profit && high_index > low_index) {
                profit = difference;
            }
        }
        return profit;
    }
}

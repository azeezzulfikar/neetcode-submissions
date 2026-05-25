class Solution {
    public int maxProfit(int[] prices) {
        int l=0, r=1, maxProfit = 0;

        while(r < prices.length) {
            if(prices[r] - prices[l] > 0) {
                maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
            }
            if(prices[r] < prices[l]) {
                l = r;
            }
            r++;
        }

        return maxProfit;
    }
}

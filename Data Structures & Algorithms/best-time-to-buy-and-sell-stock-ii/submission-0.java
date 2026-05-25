class Solution {
    public int maxProfit(int[] prices) {
        int i=0, j=1, maxProfit =0, currProfit=0;
        while(j < prices.length) {
            if(prices[i] > prices[j]){ 
                i=j; 
                j++; 
                continue;
            }
            currProfit += prices[j] - prices[i];
            j++;
            i++;
            maxProfit = Math.max(maxProfit, currProfit);
        }
        return maxProfit; 
    }
}
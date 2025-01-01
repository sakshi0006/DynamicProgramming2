class Solution {
    public int maxProfit(int[] prices) {
        int i = 0, j = 1, maxProfit = 0;

        while(i < prices.length && j < prices.length){
            
            if(prices[i] >= prices[j]){
                i=j;j++;
            }else {
                int profit = prices[j] - prices[i];
                if(profit > maxProfit) maxProfit = profit;

                j++;
            }
        }
        return maxProfit;
    }
}

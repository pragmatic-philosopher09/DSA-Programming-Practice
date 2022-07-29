class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        
        int profit = 0;
        int minCP = prices[0];
        for(int i = 1;i<prices.length; i++)
        {
            int costDiff = prices[i] - minCP;
            profit = Math.max(profit, costDiff);
            minCP = Math.min(minCP,prices[i]);
        }
        
        return profit;
        
    }
}
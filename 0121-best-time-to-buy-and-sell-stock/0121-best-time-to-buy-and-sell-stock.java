class Solution {
    
    public int maxProfit(int[] prices) {
        int[] minArray = new int[prices.length];
        int min = 10001;
        for(int i=0; i<prices.length; i++) {
            if(min > prices[i]) min = prices[i];
            minArray[i] = min;
        }

        int result = 0;
        for(int i=0; i<prices.length; i++) {
            if(result < prices[i] - minArray[i]) result =  prices[i] - minArray[i];
        }

        return result;
    }

}
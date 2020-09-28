class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==1) return 0;
        
        int max = prices[0];
        int min = max;
        int res = 0;
        for(int price : prices){
            if(price < max){
                res += max-min;
                min = price;
                max = min;
                continue;
            }
            if(price>max) max = price;
        }
        res += max-min;
        return res;
    }
}
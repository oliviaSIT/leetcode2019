/*
hard
solution:dp https://blog.csdn.net/liuchonge/article/details/73274871
 */

public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2)
            return 0;
        int [] maxBefore = new int[len];
        int min = prices[0];
        for(int i=1; i<len; i++){
            maxBefore[i] = Math.max(maxBefore[i-1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        int max = prices[len - 1];
        int ret = 0;
        for(int i=len-2; i>=0; i--){
            //找到后面最大的价格
            max = Math.max(prices[i], max);
            //利润 = 最大价格 - 当前价格 + 此时交易时第一次的利润
            //取最大值
            ret = Math.max(ret, max - prices[i] + maxBefore[i]);
        }
        return ret;
    }
}

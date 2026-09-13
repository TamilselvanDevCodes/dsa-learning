package dp.striver.course.stocks;

public class BestTimeToBuyAndSellStock1 {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock1 main=new BestTimeToBuyAndSellStock1();
        int[] prices=new int[]{7,6,4,3,2,1};
        int res=main.maxProfit(prices);
        System.out.println("res : "+res);
    }
    public int maxProfit(int[] prices) {
        int buy=prices[0];
        int profit=0;
        for(int i=1;i<prices.length;i++){
            int currentPrice=prices[i];
            profit=Math.max(profit,currentPrice-buy);
            buy=Math.min(buy,currentPrice);
        }
        return profit;
    }
}

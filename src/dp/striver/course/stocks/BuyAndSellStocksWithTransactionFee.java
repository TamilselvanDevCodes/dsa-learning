package dp.striver.course.stocks;

import java.util.Arrays;

public class BuyAndSellStocksWithTransactionFee {
    static long iterations=0;
    public static void main(String[] args) {
        BuyAndSellStocksWithTransactionFee main = new BuyAndSellStocksWithTransactionFee();
        int[] prices = new int[]{1,3,2,8,4,9};
        int res = main.maxProfit(prices,2);
        System.out.println("res : " + res);
        System.out.println("iterations : " + iterations);
    }

    public int maxProfit(int[] prices,int fee) {

//        return getMaxProfit(0,1,fee,prices);
        return getMaxProfitWithDPInConstantSpace(prices,fee);
    }

    private int getMaxProfitWithDPInConstantSpace(int[] prices,int fee) {
        int n=prices.length;
        int[]next=new int[2];
        int[]curr=new int[2];
        for(int i=n-1;i>=0;i--){
            for(int canBuy=0;canBuy<=1;canBuy++){
                iterations++;
                int profit;
                if (canBuy == 1) {
                    profit = Math.max(
                            next[0] - prices[i],
                            next[1]
                    );
                } else {
                    profit = Math.max(
                            next[1] + prices[i]-fee,
                            next[0]
                    );
                }
                curr[canBuy]=profit;
            }
            int[] temp=next;
            next=curr;
            curr=temp;
        }
        return next[1];
    }

    private int getMaxProfit(int index, int canBuy,int fee, int[] prices) {
        iterations++;
        if (index >= prices.length) {
            return 0;
        }
        int profit;
        if (canBuy == 1) {
            profit = Math.max(
                    getMaxProfit(index + 1, 0,fee, prices) - prices[index],
                    getMaxProfit(index + 1, canBuy,fee, prices)
            );
        } else {
            profit = Math.max(getMaxProfit(index + 1, 1,fee, prices) + prices[index]-fee,
                    getMaxProfit(index + 1, canBuy,fee, prices)
            );
        }
        return profit;
    }
}

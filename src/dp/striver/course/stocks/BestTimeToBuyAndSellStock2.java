package dp.striver.course.stocks;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock2 {
    static long iterations=0;
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock2 main = new BestTimeToBuyAndSellStock2();
        int[] prices = new int[]{7,1,5,3,6,4};
        int res = main.maxProfit(prices);
        System.out.println("res : " + res);
        System.out.println("iterations : " + iterations);
    }

    public int maxProfit(int[] prices) {
        int[][]dp=new int[prices.length][2];
        for(int[] arr :dp){
            Arrays.fill(arr,-1);
        }
//        return getMaxProfit(0,1,prices);
//        return getMaxProfitWithDP(0,1,dp,prices);
//        return getMaxProfitWithDP(prices);
        return getMaxProfitWithDPInConstantSpace(prices);
    }

    private int getMaxProfitWithDPInConstantSpace(int[] prices) {
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
                            next[1] + prices[i],
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



    private int getMaxProfitWithTabulation(int[] prices) {
        int n=prices.length;
        int[][]dp=new int[n+1][2];
        for(int i=n-1;i>=0;i--){
            for(int canBuy=0;canBuy<=1;canBuy++){
                iterations++;
                int profit;
                if (canBuy == 1) {
                    profit = Math.max(
                            dp[i+1][0] - prices[i],
                            dp[i+1][1]
                    );
                } else {
                    profit = Math.max(
                            dp[i+1][1] + prices[i],
                            dp[i+1][0]
                    );
                }
                dp[i][canBuy]=profit;
            }
        }
        return dp[0][1];
    }


    private int getMaxProfitWithDP(int index, int canBuy,int[][]dp, int[] prices) {
        iterations++;
        if (index >= prices.length) {
            return 0;
        }
        if(dp[index][canBuy]!=-1){
            return dp[index][canBuy];
        }
        int profit;
        if (canBuy == 1) {
            profit = Math.max(
                    getMaxProfitWithDP(index + 1, 0,dp, prices) - prices[index],
                    getMaxProfitWithDP(index + 1, canBuy, dp,prices)
            );
        } else {
            profit = Math.max(getMaxProfitWithDP(index + 1, 1,dp, prices) + prices[index],
                    getMaxProfitWithDP(index + 1, canBuy, dp,prices)
            );
        }
        return dp[index][canBuy]= profit;
    }
    private int getMaxProfit(int index, int canBuy, int[] prices) {
        iterations++;
        if (index >= prices.length) {
            return 0;
        }
        int profit;
        if (canBuy == 1) {
            profit = Math.max(
                    getMaxProfit(index + 1, 0, prices) - prices[index],
                    getMaxProfit(index + 1, canBuy, prices)
            );
        } else {
            profit = Math.max(getMaxProfit(index + 1, 1, prices) + prices[index],
                    getMaxProfit(index + 1, canBuy, prices)
            );
        }
        return profit;
    }
}

package dp.striver.course.stocks;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock3 {
    static long iterations = 0;

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock3 main = new BestTimeToBuyAndSellStock3();
        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        int res = main.maxProfit(prices);
        System.out.println("res : " + res);
        System.out.println("iterations : " + iterations);
    }

    public int maxProfit(int[] prices) {
        int[][][]dp=new int[prices.length][2][3];
        for(int[][] arr :dp){
            for(int[] ar:arr){
                Arrays.fill(ar,-1);
            }
        }
//        return getMaxProfit(0, 1, 1, prices);
//        return getMaxProfitWithDP(0, 1, 1,dp, prices);
//        return getMaxProfitWithTabulation(prices);
        return getMaxProfitWithConstSpace(prices);
    }

    private int getMaxProfitWithConstSpace(int[] prices) {
        int n=prices.length;
        int[][] next=new int[2][4];
        int[][] curr=new int[2][4];

        for(int i=n-1;i>=0;i--){
            for(int canBuy=0;canBuy<=1;canBuy++){
                for(int currentTransaction=1;currentTransaction<=2;currentTransaction++){
                    iterations++;
                    int profit;
                    if (canBuy == 1) {
                        profit=Math.max(next[0][currentTransaction]-prices[i],
                                next[1][currentTransaction]
                        );
                    } else {
                        profit=Math.max(
                                next[1][currentTransaction+1]+prices[i],
                                next[0][currentTransaction]
                        );
                    }
                    curr[canBuy][currentTransaction]=profit;
                }
            }
            int[][]temp=next;
            next=curr;
            curr=temp;
        }
        return next[1][1];
    }


    private int getMaxProfitWithTabulation(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n+1][2][4];

        for(int i=n-1;i>=0;i--){
            for(int canBuy=0;canBuy<=1;canBuy++){
                for(int currentTransaction=1;currentTransaction<=2;currentTransaction++){
                    iterations++;
                    int profit;
                    if (canBuy == 1) {
                        profit=Math.max(dp[i+1][0][currentTransaction]-prices[i],
                                dp[i+1][1][currentTransaction]
                                );
                    } else {
                        profit=Math.max(
                                dp[i+1][1][currentTransaction+1]+prices[i],
                                dp[i+1][0][currentTransaction]
                        );
                    }
                    dp[i][canBuy][currentTransaction]=profit;
                }
            }
        }
        return dp[0][1][1];
    }
    private int getMaxProfitWithDP(int index, int canBuy, int currentTransaction, int[][][] dp, int[] prices) {
        iterations++;
        if (index >= prices.length) {
            return 0;
        }
        if (currentTransaction == 3) {
            return 0;
        }
        if(dp[index][canBuy][currentTransaction]!=-1){
            return dp[index][canBuy][currentTransaction];
        }
        int profit;
        if (canBuy == 1) {
            profit = Math.max(
                    getMaxProfitWithDP(index + 1,
                            0, currentTransaction, dp, prices) - prices[index],
                    getMaxProfitWithDP(index + 1, canBuy,
                            currentTransaction, dp, prices)
            );
        } else {
            profit = Math.max(
                    getMaxProfitWithDP(index + 1, 1,
                            currentTransaction + 1, dp, prices) + prices[index],
                    getMaxProfitWithDP(index + 1, canBuy,
                            currentTransaction, dp, prices)
            );
        }
        return dp[index][canBuy][currentTransaction]= profit;
    }

    private int getMaxProfit(int index, int canBuy, int currentTransaction, int[] prices) {
        iterations++;
        if (index >= prices.length) {
            return 0;
        }
        if (currentTransaction == 3) {
            return 0;
        }
        int profit;
        if (canBuy == 1) {
            profit = Math.max(
                    getMaxProfit(index + 1, 0, currentTransaction, prices) - prices[index],
                    getMaxProfit(index + 1, canBuy, currentTransaction, prices)
            );
        } else {
            profit = Math.max(getMaxProfit(index + 1, 1, currentTransaction + 1, prices) + prices[index],
                    getMaxProfit(index + 1, canBuy, currentTransaction, prices)
            );
        }
        return profit;
    }
}


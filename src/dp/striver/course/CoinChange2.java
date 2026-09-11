package dp.striver.course;

import java.util.Arrays;

public class CoinChange2 {
    static int iterations=0;
    public static void main(String[] args) {
        CoinChange2 main=new CoinChange2();
        int[]coins=new int[]{1,2,5};
        int amount=30;
        int res=main.change(amount,coins);
        System.out.println("res : "+res);
        System.out.println("iterations : "+iterations);
    }
    public int change(int amount, int[] coins) {
        int[][]dp=new int[coins.length][amount+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
//        return getTotalWays(coins.length-1,amount,coins);
//        return getTotalWaysWithRecAndDP(coins.length-1,amount,dp,coins);
//        return getTotalWaysWithoutRecAndDP(coins.length-1,amount,dp,coins);
        return getTotalWaysWithoutRecAnd1DArray(coins.length-1,amount,coins);
    }
    private int getTotalWaysWithoutRecAnd1DArray(int index,int amount, int[]coins){
        int[] dp=new int[amount+1];
        dp[0]=1;
        for(int i=0;i<=index;i++){
            for(int j=coins[i];j<=amount;j++){
                iterations++;
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
    private int getTotalWaysWithoutRecAndDP(int index,int amount,int[][]dp, int[]coins){
        for(int i=0;i<=index;i++){
            iterations++;
            dp[i][0]=1;
        }
        for(int i=0;i<=index;i++){
            for(int j=1;j<=amount;j++){
                iterations++;
                int notTake=i==0?0:dp[i-1][j];
                int take=0;
                if(coins[i]<=j){
                    take=dp[i][j-coins[i]];
                }
                dp[i][j]=take+notTake;
            }
        }
        return dp[index][amount];
    }

    private int getTotalWaysWithRecAndDP(int index,int amount,int[][]dp, int[]coins){
        iterations++;
        if (index == 0) {
            return amount % coins[0] == 0 ? 1 : 0;
        }
        if(amount==0){
            return 1;
        }
        if(dp[index][amount]!=-1){
            return dp[index][amount];
        }
        int notTake=getTotalWaysWithRecAndDP(index-1,amount,dp,coins);
        int take=0;
        if(coins[index]<=amount){
            take=getTotalWaysWithRecAndDP(index,amount-coins[index],dp,coins);
        }
        return dp[index][amount]=take+notTake;
    }
    private int getTotalWays(int index,int amount, int[]coins){
        iterations++;

        if (index == 0) {
            return amount % coins[0] == 0 ? 1 : 0;
        }
        if(amount==0){
            return 1;
        }
        int notTake=getTotalWays(index-1,amount,coins);
        int take=0;
        if(coins[index]<=amount){
            take=getTotalWays(index,amount-coins[index],coins);
        }
        return take+notTake;
    }
}

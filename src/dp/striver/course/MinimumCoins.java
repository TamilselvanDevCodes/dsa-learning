package dp.striver.course;

import java.util.Arrays;

public class MinimumCoins {
    static int iterations = 0;

    public static void main(String[] args) {
        MinimumCoins main = new MinimumCoins();
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        int res = main.coinChange(coins, amount);
        System.out.println("res : " + res);
        System.out.println("iterations : " + iterations);
    }

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
//        return getMinCoinsCountWithDP(coins.length-1,amount,dp,coins);
//        return getMinCoinsCountWithoutRecAndWithDP(coins.length - 1, amount, dp, coins);
//        return getMinCoinsCountWithoutRecAndWithDPAnd1DArray(coins.length - 1, amount, coins);
        return getMinCoinsCountWithoutRecAndWithDPAnd1DArrayAnd1Array(coins.length - 1, amount, coins);
//        return getMinCoinsCount(coins.length-1,amount,coins);
    }

    private int getMinCoinsCountWithoutRecAndWithDPAnd1DArrayAnd1Array(int index,
                                                                       int remainingAmount, int[] coins)
    {
        int[] dp = new int[remainingAmount+1];

        for (int i = 0; i <= index; i++) {
            for (int j = 1; j <= remainingAmount; j++) {
                iterations++;
                int notTake = i == 0 ? -1 : dp[j];
                int take = -1;
                if (coins[i] <= j) {
                    int res = dp[j - coins[i]];
                    if (res != -1) {
                        take = 1 + res;
                    }
                }
                if (take == -1) {
                    dp[j] = notTake;
                } else if (notTake == -1) {
                    dp[j] = take;
                } else {
                    dp[j] = Math.min(take, notTake);
                }
            }
        }
        return dp[remainingAmount];
    }



    private int getMinCoinsCountWithoutRecAndWithDPAnd1DArray(int index, int remainingAmount, int[] coins) {
        int[] prev = new int[remainingAmount+1];
        int[] curr = new int[remainingAmount+1];

        for (int i = 0; i <= index; i++) {
            for (int j = 1; j <= remainingAmount; j++) {
                iterations++;
                int notTake = i == 0 ? -1 : prev[j];
                int take = -1;
                if (coins[i] <= j) {
                    int res = curr[j - coins[i]];
                    if (res != -1) {
                        take = 1 + res;
                    }
                }
                if (take == -1) {
                    curr[j] = notTake;
                } else if (notTake == -1) {
                    curr[j] = take;
                } else {
                    curr[j] = Math.min(take, notTake);
                }
            }
            int[]temp=prev;
            prev=curr;
            curr=temp;
        }
        return prev[remainingAmount];
    }




    private int getMinCoinsCountWithoutRecAndWithDP(int index, int remainingAmount, int[][] dp, int[] coins) {
        for (int i = 0; i <= index; i++) {
            iterations++;
            dp[i][0] = 0;
        }
        for (int i = 0; i <= index; i++) {
            for (int j = 1; j <= remainingAmount; j++) {
                iterations++;
                int notTake = i == 0 ? -1 : dp[i - 1][j];
                int take = -1;
                if (coins[i] <= j) {
                    int res = dp[i][j - coins[i]];
                    if (res != -1) {
                        take = 1 + res;
                    }
                }
                if (take == -1) {
                    dp[i][j] = notTake;
                } else if (notTake == -1) {
                    dp[i][j] = take;
                } else {
                    dp[i][j] = Math.min(take, notTake);
                }
            }
        }
        return dp[index][remainingAmount];
    }

    private int getMinCoinsCountWithDP(int index, int remainingAmount, int[][] dp, int[] coins) {
        iterations++;
        if (remainingAmount == 0) {
            return 0;
        }
        if (index == 0) {
            return remainingAmount % coins[index] == 0 ? remainingAmount / coins[index] : -1;
        }
        if (dp[index][remainingAmount] != -1) {
            return dp[index][remainingAmount];
        }
        int notTake = getMinCoinsCountWithDP(index - 1, remainingAmount, dp, coins);
        int take = -1;
        if (coins[index] <= remainingAmount) {
            int res = getMinCoinsCountWithDP(index, remainingAmount - coins[index], dp, coins);
            if (res != -1) {
                take = 1 + res;
            }
        }
        if (notTake == -1) {
            return dp[index][remainingAmount] = take;
        }
        if (take == -1) {
            return dp[index][remainingAmount] = notTake;
        }
        return dp[index][remainingAmount] = Math.min(take, notTake);
    }


    private int getMinCoinsCount(int index, int remainingAmount, int[] coins) {
        iterations++;
        if (remainingAmount == 0) {
            return 0;
        }
        if (index == 0) {
            return remainingAmount % coins[index] == 0 ? remainingAmount / coins[index] : -1;
        }
        int notTake = getMinCoinsCount(index - 1, remainingAmount, coins);
        int take = -1;
        if (coins[index] <= remainingAmount) {
            int res = getMinCoinsCount(index, remainingAmount - coins[index], coins);
            if (res != -1) {
                take = 1 + res;
            }
        }
        if (notTake == -1) {
            return take;
        }
        if (take == -1) {
            return notTake;
        }
        return Math.min(take, notTake);
    }
}

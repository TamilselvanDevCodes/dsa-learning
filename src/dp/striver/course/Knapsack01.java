package dp.striver.course;

import java.util.Arrays;

public class Knapsack01 {
    static long iterations = 0;

    public static void main(String[] args) {
        Knapsack01 main = new Knapsack01();
        int[] val = new int[]{10, 40, 30, 50};
        int[] weight = new int[]{5, 4, 2, 3};
        int W = 5;
        int res = main.knapsack(W, val, weight);
        System.out.println("res : " + res);
        System.out.println("iterations : " + iterations);
    }

    public int knapsack(int W, int val[], int wt[]) {
        int[][] dp = new int[val.length][W + 1];
//        for(int[] arr:dp){
//            Arrays.fill(arr,-1);
//        }

//        return getMaxVal(val.length-1,W,val,wt);
//        return getMaxValUsingDP(val.length-1,W,dp,val,wt);
//        return getMaxValWithoutRecAndWithDP(val.length-1,W,dp,val,wt);
//        return getMaxValWithoutRecAndWithDPAnd1DArray(val.length - 1, W, val, wt);
        return getMaxValWithoutRecAndWithDPAnd1Array(val.length - 1, W, val, wt);
    }

    private int getMaxValWithoutRecAndWithDPAnd1Array(int index, int remWeight, int[] val, int[] weight) {
        int[] dp = new int[remWeight + 1];
        for (int i = 0; i <= index; i++) {
            for (int j = remWeight; j >= weight[i]; j--) {
                iterations++;
                int notTake = dp[j];
                int take = (val[i]) + (i == 0 ? 0 : dp[j - weight[i]]);
                dp[j] = Math.max(take, notTake);
            }
        }
        return dp[remWeight];
    }

    private int getMaxValWithoutRecAndWithDPAnd1DArray(int index, int remWeight, int[] val, int[] weight) {
        int[] prev = new int[remWeight + 1];
        int[] curr = new int[remWeight + 1];

        for (int i = 0; i <= index; i++) {
            for (int j = 1; j <= remWeight; j++) {
                iterations++;
                int notTake = i == 0 ? 0 : prev[j];
                int take = 0;
                if (weight[i] <= j) {
                    take = (val[i]) + (i == 0 ? 0 : prev[j - weight[i]]);
                }
                curr[j] = Math.max(take, notTake);
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[remWeight];
    }

    private int getMaxValWithoutRecAndWithDP(int index, int remWeight, int[][] dp, int[] val, int[] weight) {
        iterations++;
        for (int i = 0; i <= index; i++) {
            iterations++;
            dp[i][0] = 0;
        }
        for (int i = 0; i <= index; i++) {
            for (int j = 1; j <= remWeight; j++) {
                iterations++;
                int notTake = i == 0 ? 0 : dp[i - 1][j];
                int take = 0;
                if (weight[i] <= j) {
                    take = (val[i]) + (i == 0 ? 0 : dp[i - 1][j - weight[i]]);
                }
                dp[i][j] = Math.max(take, notTake);
            }
        }
        return dp[index][remWeight];
    }

    private int getMaxValUsingDP(int index, int remWeight, int[][] dp, int[] val, int[] weight) {
        iterations++;
        if (index < 0) {
            return 0;
        }
        if (dp[index][remWeight] != -1) {
            return dp[index][remWeight];
        }
        int notTake = getMaxValUsingDP(index - 1, remWeight, dp, val, weight);
        int take = 0;
        if (weight[index] <= remWeight) {
            take = val[index] + getMaxValUsingDP(index - 1,
                    remWeight - weight[index], dp, val, weight);
        }
        return dp[index][remWeight] = Math.max(take, notTake);
    }

    private int getMaxVal(int index, int remWeight, int[] val, int[] weight) {
        iterations++;
        if (index < 0) {
            return 0;
        }
        int notTake = getMaxVal(index - 1, remWeight, val, weight);
        int take = 0;
        if (weight[index] <= remWeight) {
            take = val[index] + getMaxVal(index - 1,
                    remWeight - weight[index], val, weight);
        }
        return Math.max(take, notTake);
    }

}

package dp.striver.course;

public class UnboundedKnapsack {
    static long iterations=0;

    public static void main(String[] args) {
        UnboundedKnapsack main = new UnboundedKnapsack();
        int[] val = new int[]{10, 40, 30, 50};
        int[] weight = new int[]{5, 4, 2, 3};
        int W = 5;
        int res = main.knapsack(W, val, weight);
        System.out.println("res : " + res);
        System.out.println("iterations : " + iterations);
    }

    public int knapsack(int W, int val[], int wt[]) {
        return getMaxValWithoutRecAndWithDPAnd1DArray(val.length - 1, W, val, wt);
    }
    private int getMaxValWithoutRecAndWithDPAnd1Array(int index, int remWeight, int[] val, int[] weight) {
        int[] dp = new int[remWeight + 1];
        for (int i = 0; i <= index; i++) {
            for (int j = weight[i]; j <= remWeight; j++) {
                iterations++;
                int notTake = dp[j];
                int take = (val[i]) + dp[j - weight[i]];
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
                    take = (val[i]) + (i == 0 ? 0 : curr[j - weight[i]]);
                }
                curr[j] = Math.max(take, notTake);
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[remWeight];
    }

}

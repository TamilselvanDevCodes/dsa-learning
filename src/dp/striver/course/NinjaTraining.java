package dp.striver.course;

import java.util.Arrays;

public class NinjaTraining {
    static long iterations = 0;

    public static void main(String[] args) {
        NinjaTraining main = new NinjaTraining();
        int[][] points = {
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}
        };
        int res = main.ninjaTraining(points);
        System.out.println("res : " + res);
        System.out.println("iterations : " + iterations);
    }

    public int ninjaTraining(int[][] matrix) {
        int res = 0;
        int[][]dp=new int[matrix.length][matrix[0].length];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        for (int i = 0; i < 3; i++) {
            res = Math.max(res, getMaxMeritPoints(matrix.length - 1, i,dp, matrix));
        }
        return res;
    }

    private int getMaxMeritPoints(int row, int prevColumn, int[][] matrix) {
        iterations++;
        if (row == 0) {
            if (prevColumn == 0) {
                return Math.max(matrix[0][1], matrix[0][2]);
            } else if (prevColumn == 1) {
                return Math.max(matrix[0][0], matrix[0][2]);
            } else if (prevColumn == 2) {
                return Math.max(matrix[0][0], matrix[0][1]);
            } else {
                return 0;
            }
        }
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            if (i != prevColumn) {
                sum = Math.max(
                        sum,
                        getMaxMeritPoints(row - 1, i, matrix) + matrix[row][i]
                );
            }
        }
        return sum;
    }

    private int getMaxMeritPoints(int row, int prevColumn, int[][] dp, int[][] matrix) {
        iterations++;
        if (row == 0) {
            if (prevColumn == 0) {
                return Math.max(matrix[0][1], matrix[0][2]);
            } else if (prevColumn == 1) {
                return Math.max(matrix[0][0], matrix[0][2]);
            } else if (prevColumn == 2) {
                return Math.max(matrix[0][0], matrix[0][1]);
            } else {
                return 0;
            }
        }
        if( dp[row][prevColumn] != -1 ){
            return dp[row][prevColumn];
        }
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            if (i != prevColumn) {
                sum = Math.max(
                        sum, getMaxMeritPoints(row - 1, i,dp, matrix) + matrix[row][i]
                );
            }
        }
        return dp[row][prevColumn]= sum;
    }
}

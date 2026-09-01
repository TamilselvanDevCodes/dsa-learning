package dp.striver.course;

public class GridUniquePaths {

    static long iterations = 0;

    public static void main(String[] args) {
        GridUniquePaths main = new GridUniquePaths();
        int res = main.uniquePaths(20, 10);
        System.out.println("res : " + res);
        System.out.println("iterations : " + iterations);
    }

    public int uniquePaths(int m, int n) {
        return getPathWithDPWithout2DArray(m, n);
    }

    private int getPath(int row, int column, int[][] dp) {
        iterations++;
        if (row >= dp.length || column >= dp[row].length) {
            return 0;
        }
        if (row == dp.length - 1 && column == dp[row].length - 1) {
            return 1;
        }
        if (dp[row][column] != 0) {
            return dp[row][column];
        } else {
            return dp[row][column] = getPath(row + 1, column, dp) + getPath(row, column + 1, dp);
        }
    }

    private int getPathWithDP(int row, int column) {
        int[][] dp = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                iterations++;
                if (i != 0 && j != 0) {
                    int up = dp[i - 1][j];
                    int left = dp[i][j - 1];
                    dp[i][j] = up + left;
                } else {
                    dp[i][j] = 1;
                }
            }
        }
        return dp[row - 1][column - 1];
    }

    private int getPathWithDPWithout2DArray(int row, int column) {
        int[] prev = new int[column];
        int[] curr = new int[column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                iterations++;
                if (i != 0 && j != 0) {
                    int up = prev[j];
                    int left = curr[j - 1];
                    curr[j] = up + left;
                } else {
                    curr[j] = 1;
                }
            }
            prev = curr;
            curr = new int[column];
        }
        return prev[column - 1];
    }

    private int getPathWithObstacleWithDPWithout2DArray(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] prev = new int[n];
        int[] curr = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                iterations++;

                if (matrix[i][j] == -1) {
                    curr[j] = 0;
                }
                else if (i == 0 && j == 0) {
                    curr[j] = 1;
                }
                else {
                    int up = prev[j];
                    int left = j > 0 ? curr[j - 1] : 0;

                    curr[j] = up + left;
                }
            }
            prev = curr;
            curr = new int[n];
        }
        return prev[n - 1];
    }
}

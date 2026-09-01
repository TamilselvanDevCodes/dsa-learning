package dp.striver.course;


import java.util.Arrays;

class MinPathSum {
    static long iterations=0;
    public static void main(String[] args) {
        MinPathSum main=new MinPathSum();
        int[][] matrix = {
                {1, 3, 1, 2, 4, 5, 2, 1, 3, 4, 2, 5, 1, 3, 4, 2, 5, 1, 4, 3},
                {2, 1, 4, 3, 5, 2, 1, 4, 3, 2, 5, 1, 4, 2, 3, 5, 1, 4, 2, 3},
                {4, 2, 1, 5, 3, 4, 2, 1, 5, 3, 1, 4, 2, 5, 3, 1, 4, 2, 5, 1},
                {3, 5, 2, 1, 4, 3, 5, 2, 1, 4, 3, 5, 2, 1, 4, 3, 5, 2, 1, 4},
                {1, 4, 3, 2, 5, 1, 4, 3, 2, 5, 1, 4, 3, 2, 5, 1, 4, 3, 2, 5},
                {5, 2, 4, 1, 3, 5, 2, 4, 1, 3, 5, 2, 4, 1, 3, 5, 2, 4, 1, 3},
                {2, 3, 5, 4, 1, 2, 3, 5, 4, 1, 2, 3, 5, 4, 1, 2, 3, 5, 4, 1},
                {4, 1, 2, 3, 5, 4, 1, 2, 3, 5, 4, 1, 2, 3, 5, 4, 1, 2, 3, 5},
                {3, 4, 1, 5, 2, 3, 4, 1, 5, 2, 3, 4, 1, 5, 2, 3, 4, 1, 5, 2},
                {5, 1, 3, 2, 4, 5, 1, 3, 2, 4, 5, 1, 3, 2, 4, 5, 1, 3, 2, 4},
                {1, 2, 5, 3, 4, 1, 2, 5, 3, 4, 1, 2, 5, 3, 4, 1, 2, 5, 3, 4},
                {4, 3, 2, 1, 5, 4, 3, 2, 1, 5, 4, 3, 2, 1, 5, 4, 3, 2, 1, 5},
                {2, 5, 1, 4, 3, 2, 5, 1, 4, 3, 2, 5, 1, 4, 3, 2, 5, 1, 4, 3},
                {3, 1, 4, 5, 2, 3, 1, 4, 5, 2, 3, 1, 4, 5, 2, 3, 1, 4, 5, 2},
                {5, 4, 2, 3, 1, 5, 4, 2, 3, 1, 5, 4, 2, 3, 1, 5, 4, 2, 3, 1},
                {1, 3, 5, 2, 4, 1, 3, 5, 2, 4, 1, 3, 5, 2, 4, 1, 3, 5, 2, 4},
                {4, 2, 3, 1, 5, 4, 2, 3, 1, 5, 4, 2, 3, 1, 5, 4, 2, 3, 1, 5},
                {2, 4, 1, 3, 5, 2, 4, 1, 3, 5, 2, 4, 1, 3, 5, 2, 4, 1, 3, 5},
                {3, 5, 4, 2, 1, 3, 5, 4, 2, 1, 3, 5, 4, 2, 1, 3, 5, 4, 2, 1},
                {5, 2, 1, 4, 3, 5, 2, 1, 4, 3, 5, 2, 1, 4, 3, 5, 2, 1, 4, 3}
        };
        int res=main.minPathSum(matrix);
        System.out.println("res : "+res);
        System.out.println("iterations : "+iterations);
    }
    public int minPathSum(int[][] grid) {
        return processResWithoutRecWithout2DArrayAnd1Array(grid);
    }

    private int processRes(int[][] grid, int[][] dp, int row, int column) {
        iterations++;
        if (row >= grid.length || column >= grid[row].length) {
            return -1;
        }
        if (dp[row][column] != -1) {
            return dp[row][column];
        }
        int left=processRes(grid, dp, row + 1, column);
        int right= processRes(grid, dp, row, column + 1);
        if(left==-1&&right==-1){
            return dp[row][column]= grid[row][column];
        }
        else if(left==-1){
            return dp[row][column]= grid[row][column]+right;
        }
        else if(right==-1){
            return dp[row][column]= grid[row][column]+left;
        }
        else {
            return dp[row][column]= grid[row][column]+Math.min(left,right);
        }
    }
    private int processResWithoutRec(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][]dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                iterations++;
                if(i==0&&j==0){
                    dp[i][j]=grid[i][j];
                }
                else {
                    int left=Integer.MAX_VALUE;
                    int up=Integer.MAX_VALUE;
                    if(i>0){
                        up=dp[i-1][j];
                    }
                    if(j>0){
                        left=dp[i][j-1];
                    }
                    dp[i][j]=Math.min(left,up)+grid[i][j];
                }
            }
        }
        return dp[m-1][n-1];
    }

    private int processResWithoutRecWithout2DArray(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[]prev=new int[n];
        int[]curr=new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                iterations++;
                if(i==0&&j==0){
                    curr[j]=grid[i][j];
                }
                else {
                    int left=Integer.MAX_VALUE;
                    int up=Integer.MAX_VALUE;
                    if(i>0){
                        up=prev[j];
                    }
                    if(j>0){
                        left=curr[j-1];
                    }
                    curr[j]=Math.min(left,up)+grid[i][j];
                }
            }
            prev=curr;
            curr=new int[n];
        }
        return prev[n-1];
    }

    private int processResWithoutRecWithout2DArrayAnd1Array(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[]dp=new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                iterations++;
                if(i==0&&j==0){
                    dp[j]=grid[i][j];
                }
                else {
                    int left=Integer.MAX_VALUE;
                    int up=Integer.MAX_VALUE;
                    if(i>0){
                        up=dp[j];
                    }
                    if(j>0){
                        left=dp[j-1];
                    }
                    dp[j]=Math.min(left,up)+grid[i][j];
                }
            }
        }
        return dp[n-1];
    }

}
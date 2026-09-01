package dp.striver.course;

import java.util.Arrays;

public class MinimumFallingPathSum {
    static long iterations = 0;

    public static void main(String[] args) {
        MinimumFallingPathSum main = new MinimumFallingPathSum();
        int[][] matrix = {
                {-48}
//                {10,  2,  8,  6,  4},
//                { 3,  7,  1,  9,  5},
//                { 8,  4,  6,  2,  7},
//                { 5,  9,  3,  8,  1},
//                { 4,  6,  2,  7,  3}
        };
        int res = main.minFallingPathSum(matrix);
        System.out.println("res : " + res);
        System.out.println("iterations : " + iterations);
    }
    public int minFallingPathSum(int[][] matrix) {
        return getFallingPathSumBase(matrix);
    }
    private int getFallingPathSumBase(int[][]matrix){
//        int result=Integer.MAX_VALUE;
//        int m=matrix.length;
//        int n=matrix[0].length;
//        int[][]dp=new int[m][n];
//        for(int[]arr : dp){
//            Arrays.fill(arr,-1);
//        }
//        for(int i=0;i<matrix[0].length;i++){
//            result=Math.min(result,getFallingPathSumWithoutRecAndDP(matrix));
//        }
//        return result;
        return getFallingPathSumWithoutRecAnd1DArray(matrix);
    }

    private int getFallingPathSumWithoutRecAnd1DArray(int[][]matrix){
        int result=Integer.MAX_VALUE;
        int m=matrix.length;
        int n=matrix[0].length;
        int[]prev=new int[n];
        int[]curr=new int[n];

        for(int i=m-1;i>=0;i--){
            for(int j=0;j<n;j++){
                iterations++;
                if(i==m-1){
                    curr[j]=matrix[i][j];
                }
                else{
                    int bottomLeft=Integer.MAX_VALUE;
                    int bottom=prev[j];
                    int bottomRight=Integer.MAX_VALUE;
                    if(j>0){
                        bottomLeft=prev[j-1];
                    }
                    if(j<n-1){
                        bottomRight=prev[j+1];
                    }
                    curr[j]=Math.min(Math.min(bottomLeft,bottom),bottomRight)+matrix[i][j];
                }
                if(i==0){
                    result=Math.min(result,curr[j]);
                }
            }
            prev=curr;
            curr=new int[n];
        }
        return result;
    }


    private int getFallingPathSumWithoutRecAndDP(int[][]matrix){
        int result=Integer.MAX_VALUE;
        int m=matrix.length;
        int n=matrix[0].length;
        int[][]dp=new int[m][n];

        for(int i=m-1;i>=0;i--){
            for(int j=0;j<n;j++){
                iterations++;
                if(i==m-1){
                    dp[i][j]=matrix[i][j];
                    continue;
                }
                int bottomLeft=Integer.MAX_VALUE;
                int bottom=dp[i+1][j];
                int bottomRight=Integer.MAX_VALUE;
                if(j>0){
                    bottomLeft=dp[i+1][j-1];
                }
                if(j<n-1){
                    bottomRight=dp[i+1][j+1];
                }
                dp[i][j]=Math.min(Math.min(bottomLeft,bottom),bottomRight)+matrix[i][j];
                if(i==0){
                    result=Math.min(result,dp[i][j]);
                }
            }
        }
        return result;
    }


    private int getFallingPathSumWithRecAndDP(int row, int col,int[][]dp, int[][]matrix){
        iterations++;
        if(col<0||col>=matrix[row].length){
            return Integer.MAX_VALUE;
        }
        if(row==0){
            return dp[row][col]=matrix[row][col];
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int topLeft=getFallingPathSumWithRecAndDP(row-1,col-1,dp,matrix);
        int top=getFallingPathSumWithRecAndDP(row-1,col,dp,matrix);
        int topRight=getFallingPathSumWithRecAndDP(row-1,col+1,dp,matrix);
        int result=Math.min(topLeft,Math.min(topRight,top))+matrix[row][col];
        return dp[row][col]= result;
    }

    private int getFallingPathSum(int row, int col, int[][]matrix){
        iterations++;
        if(col<0||col>=matrix[row].length){
            return Integer.MAX_VALUE;
        }
        if(row==0){
            return matrix[row][col];
        }
        int topLeft=getFallingPathSum(row-1,col-1,matrix);
        int top=getFallingPathSum(row-1,col,matrix);
        int topRight=getFallingPathSum(row-1,col+1,matrix);
        int result=Math.min(topLeft,Math.min(topRight,top))+matrix[row][col];
        return result;
    }
}

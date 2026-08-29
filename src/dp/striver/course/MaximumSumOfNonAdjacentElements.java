package dp.striver.course;


/*
Given an integer array nums of size n.
Return the maximum sum possible using the elements of nums such that no two
elements taken are adjacent in nums.
*/

import java.util.Arrays;

public class MaximumSumOfNonAdjacentElements {
    static long iterations = 0;

    public static void main(String[] args) {
        MaximumSumOfNonAdjacentElements main = new MaximumSumOfNonAdjacentElements();
        int[] nums = {
                3, 7, 2, 8, 4, 6, 5, 9, 1, 10,
                12, 14, 11, 13, 15, 17, 16, 20, 18, 21,
                19, 23, 22, 25, 24, 27, 26, 30, 28, 31,
                29, 33, 32, 35, 34, 37, 36, 40, 38, 41,
                39, 43, 42, 45, 44, 47, 46, 50, 48, 51,
                49, 53, 52, 55, 54, 57, 56, 60, 58, 61,
                59, 63, 62, 65, 64, 67, 66, 70, 68, 71,
                69, 73, 72, 75, 74, 77, 76, 80, 78, 81,
                79, 83, 82, 85, 84, 87, 86, 90, 88, 91,
                89, 93, 92, 95, 94, 97, 96, 100, 98, 101
        };
        int res =main.nonAdjacent(nums);
        System.out.println("res : "+res);
        System.out.println("iterations : "+iterations);
    }

    public int nonAdjacent(int[] nums) {
        int[]dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return getMaxSumWithoutDPAndRec(nums.length-1,nums);
    }
    private int getMaxSum(int index, int[] nums){
        iterations++;
        if(index==0){
            return nums[index];
        }
        else if(index<0){
            return 0;
        }
        int skipCurrent=getMaxSum(index-1,nums);
        int includeCurrent=getMaxSum(index-2,nums)+nums[index];
        return Math.max(skipCurrent,includeCurrent);
    }

    private int getMaxSum(int index,int[]dp, int[] nums){
        iterations++;
        if(index==0){
            return nums[index];
        }
        else if(index<0){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int skipCurrent=getMaxSum(index-1,dp,nums);
        int includeCurrent=getMaxSum(index-2,dp,nums)+nums[index];
        return Math.max(skipCurrent,includeCurrent);
    }
    private int getMaxSumWithoutRec(int targetIndex,int[]dp, int[] nums){
        if(nums.length==0||targetIndex>=nums.length){
            return -1;
        }
        else if(nums.length==1){
            return nums[0];
        }
        dp[0]=nums[0];
        iterations=1;
        for(int i=1;i<=targetIndex;i++){
            iterations++;
            int skipCurrent=dp[i-1];
            int includeCurrent=0;
            if(i>=2){
                includeCurrent=dp[i-2]+nums[i];
            }
            dp[i]=Math.max(skipCurrent,includeCurrent);
        }
       return dp[targetIndex];
    }
    private int getMaxSumWithoutDPAndRec(int targetIndex, int[] nums){
        if(nums.length==0||targetIndex>=nums.length){
            return -1;
        }
        else if(nums.length==1){
            return nums[0];
        }
        int prev2=nums[0];
        int prev1=Math.max(prev2,nums[1]);
        iterations=2;
        for(int i=2;i<=targetIndex;i++){
            iterations++;
         int current=Math.max(prev2+nums[i],prev1);
         prev2=prev1;
         prev1=current;
        }
        return prev1;
    }
}

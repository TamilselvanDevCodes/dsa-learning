package dp.striver.course;

/*
Given an integer array height[] where height[i] represents the height of the i-th stair, a frog starts from the first stair and wants to reach the last stair.

        From any stair i, the frog has two options: it can either jump to the (i+1)th stair or the (i+2)th stair. The cost of a jump is the absolute difference in height between the two stairs.

        Determine the minimum total cost required for the frog to reach the last stair.
*/

import java.util.Arrays;

public class FrogJump {
    private static int totalItr=0;
    public static void main(String[] args) {
        FrogJump main=new FrogJump();
        int[] height = {
                10, 5, 20, 0, 15
        };
        var res= main.frogJump(height,2);
        System.out.println("res : "+res);
        System.out.println("totalItr : "+totalItr);
    }
    int minCost(int[] height) {
        int[] dp=new int[height.length];
        Arrays.fill(dp,-1);
        if(height.length<=1){
            return 0;
        }
        return getJumpCostWithoutRec(height.length-1,dp,height);
    }
    private int getJumpCost(int index, int[] height){
        totalItr++;
        if(index==0){
            return 0;
        }
        int currentStepVal=height[index];
        int oneJump=getJumpCost(index-1,height)+Math.abs(currentStepVal-height[index-1]);
        int twoJump=Integer.MAX_VALUE;
        if(index>=2){
            twoJump=getJumpCost(index-2,height)+Math.abs(currentStepVal-height[index-2]);
        }
        return Math.min(oneJump,twoJump);
    }
    private int getJumpCost(int index,int[]dp, int[] height){
        totalItr++;
        if(index==0){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int currentStepVal=height[index];
        int oneJump=getJumpCost(index-1,dp,height)+Math.abs(currentStepVal-height[index-1]);
        int twoJump=Integer.MAX_VALUE;
        if(index>=2){
            twoJump=getJumpCost(index-2,dp,height)+Math.abs(currentStepVal-height[index-2]);
        }
        return dp[index]= Math.min(oneJump,twoJump);
    }
    private int getJumpCostWithoutRec(int index,int[]dp, int[] height){
       dp[0]=0;
       dp[1]=Math.abs(height[0]-height[1]);
        for(int i=2;i<height.length;i++){
            totalItr++;
           int oneJump=dp[i-1]+Math.abs(height[i]-height[i-1]);
           int twoJump=dp[i-2]+Math.abs(height[i]-height[i-2]);
           dp[i]=Math.min(oneJump,twoJump);
       }
        return dp[index];
    }

    public int frogJump(int[] heights, int k) {
        int[]dp=new int[heights.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<heights.length;i++){
            for(int jump=1;jump<=k;jump++){
                if(i-jump>=0){
                    int jumpValue=dp[i-jump]+Math.abs(heights[i]-heights[i-jump]);
                    dp[i]=Math.min(dp[i],jumpValue);
                }
            }
        }
        return dp[heights.length-1];
    }
}

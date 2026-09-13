package dp.striver.course.lis;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    static long iterations=0;
    public static void main(String[] args) {
        LongestIncreasingSubsequence main =new LongestIncreasingSubsequence();
        int[]nums=new int[]{10,9,2,5,3,7,101,18};
        int res= main.lengthOfLIS(nums);
        System.out.println("res : "+res);
        System.out.println("iterations : "+iterations);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][]dp=new int[n][n+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
//        return getMaxLISCount(0,-1,nums);
//        return getMaxLISCountWithDP(0,-1,dp,nums);
//        return getMaxLISCountWithTabulation(nums);
        return getMaxLISCountWith2Arrays(nums);
    }


    private int getMaxLISCountWith2Arrays(int[]nums){
        int n=nums.length;
        int[]next=new int[n+1];
        int[]curr=new int[n+1];
        for(int index=n-1;index>=0;index--){
            for(int prevIndex=-1;prevIndex<n;prevIndex++){
                iterations++;
                int notTake=next[prevIndex+1];
                int take=0;
                if(prevIndex==-1||nums[prevIndex]<nums[index]){
                    take=1+next[index+1];
                }
                curr[prevIndex+1]=Math.max(take,notTake);
            }
            int[]temp=next;
            next=curr;
            curr=temp;
        }
        return next[0];
    }



    private int getMaxLISCountWithTabulation(int[]nums){
        int n=nums.length;
        int[][]dp=new int[n+1][n+1];
        for(int index=n-1;index>=0;index--){
            for(int prevIndex=-1;prevIndex<n;prevIndex++){
                iterations++;
                int notTake=dp[index+1][prevIndex+1];
                int take=0;
                if(prevIndex==-1||nums[prevIndex]<nums[index]){
                    take=1+dp[index+1][index+1];
                }
                dp[index][prevIndex+1]=Math.max(take,notTake);
            }
        }
        return dp[0][0];
    }



    private int getMaxLISCountWithDP(int index, int prevIndex,int[][]dp,int[]nums){
        iterations++;
        if(index==nums.length){
            return 0;
        }
        if(dp[index][prevIndex+1]!=-1){
            return dp[index][prevIndex+1];
        }
        int notTake=getMaxLISCountWithDP(index+1,prevIndex,dp,nums);
        int take=0;
        if(prevIndex==-1||nums[prevIndex]<nums[index]){
            take=1+getMaxLISCountWithDP(index+1,index,dp,nums);
        }
        return dp[index][prevIndex+1]= Math.max(take,notTake);
    }

    private int getMaxLISCount(int index, int prevIndex,int[]nums){
        iterations++;
        if(index==nums.length){
            return 0;
        }
        int notTake=getMaxLISCount(index+1,prevIndex,nums);
        int take=0;
        if(prevIndex==-1||nums[prevIndex]<nums[index]){
            take=1+getMaxLISCount(index+1,index,nums);
        }
        return Math.max(take,notTake);
    }
}

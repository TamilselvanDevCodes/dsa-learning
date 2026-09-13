package dp.striver.course.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    static long iterations=0;
    public static void main(String[] args) {
        LongestIncreasingSubsequence main =new LongestIncreasingSubsequence();
        int[]nums=new int[]{10,9,2,5,3,7,101,18};
        int res= main.lengthOfLIS(nums);
        List<Integer>elements=main.getMaxLISElements(nums);
        System.out.println("res : "+res);
        System.out.println("elements : "+elements);
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
//        return getMaxLISCountWith2Arrays(nums);
        return getLISCountWith1Array(nums);
    }
    private List<Integer> getMaxLISElements(int[]nums){
        List<Integer> result=new ArrayList<>();
        int n=nums.length;
        int[]dp=new int[n];
        int[]prevIndexCache=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(prevIndexCache,-1);
        int resultIndex=0;
        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(nums[prev]<nums[i]){
                    if((1+dp[prev])>dp[i]){
                        dp[i]=1+dp[prev];
                        prevIndexCache[i]=prev;
                    }
                }
            }
            if(dp[i]>=dp[resultIndex]){
                resultIndex=i;
            }
        }
        while (resultIndex!=-1){
            result.add(nums[resultIndex]);
            resultIndex=prevIndexCache[resultIndex];
        }
        return result.reversed();
    }
    private int getLISCountWith1Array(int[]nums){
        int n=nums.length;
        int[]dp=new int[n];
        int resCount=1;
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(nums[prev]<nums[i]){
                    dp[i]=Math.max(1+dp[prev],dp[i]);
                }
            }
            resCount=Math.max(resCount,dp[i]);
        }
        return resCount;
    }
    private int getMaxLISCountWith2Arrays(int[]nums){
        int n=nums.length;
        int[]next=new int[n+1];
        int[]curr=new int[n+1];
        for(int index=n-1;index>=0;index--){
            for(int prevIndex=index-1;prevIndex>=-1;prevIndex--){
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
            for(int prevIndex=index-1;prevIndex>=-1;prevIndex--){
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

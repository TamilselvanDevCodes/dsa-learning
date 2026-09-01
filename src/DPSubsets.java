import java.util.Arrays;

public class DPSubsets {
    static long totalIterations=0;
    public static void main(String[] args) {
        DPSubsets main = new DPSubsets();
        int[] nums = {
                3, 7, 2, 8, 4, 6, 5, 9, 1, 10,
                12, 14, 11, 13, 15, 17, 16, 18, 20, 19,
                21, 23, 22, 24, 25, 27, 26, 28, 30, 29,
                31, 33, 32, 35, 34, 36, 38, 37, 40, 39
        };

        int target = 200;
        var res = main.isSubsetPresentForTargetUsing1DP(nums,target);
        System.out.println("res : " + res);
        System.out.println("totalIterations : " + totalIterations);
    }

    public boolean isSubsetPresentForTargetUsing2DP(int[] nums, int target){
        boolean[][] dp=new boolean[nums.length][target+1];
         for(int i=0;i<nums.length;i++){
             dp[i][0]=true;
         }
         if(nums[0]<=target){
             dp[0][nums[0]]=true;
         }
         for(int index=1;index<nums.length;index++){
             for(int currentTarget=1;currentTarget<=target;currentTarget++){
                 totalIterations++;
                 boolean notTake=dp[index-1][currentTarget];
                 if(notTake){
                     dp[index][currentTarget]=true;
                 }
                 else{
                     boolean take;
                     if(currentTarget-nums[index]>=0){
                         take=dp[index-1][currentTarget-nums[index]];
                         dp[index][currentTarget]=take;
                     }
                 }

             }
         }
        return dp[nums.length-1][target];
    }
    public boolean isSubsetPresentForTargetUsing1DP(int[] nums, int target){
        boolean[] prev=new boolean[target+1];
        boolean[] curr=new boolean[target+1];
         prev[0]=true;
         if(nums[0]<=target){
             prev[nums[0]]=true;
         }
         for(int index=1;index<nums.length;index++){
             curr[0]=true;
             for(int currentTarget=1;currentTarget<=target;currentTarget++){
                 totalIterations++;
                 boolean notTake=prev[currentTarget];
                 if(notTake){
                     curr[currentTarget]=true;
                 }
                 else{
                     boolean take;
                     if(currentTarget-nums[index]>=0){
                         take=prev[currentTarget-nums[index]];
                         curr[currentTarget]=take;
                     }
                 }

             }
             prev=curr;
             curr=new boolean[target+1];
         }
        return prev[target];
    }
    public boolean isSubsetPresentForTarget(int[] nums, int target){
        int[][] dp=new int[nums.length][target+1];
        for(int[] arr :dp){
            Arrays.fill(arr,-1);
        }
        return isSubsetPresent(nums.length-1,target,nums);
    }
    private boolean isSubsetPresent(int index, int target, int[] arr){
        totalIterations++;
        if(target==0){
            return true;
        }
        if(index==0){
            return arr[0]==target;
        }
        boolean take=false;
        if(arr[index]<=target){
            take=isSubsetPresent(index-1,target-arr[index],arr);
        }
        if(take){
            return true;
        }
        boolean notTake=isSubsetPresent(index-1,target,arr);
        return notTake;
    }

    private boolean isSubsetPresent(int index, int target,int[][]dp, int[] arr){
        totalIterations++;
        if(target==0){
            return true;
        }
        if(index==0){
            return arr[0]==target;
        }
        if(dp[index][target]!=-1){
            return dp[index][target]==1;
        }
        boolean take=false;
        if(arr[index]<=target){
            take=isSubsetPresent(index-1,target-arr[index],dp,arr);
        }
        boolean notTake=isSubsetPresent(index-1,target,dp,arr);
        dp[index][target]=take||notTake?1:0;
        return take||notTake;
    }
}

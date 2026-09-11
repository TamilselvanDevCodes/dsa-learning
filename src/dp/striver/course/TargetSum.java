package dp.striver.course;

import java.util.Arrays;

public class TargetSum {
    static long iterations=0;
    public static void main(String[] args) {
        TargetSum main=new TargetSum();
        int[] nums=new int[]{1,1,1,1,1};
        int target=3;
        int res=main.findTargetSumWays(nums,target);
        System.out.println("res : "+res);
        System.out.println("iterations : "+iterations);
    }
    public int findTargetSumWays(int[] nums, int target) {
//        return getTotalWays(nums.length-1,target,nums);
        return getTotalWaysUsingDP(target,nums);
    }
    private int getTotalWaysUsingDP(int target,int[]nums){
        int totalSum=0;
        for(int i:nums){
            totalSum+=i;
        }
        if(Math.abs(target)>totalSum){
            return 0;
        }
        int n=2*totalSum+1;
        int offset=totalSum;

        int[] prev=new int[n];
        int[] curr=new int[n];
        prev[offset+nums[0]]++;
        prev[offset-nums[0]]++;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<n;j++){
                if(prev[j]==0){
                    continue;
                }
                int sum=j-offset;
                int add=sum+nums[i];
                int sub=sum-nums[i];
                curr[offset+add]+=prev[j];
                curr[offset+sub]+=prev[j];
            }
            int[] temp=prev;
            prev=curr;
            curr=temp;
            Arrays.fill(curr,0);
        }
        return prev[offset+target];
    }
    private int getTotalWays(int index, int target, int[]nums){
        iterations++;
        if(index==0){
            int ways=0;
            if(nums[0]==target){
                ways++;
            }
            if(nums[0]==-target){
                ways++;
            }
            return ways;
        }
        int add=getTotalWays(index-1,target-nums[index],nums);
        int sub=getTotalWays(index-1,target+nums[index],nums);
        return add+sub;
    }

}

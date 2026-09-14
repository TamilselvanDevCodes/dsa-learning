package dp.striver.course.lis;
import java.util.*;

public class LargestDivisibleSubset {
    static long iterations=0;

    public static void main(String[] args) {
        LargestDivisibleSubset main=new LargestDivisibleSubset();
        int[] nums=new int[]{1,2,3};
        var res=main.largestDivisibleSubset(nums);
        System.out.println("res : "+res);
        System.out.println("iterations : "+iterations);
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        List<Integer> result=new ArrayList<>();
        int []dp=new int[n];
        int []prevIndexCache=new int[n];
        int resultIndex=0;
        Arrays.fill(prevIndexCache,-1);
        Arrays.sort(nums);
        for (int i=0;i<n;i++){
            dp[i]=1;
            for(int prev=0;prev<i;prev++){
                if(nums[i]%nums[prev]==0){
                    if(1+dp[prev]>=dp[i]){
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
}

package dp.striver.course;

import java.util.Arrays;

public class EditDistance {
    static long iterations=0;

    public static void main(String[] args) {
        EditDistance main=new EditDistance();
        String word1="intention";
        String word2="execution";
        int res=main.minDistance(word1,word2);
        System.out.println("res : "+res);
        System.out.println("iterations : "+iterations);
    }

    public int minDistance(String word1, String word2) {
        if(word1.equals(word2)){
            return 0;
        }
        int[][]dp=new int[word1.length()][word2.length()];
        for(int[] arr: dp){
            Arrays.fill(arr,-1);
        }
//        return getMinDistanceWithoutRecAndDP(word1,word2);
        return getMinDistanceWithoutRecAnd1DArray(word1,word2);
//        return getMinDistanceWithRecAndDP(word1.length()-1,word2.length()-1,dp,word1,word2);
    }

    private int getMinDistanceWithoutRecAnd1DArray(String word1,String word2){
        int n=word1.length();
        int m=word2.length();
        int[] prev=new int[m+1];
        int[] curr=new int[m+1];
        for(int j=0;j<m+1;j++){
            iterations++;
            prev[j]=j;
        }
        for(int i=1;i<n+1;i++){
            curr[0]=i;
            for(int j=1;j<m+1;j++){
                iterations++;
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    curr[j]=prev[j-1];
                }
                else{
                    curr[j]=1+Math.min(Math.min(curr[j-1], prev[j]), prev[j-1]);
                }
            }
            int[] temp=prev;
            prev=curr;
            curr=temp;
        }
        return prev[m];
    }

    private int getMinDistanceWithoutRecAndDP(String word1,String word2){
        int n=word1.length();
        int m=word2.length();
        int[][]dp=new int[n+1][m+1];
        for (int i=0;i<n+1;i++){
            iterations++;
            dp[i][0]=i;
        }
        for(int j=0;j<m+1;j++){
            iterations++;
            dp[0][j]=j;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                iterations++;
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    dp[i][j]=1+Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    private int getMinDistanceWithRecAndDP(int i1,int i2,int[][]dp,String s1,String s2){
        iterations++;
        if(i2<0){
            return 1+i1;
        }
        if(i1<0){
            return i2+1;
        }
        if(dp[i1][i2]!=-1){
            return dp[i1][i2];
        }
        if(s1.charAt(i1)==s2.charAt(i2)){
            return dp[i1][i2]=getMinDistanceWithRecAndDP(i1-1,i2-1,dp,s1,s2);
        }
        return dp[i1][i2]= 1+Math.min(
                Math.min(
                        getMinDistanceWithRecAndDP(i1,i2-1,dp,s1,s2),
                        getMinDistanceWithRecAndDP(i1-1,i2,dp,s1,s2)
                ),
                getMinDistanceWithRecAndDP(i1-1,i2-1,dp,s1,s2)
        );
    }
    private int getMinDistance(int i1,int i2,String s1,String s2){
        iterations++;
        if(i2<0){
            return 1+i1;
        }
        if(i1<0){
            return i2+1;
        }
        if(s1.charAt(i1)==s2.charAt(i2)){
            return getMinDistance(i1-1,i2-1,s1,s2);
        }
        return 1+Math.min(
                Math.min(
                        getMinDistance(i1,i2-1,s1,s2),
                        getMinDistance(i1-1,i2,s1,s2)
                ),
                getMinDistance(i1-1,i2-1,s1,s2)
        );
    }
}

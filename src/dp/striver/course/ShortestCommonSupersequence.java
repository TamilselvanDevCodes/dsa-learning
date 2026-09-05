package dp.striver.course;

public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        ShortestCommonSupersequence main=new ShortestCommonSupersequence();
        var res=main.shortestCommonSupersequence("ab","a");
        System.out.println("res : "+res);
    }
    public String shortestCommonSupersequence(String str1, String str2) {

        if(str1.isEmpty()||str2.isEmpty()){
            return "";
        }
        int n=str1.length();
        int m=str2.length();
        StringBuilder builder =new StringBuilder();
        int[][]dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(str1.charAt(i)==str2.charAt(j)){
                    dp[i][j]=1+(j>0&&i>0?dp[i-1][j-1]:0);
                }
                else{
                    dp[i][j]=Math.max(j>0?dp[i][j-1]:0,i>0?dp[i-1][j]:0);
                }
            }
        }
        n--;
        m--;
        while (n>=0&&m>=0){
            if(str1.charAt(n)==str2.charAt(m)){
                builder.append(str1.charAt(n));
                n--;
                m--;
            }
            else if(n==0){
                builder.append(str2.charAt(m));
                m--;
            }
            else if(m==0){
                builder.append(str1.charAt(n));
                n--;
            }
            else if(dp[n-1][m] > dp[n][m-1]){
                builder.append(str1.charAt(n));
                n--;
            }
            else {
                builder.append(str2.charAt(m));
                m--;
            }
        }
        while (n >= 0) {
            builder.append(str1.charAt(n--));
        }
        while (m >= 0) {
            builder.append(str2.charAt(m--));
        }
        return builder.reverse().toString();
    }
}

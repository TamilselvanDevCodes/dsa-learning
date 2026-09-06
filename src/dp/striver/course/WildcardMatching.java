package dp.striver.course;

public class WildcardMatching {
    static long iterations = 0;

    public static void main(String[] args) {
        WildcardMatching main = new WildcardMatching();
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String p = "*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*";
        boolean res = main.isMatch(s, p);
        System.out.println("res : " + res);
        System.out.println("iterations : " + iterations);
    }

    public boolean isMatch(String s, String p) {

//        return getIsMatchWithRecAndDP(s.length() - 1, p.length() - 1,
//                new Boolean[s.length()][p.length()], s, p);
//        return getIsMatchWithoutRecAndDP(s,p);
        return getIsMatchWithoutRecAnd1DArray(s,p);
    }
    private boolean getIsMatchWithoutRecAnd1DArray(String s, String p) {
        int n=s.length();
        int m=p.length();
        boolean[] prev=new boolean[m+1];
        boolean[] curr=new boolean[m+1];
        prev[0]=true;
        for(int j=1;j<m+1;j++){
            if (p.charAt(j-1) == '*') {
                prev[j]=prev[j-1];
            }
            else{
                prev[j]=false;
            }
        }
        for(int i=1;i<n+1;i++){
            curr[0]=false;
            char sChar=s.charAt(i-1);
            for(int j=1;j<m+1;j++){
                iterations++;
                char pChar=p.charAt(j-1);
                if(pChar=='*'){
                    curr[j]=prev[j]||curr[j-1];
                }
                else if(sChar == pChar ||
                        pChar == '?'){
                   curr[j]=prev[j-1];
                }
                else{
                    curr[j]=false;
                }
            }
            boolean[]temp=prev;
            prev=curr;
            curr=temp;
        }
        return prev[m];
    }

    private boolean getIsMatchWithoutRecAndDP(String s, String p) {
        int n=s.length();
        int m=p.length();
        boolean[][]dp=new boolean[n+1][m+1];
        dp[0][0]=true;
        for(int j=1;j<m+1;j++){
            if (p.charAt(j-1) == '*') {
                dp[0][j]=dp[0][j-1];
            }
            else{
                dp[0][j]=false;
            }
        }
        for(int i=1;i<n+1;i++){
            dp[i][0]=false;
        }
        for(int i=1;i<n+1;i++){
            char sChar=s.charAt(i-1);
            for(int j=1;j<m+1;j++){
                iterations++;
                char pChar=p.charAt(j-1);
                if(pChar=='*'){
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];
                }
                else if(sChar == pChar ||
                        pChar == '?'){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    dp[i][j]=false;
                }
            }
        }
        return dp[n][m];
    }

    private boolean getIsMatchWithRecAndDP(int i1, int i2, Boolean[][] dp, String s1,
                                           String s2) {
        iterations++;
        if (i1 < 0 && i2 < 0) {
            return true;
        } else if (i2 < 0) {
            return false;
        } else if (i1 < 0) {
            for (int i = i2; i >= 0; i--) {
                if (s2.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        } else if (dp[i1][i2] != null) {
            return dp[i1][i2];
        } else if (s2.charAt(i2) == '*') {
            return dp[i1][i2] = getIsMatchWithRecAndDP(i1 - 1, i2, dp, s1, s2) || getIsMatchWithRecAndDP(i1, i2 - 1, dp, s1, s2);
        }
        if (s1.charAt(i1) == s2.charAt(i2) ||
                s2.charAt(i2) == '?') {

            return dp[i1][i2] = getIsMatchWithRecAndDP(i1 - 1, i2 - 1, dp, s1, s2);
        }
        return dp[i1][i2] = false;
    }


    private boolean getIsMatch(int i1,int i2,String s1,String s2){
        iterations++;
        if(i1<0&&i2<0){
            return true;
        }
        else if(i2<0){
            return false;
        }
        else if(i1 < 0){
            for(int i=i2;i>=0;i--){
                if(s2.charAt(i) != '*'){
                    return false;
                }
            }
            return true;
        }
        else if(s2.charAt(i2)=='*'){
           return getIsMatch(i1-1,i2,s1,s2)|| getIsMatch(i1,i2-1,s1,s2);
        }
        if (s1.charAt(i1) == s2.charAt(i2) ||
                s2.charAt(i2) == '?') {

            return getIsMatch(i1 - 1, i2 - 1, s1, s2);
        }

        return false;
    }
}

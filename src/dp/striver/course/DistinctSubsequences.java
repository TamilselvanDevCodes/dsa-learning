package dp.striver.course;

import java.util.Arrays;

public class DistinctSubsequences {
    static long iterations = 0;

    public static void main(String[] args) {
        DistinctSubsequences main = new DistinctSubsequences();
        int res = main.numDistinct("babgbag", "bag");
        System.out.println("res : " + res);
        System.out.println("iterations : " + iterations);
    }

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
//        return getTotalDistinctWaysWithDP(s.length() - 1, t.length() - 1, dp, s, t);
//        return getTotalDistinctWays(s.length() - 1, t.length() - 1, s, t);
//        return getTotalDistinctWaysWithoutRec(s,t);
        return getTotalDistinctWaysWithoutRecAnd1DArray(s,t);
    }
    private int getTotalDistinctWaysWithoutRecAnd1DArray(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[]prev=new int[m+1];
        int[]curr=new int[m+1];
        prev[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            curr[0] = 1;
            for (int j = 1; j < m + 1; j++) {
                iterations++;
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + prev[j];
                }
                else{
                    curr[j]=prev[j];
                }
            }
            int[] temp=prev;
            prev=curr;
            curr=temp;
        }
        return prev[m];
    }

    private int getTotalDistinctWaysWithoutRec(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            iterations++;
            dp[i][0] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                iterations++;
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }

            }
        }
        return dp[n][m];
    }




    private int getTotalDistinctWays(int i1, int i2, String s1, String s2) {
        iterations++;
        if (i2 == 0) {
            return 1;
        }
        if (i1 == 0) {
            return 0;
        }
        if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1)) {

            return getTotalDistinctWays(i1 - 1, i2 - 1, s1, s2) + getTotalDistinctWays(i1 - 1, i2, s1, s2);
        }
        return getTotalDistinctWays(i1 - 1, i2, s1, s2);
    }

    private int getTotalDistinctWaysWithDP(int i1, int i2, int[][] dp, String s1, String s2) {
        iterations++;
        if (i2 < 0) {
            return 1;
        }
        if (i1 < 0) {
            return 0;
        }
        if (dp[i1][i2] != -1) {
            return dp[i1][i2];
        }
        if (s1.charAt(i1) == s2.charAt(i2)) {

            return dp[i1][i2] = getTotalDistinctWaysWithDP(i1 - 1, i2 - 1, dp, s1, s2) +
                    getTotalDistinctWaysWithDP(i1 - 1, i2, dp, s1, s2);
        }
        return dp[i1][i2] = getTotalDistinctWaysWithDP(i1 - 1, i2, dp, s1, s2);
    }
}

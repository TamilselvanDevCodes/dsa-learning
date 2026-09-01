package dp.striver.course;

import java.util.Arrays;

public class LongestCommonSubSequence {
    static long iterations = 0;

    public static void main(String[] args) {
        LongestCommonSubSequence main = new LongestCommonSubSequence();
        String text1 = "a".repeat(5) + "b".repeat(5);
        String text2 = "b".repeat(5) + "a".repeat(5);

        var res = main.longestCommonSubsequence(text1, text2);
        System.out.println("res : " + res);
        System.out.println("iterations : " + iterations);

    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
//        return getMaxSubsequenceWithRecAndDp(text1.length() - 1,
//                text2.length() - 1, dp, text1, text2);
//        return getMaxSubsequenceWithoutRecAndDp(text1.length() - 1, text2.length() - 1, text1, text2);
//        return getMaxSubsequence(text1.length() - 1, text2.length() - 1, text1, text2);
        return getMaxSubsequenceWithoutRecAndSingleDp(text1,text2);
    }


    private int getMaxSubsequence(int i1, int i2, String s1, String s2) {
        iterations++;
        if (i1 < 0 || i2 < 0) {
            return 0;
        } else if (s1.charAt(i1) == s2.charAt(i2)) {
            return 1 + getMaxSubsequence(i1 - 1, i2 - 1, s1, s2);
        }
        return Math.max(getMaxSubsequence(i1 - 1, i2, s1, s2), getMaxSubsequence(i1, i2 - 1, s1, s2));
    }


    private int getMaxSubsequenceWithRecAndDp(int i1, int i2, int[][] dp, String s1, String s2) {
        iterations++;
        if (i1 < 0 || i2 < 0) {
            return 0;
        } else if (dp[i1][i2] != -1) {
            return dp[i1][i2];
        } else if (s1.charAt(i1) == s2.charAt(i2)) {
            return dp[i1][i2] = 1 + getMaxSubsequenceWithRecAndDp(i1 - 1, i2 - 1, dp, s1, s2);
        }
        return dp[i1][i2] = Math.max(getMaxSubsequenceWithRecAndDp(i1 - 1, i2, dp, s1, s2),
                getMaxSubsequenceWithRecAndDp(i1, i2 - 1, dp, s1, s2));
    }

    private int getMaxSubsequenceWithoutRecAndDp(int i1, int i2, String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for (int j = 0; j < s2.length(); j++) {
            iterations++;
            if (s1.charAt(0) == s2.charAt(j)) {
                dp[0][j] = 1;
            }
        }
        for (int i = 1; i < s1.length(); i++) {
            for (int j = 1; j < s2.length(); j++) {
                iterations++;
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    int prevValWithI1 = dp[i][j - 1];
                    int prevValWithI2 = dp[i - 1][j];
                    dp[i][j] = Math.max(prevValWithI1, prevValWithI2);
                }
            }
        }
        return dp[i1][i2];
    }

    private int getMaxSubsequenceWithoutRecAndSingleDp(String s1, String s2) {
        int[]prev=new int[s2.length()];
        int[]curr=new int[s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                iterations++;
                if (s1.charAt(i) == s2.charAt(j)) {
                    int prevVal=0;
                    if(j>0){
                        prevVal=prev[j - 1];
                    }
                    curr[j] = 1 + prevVal;
                } else {
                    int prevValWithI1 = 0;
                    if(j>0){
                        prevValWithI1=curr[j - 1];
                    }
                    int prevValWithI2 = prev[j];
                    curr[j] = Math.max(prevValWithI1, prevValWithI2);
                }
            }
            prev=curr;
            curr=new int[s2.length()];
        }
        return prev[s2.length()-1];
    }
}
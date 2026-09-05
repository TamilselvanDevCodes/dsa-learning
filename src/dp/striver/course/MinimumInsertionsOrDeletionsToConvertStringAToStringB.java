package dp.striver.course;

public class MinimumInsertionsOrDeletionsToConvertStringAToStringB {
    public static void main(String[] args) {
        MinimumInsertionsOrDeletionsToConvertStringAToStringB main=new MinimumInsertionsOrDeletionsToConvertStringAToStringB();

    }
    public int minInsertionsAndDeletionToMakeW1ToW2(String word1, String word2) {
        int lcs= getLongestCommonSubSequence(word1,word2);
        int deletionVal=word1.length()-lcs;
        int insertionVal=word2.length()-lcs;
        return deletionVal+insertionVal;
    }
    private int getLongestCommonSubSequence(String s1, String s2){
        int m=s2.length();
        if (m == 0 || s1.length() == 0) {
            return 0;
        }
        int[]prev =new int[m];
        int[]curr =new int[m];
        for(int i=0;i<s1.length();i++){
            for(int j=0;j<m;j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    curr[j]=1+(j>0?prev[j-1]:0);
                }
                else{
                    curr[j]=Math.max(j>0?curr[j-1]:0,prev[j]);
                }
            }
            int[] temp=prev;
            prev=curr;
            curr=temp;
        }
        return prev[m-1];
    }

    public int minDistance(String word1, String word2) {
        int lcs= getLongestCommonSubSequence(word1,word2);
        int res1=word1.length()-lcs;
        int res2=word2.length()-lcs;
        return res1+res2;
    }

}

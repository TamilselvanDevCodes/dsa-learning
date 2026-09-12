package mocktest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MockTest1 {

    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> charToWordMap=new HashMap<>();
        HashMap<String,Character> wordTOCharMap=new HashMap<>();
        String[] words=s.split(" ");
        if(words.length!=pattern.length()){
            return false;
        }
        for(int i=0;i<words.length;i++){
            char ch=pattern.charAt(i);
            String word=words[i];
            if(charToWordMap.containsKey(ch)){
                if(!charToWordMap.get(ch).equals(word)){
                    return false;
                }
            }
            else if(wordTOCharMap.containsKey(word)){
                return false;
            }
            else{
                charToWordMap.put(ch,word);
                wordTOCharMap.put(word,ch);
            }
        }
        return true;
    }

    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[][]res=new int[m][n];
        Queue<int[]>queue=new LinkedList<>();
        int[][]directions=new int[][]{
                {-1,0},
                {0,-1},{0,1},
                {1,0}
        };
        for(int[] arr: res){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        for(int i =0;i<m;i++){
            for (int j=0;j<n;j++){
                if(mat[i][j]==0){
                    res[i][j]=0;
                    queue.offer(new int[]{i,j});
                }
            }
        }
        while (!queue.isEmpty()){
            int[] currentNode=queue.poll();
            assert currentNode!=null;
            int currentRow=currentNode[0];
            int currentColumn=currentNode[1];
            int currentNodeVal=res[currentRow][currentColumn];
            for(int[] direction:directions){
                int neighborRow=direction[0]+currentRow;
                int neighborColumn=direction[1]+currentColumn;
                if(neighborRow<0||neighborColumn<0||neighborRow>=m||neighborColumn>=n){
                    continue;
                }
                if(res[neighborRow][neighborColumn]==Integer.MAX_VALUE){
                    continue;
                }
                res[neighborRow][neighborColumn]=currentNodeVal+1;
                queue.offer(new int[]{neighborRow,neighborColumn});
            }
        }
        return res;
    }
}

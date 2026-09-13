package dp.striver.course.stocks;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock4 {
    static long iterations = 0;

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock4 main = new BestTimeToBuyAndSellStock4();
        int[] prices = new int[]{3,2,6,5,0,3};
        int res = main.maxProfit(2,prices);
        System.out.println("res : " + res);
        System.out.println("iterations : " + iterations);
    }

    public int maxProfit(int k,int[] prices) {
        int n=prices.length;
        int[][] next=new int[2][k+2];
        int[][] curr=new int[2][k+2];

        for(int i=n-1;i>=0;i--){
            for(int canBuy=0;canBuy<=1;canBuy++){
                for(int currentTransaction=1;currentTransaction<=k;currentTransaction++){
                    iterations++;
                    int profit;
                    if (canBuy == 1) {
                        profit=Math.max(next[0][currentTransaction]-prices[i],
                                next[1][currentTransaction]
                        );
                    } else {
                        profit=Math.max(
                                next[1][currentTransaction+1]+prices[i],
                                next[0][currentTransaction]
                        );
                    }
                    curr[canBuy][currentTransaction]=profit;
                }
            }
            int[][]temp=next;
            next=curr;
            curr=temp;
        }
        return next[1][1];
    }
}


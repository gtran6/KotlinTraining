package Basics;

public class BuySellStock {
    public static int maxProfit(int[] prices) {
        int min = prices[0]; //7
        int profit = 0; //0
        for (int price : prices) { //5
            min = Math.min(min, price); //(1, 5) ->5
            profit = Math.max(profit, price - min); //(0, 5-1) ->4
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = new int[] {7,1,5,3,6,4};
        int[] prices2 = new int[] {7,6,4,3,1};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit(prices2));
    }
}

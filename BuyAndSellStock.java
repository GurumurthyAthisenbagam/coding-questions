/**

SLIDING WINDOW
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
**/



/**
Optimal Approach: Single Pass (O(N))
We track the minimum price so far and calculate the max profit at each step.

Initialize minPrice = Integer.MAX_VALUE (to track the lowest price seen so far).
Initialize maxProfit = 0 (to track the highest profit possible).
Traverse the prices array:
If prices[i] < minPrice, update minPrice.
Calculate profit if we sell at prices[i]:
profit = prices[i] - minPrice.
Update maxProfit if profit is greater.
Return maxProfit.
  **/


class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0; i<prices.length; i++) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }
            if(maxProfit < prices[i] - minPrice) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}


/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
The idea behind using a state machine.

***********************************************************************************************

To find the profit each transaction has 2 states

State 1 -> Buying
State 2 -> Selling

When we buying, we use the profit. So profit = profit - stock price
When we selling, we add the earning into profit. So profit = profit + stock price

Using the above idea we create a state machine to find profit from at most 2 transactions (4 states).

State machine will look like:

transaction1 :- buy1 = max(buy1, 0 - stock) // for the 1st buy profit is 0
        				sell1 = max(sell1, buy1 + stock)
For 2nd trasaction we use the profit accumulated from 1st transaction

transaction2 :- buy2 = max(buy2, sell1 - stock)
				        sell2 = max(sell2, buy2 + stock)
Solution:
*/

class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 1) return 0;
        int buy1 = -prices[0], sell1 = 0, buy2 = -prices[0], sell2 = 0;
        for(int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}

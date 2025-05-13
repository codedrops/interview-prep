/**
 * This class provides a solution to the "Best Time to Buy and Sell Stock" problem.
 * 
 * Problem:
 * You are given an array `prices` where `prices[i]` is the price of a given stock on the i-th day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a 
 * different day in the future to sell that stock. Return the maximum profit you can achieve 
 * from this transaction. If no profit can be achieved, return 0.
 * 
 * Example:
 * Input: prices = [7, 1, 5, 3, 6, 4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6 - 1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * 
 * Solution Summary:
 * - The algorithm iterates through the array while keeping track of the minimum price seen so far.
 * - For each price, it calculates the potential profit by subtracting the minimum price from the current price.
 * - It updates the maximum profit if the calculated profit is greater than the current maximum profit.
 * - The time complexity of this solution is O(n), where n is the length of the prices array, 
 *   as it requires a single pass through the array.
 * - The space complexity is O(1) since no additional data structures are used.
 * 
 * Notes:
 * - If the input array is empty or null, the function returns 0 as no transactions can be made.
 * - The algorithm assumes that the input prices array contains non-negative integers.
 * 
 * Resources:
 * - LeetCode Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * - Related Topics: Array, Dynamic Programming, Greedy Algorithms
 * 
 * Video Explanation:
 * - "Best Time to Buy and Sell Stock - LeetCode 121 - Python Solution" by NeetCode: 
 *   https://www.youtube.com/watch?v=1pkOgXD63yU
 * - "Best Time to Buy and Sell Stock | Leetcode 121 | C++, Java, Python" by TechDose: 
 *   https://www.youtube.com/watch?v=excAOvwF_Wk
 */
package array;

public class BestTimeToBuySellStock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuySellStock solution = new BestTimeToBuySellStock();
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        int result = solution.maxProfit(prices);
        System.out.println("Maximum Profit: " + result); // Output: 5
    }
}

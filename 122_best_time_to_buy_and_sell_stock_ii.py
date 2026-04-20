class Solution:
    def maxProfit(self, prices):

        buy = prices[0]
        profit = 0
        n = len(prices)

        for i in range(1, len(prices)):
            if prices[i-1] > prices[i]:
                temp = prices[i-1] - buy
                profit += temp
                buy = prices[i]

        profit += prices[n-1] - buy
        return profit
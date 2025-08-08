class Solution:
    def getMaxProfit(self, prices: list[int]) -> int:
        n = len(prices)
        if (n < 2): return 0

        left = [0] * n
        min_price = prices[0]

        for i in range(1, n):
            min_price = min(min_price, prices[i])
            left[i] = max(left[i-1], prices[i] - min_price)

        right = [0] * n
        max_price = prices[n-1]

        for i in range(n-2, -1, -1):
            max_price = max(max_price, prices[i])
            right[i] = max(right[i+1], max_price - prices[i])

        max_profit = 0
        for i in range(n):
            max_profit = max(max_profit, left[i] + (right[i+1] if i+1 < n else 0))

        return max_profit
    
solution = Solution()

input1 = [3,3,5,0,0,3,1,4]
result1 = solution.getMaxProfit(input1)
print(result1)

input2 = [1,2,3,4,5]
result2 = solution.getMaxProfit(input2)
print(result2)

input3 = [7,6,4,3,1]
result3 = solution.getMaxProfit(input3)
print(result3)
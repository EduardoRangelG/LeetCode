class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2)
            return 0;

        int[] left = new int[n];
        int minPrice = prices[0];

        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - minPrice);
        }

        int[] right = new int[n];
        int maxPrice = prices[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            right[i] = Math.max(right[i + 1], maxPrice - prices[i]);
        }

        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            int currentProfit = left[i] + ((i + 1 < n) ? right[i + 1] : 0);
            maxProfit = Math.max(maxProfit, currentProfit);
        }

        return maxProfit;
    }
}

public class Problem1 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] input1 = { 3, 3, 5, 0, 0, 3, 1, 4 };
        int result1 = solution.maxProfit(input1);
        System.out.println(result1);

        int[] input2 = { 1, 2, 3, 4, 5 };
        int result2 = solution.maxProfit(input2);
        System.out.println(result2);

        int[] input3 = { 7, 6, 4, 3, 1 };
        int result3 = solution.maxProfit(input3);
        System.out.println(result3);
    }
}

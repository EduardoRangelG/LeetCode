function getMaxProfit(prices: number[]): number {
    const n = prices.length;
    if (n < 2) return 0;
    
    const left = new Array(n).fill(0);
    let minPrice = prices[0];
    
    for (let i = 1; i < n; i++) {
        minPrice = Math.min(minPrice, prices[i]);
        left[i] = Math.max(left[i-1], prices[i] - minPrice);
    }
    
    const right = new Array(n).fill(0);
    let maxPrice = prices[n-1];
    
    for (let i = n-2; i >= 0; i--) {
        maxPrice = Math.max(maxPrice, prices[i]);
        right[i] = Math.max(right[i+1], maxPrice - prices[i]);
    }
    
    let maxProfit = 0;
    for (let i = 0; i < n; i++) {
        maxProfit = Math.max(maxProfit, left[i] + (i+1 < n ? right[i+1] : 0));
    }
    
    return maxProfit;
};

const input1 = [3,3,5,0,0,3,1,4];
const result1 = getMaxProfit(input1);
console.log(result1);

const input2 = [1,2,3,4,5];
const result2 = getMaxProfit(input2);
console.log(result2);

const input3 = [7,6,4,3,1];
const result3 = getMaxProfit(input3);
console.log(result3);
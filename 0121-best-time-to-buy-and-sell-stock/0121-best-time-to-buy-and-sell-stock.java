class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0;
        int minPrice = prices[0];

        for (int price : prices) {
            if (minPrice < price) {
                answer = Math.max(price - minPrice, answer);
                continue;
            }
            if (minPrice > price) {
                minPrice = price;
                continue;
            }
        }

        return answer;
    }
}
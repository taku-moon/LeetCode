class Solution {
    public int maxProfit(int[] prices) {
        // 최대 이익은 0으로 초기화
        int answer = 0;
        // 저점은 임시로 첫 번째 값 지정
        int minPrice = prices[0];

        // prices를 순회하면서
        for (int price : prices) {
            // 저점 계산
            minPrice = Math.min(minPrice, price);
            // 최대 이익 계산
            answer = Math.max(answer, price - minPrice);
        }

        return answer;
    }
}
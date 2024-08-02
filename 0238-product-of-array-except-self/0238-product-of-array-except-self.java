class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];

        // 왼쪽 곱셈
        int mux = 1;
        for (int i = 0; i < nums.length; i++) {
            answer[i] = mux;
            mux *= nums[i]; 
        }

        // 오른쪽 곱셈
        // 왼쪽 곱셈 결과에 차례대로 곱하기
        mux = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] *= mux;
            mux *= nums[i]; 
        }

        return answer;
    }
}
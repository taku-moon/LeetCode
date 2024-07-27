class Solution {
    public int trap(int[] height) {
        int result= 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];

        // 투 포인터가 서로 겹칠 때까지 반복
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            // 더 높은 쪽을 향해 투 포인터 이동
            if (leftMax <= rightMax) {
                // 왼쪽 막대 최대 높이와의 차이를 더하고 왼쪽 포인터 이동
                result += leftMax - height[left];
                left++;
            } else {
                // 오른쪽 막대 최대 높이와의 차이를 더하고 오른쪽 포인터 이동
                result += rightMax - height[right];
                right--;
            }
        }

        return result;
    }
}
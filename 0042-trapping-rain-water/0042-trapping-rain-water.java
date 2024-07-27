class Solution {
    public int trap(int[] height) {
        int water = 0;
        int leftIdx = 0;
        int rightIdx = height.length - 1;
        int leftMaxHeight = height[leftIdx];
        int rightMaxHeight = height[rightIdx];

        while (leftIdx < rightIdx) {
            leftMaxHeight = Math.max(leftMaxHeight, height[leftIdx]);
            rightMaxHeight = Math.max(rightMaxHeight, height[rightIdx]);

            water += (leftMaxHeight <= rightMaxHeight) ? leftMaxHeight - height[leftIdx++] : rightMaxHeight - height[rightIdx--];
        }

        return water;
    }
}
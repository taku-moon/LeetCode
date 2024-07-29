class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> set = new LinkedHashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int leftIdx = i + 1;
            int rightIdx = nums.length - 1;

            while (leftIdx < rightIdx) {
                int sum = nums[i] + nums[leftIdx] + nums[rightIdx];

                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[leftIdx]);
                    list.add(nums[rightIdx]);
                    set.add(list);
                    leftIdx++;
                } else if (sum < 0) {
                    leftIdx++;
                } else if (sum > 0) {
                    rightIdx--;
                }
            }
        }

        return new ArrayList<>(set);
    }
}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> set = new LinkedHashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int num = nums[i];
            int leftIdx = i + 1;
            int rightIdx = nums.length - 1;

            while (leftIdx < rightIdx) {
                int sum = num + nums[leftIdx] + nums[rightIdx];

                if (sum == 0) {
                    // List<Integer> list = new ArrayList<>();
                    // list.add(num);
                    // list.add(nums[leftIdx]);
                    // list.add(nums[rightIdx]);
                    // set.add(list);

                    set.add(Arrays.asList(num, nums[leftIdx], nums[rightIdx]));
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
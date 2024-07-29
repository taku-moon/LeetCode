class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> set = new LinkedHashSet<>();

        for (int i = 0; i < nums.length-2; i++) {
            int num = nums[i];
            int firstIdx = i + 1;
            int secondIdx = nums.length-1;
            while (firstIdx < secondIdx) {
                int tmp = nums[firstIdx]+nums[secondIdx];
                if (tmp == -num) {
                    List<Integer> list = new ArrayList<>();
                    list.add(num);
                    list.add(nums[firstIdx]);
                    list.add(nums[secondIdx]);
                    set.add(list);
                    firstIdx++;
                } else if (tmp > -num) {
                    secondIdx--;
                } else if (tmp < -num) {
                    firstIdx++;
                }
            }
        }

        return new ArrayList<>(set);
    }
}
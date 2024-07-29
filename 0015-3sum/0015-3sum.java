class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> set = new LinkedHashSet<>();

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > 0) {
                break;
            }

            int num = nums[i];
            int firstIdx = i + 1;
            int secondIdx = nums.length-1;

            while (firstIdx != secondIdx) {
                if (nums[firstIdx]+nums[secondIdx] == -num) {
                    List<Integer> list = new ArrayList<>();
                    list.add(num);
                    list.add(nums[firstIdx]);
                    list.add(nums[secondIdx]);
                    set.add(list);
                    firstIdx++;
                } else if (nums[firstIdx]+nums[secondIdx] > -num) {
                    secondIdx--;
                } else if (nums[firstIdx]+nums[secondIdx] < -num) {
                    firstIdx++;
                }
            }
        }

        return new ArrayList<>(set);
    }
}
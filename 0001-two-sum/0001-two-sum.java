class Solution {
    public int[] twoSum(int[] nums, int target) {
        // key(nums의 요소 값) - value(인덱스)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            // target에서 nums[i]를 뺀 결과를 key로 조회하여 존재 여부 확인
            // 해당 key가 존재할 경우 그 key의 value인 인덱스가 현재 인덱스 i가 아닌 경우 정답으로 리턴
            if (map.containsKey(target - nums[i]) && i != map.get(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        
        return null;
    }
}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        int leftIdx, rightIdx, sum;
        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // 중복된 값 건너뛰기
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            // 간격을 좁혀가며 합 sum 계산
            leftIdx = i + 1;
            rightIdx = nums.length - 1;
            while (leftIdx < rightIdx) {
                sum = nums[i] + nums[leftIdx] + nums[rightIdx];

                // 합이 0인 경우 정답처리
                if (sum == 0) {
                    answer.add(Arrays.asList(nums[i], nums[leftIdx], nums[rightIdx]));

                    // 중복된 값 건너뛰기, 이 처리를 하지 않으면 같은 정답이 두 번 나올 수 있음
                    while (leftIdx < rightIdx && nums[leftIdx] == nums[leftIdx+1]) {
                        leftIdx++;
                    }
                    while (leftIdx < rightIdx && nums[rightIdx] == nums[rightIdx-1]) {
                        rightIdx--;
                    }
                    // 정답이 나왔으므로 투 포인터 모두 한 칸씩 이동
                    // 합이 0인 상황이므로 양쪽 모두 이동
                    leftIdx++;
                    rightIdx--;

                    // 합이 0보다 작다면 왼쪽 포인터 이동
                } else if (sum < 0) {
                    leftIdx++;
                    // 합이 0보다 크다면 오른쪽 포인터 이동
                } else if (sum > 0) {
                    rightIdx--;
                }
            }
        }
        return answer;
    }
}
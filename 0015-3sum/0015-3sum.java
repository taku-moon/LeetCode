class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 투 포인터 사용을 위해 배열을 정렬
        Arrays.sort(nums);

        // 중복 값을 허용하지 않으므로 Set에 List<Integer> 담기
        // Set에 입력한 순서를 유지하기 위해 LinkedHashSet 사용
        Set<List<Integer>> set = new LinkedHashSet<>();
        
        int leftIdx;
        int rightIdx;
        int sum;

        for (int i = 0; i < nums.length - 2; i++) {
            leftIdx = i + 1;
            rightIdx = nums.length - 1;

            // 간격을 좁혀가며 세 수의 합 sum 계산
            while (leftIdx < rightIdx) {
                sum = nums[i] + nums[leftIdx] + nums[rightIdx];
                
                // sum이 0인 경우 정답 처리
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[leftIdx]);
                    list.add(nums[rightIdx]);
                    set.add(list);
                    
                    // 정답이 나왔으니 투 포인터 양쪽 모두 한 칸씩 이동
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

        return new ArrayList<>(set);
    }
}
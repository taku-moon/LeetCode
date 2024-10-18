class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 각 엘리먼트의 빈도수를 저장할 해시맵 선언
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int key : nums) {
            frequencyMap.put(key, frequencyMap.getOrDefault(key, 0) + 1);
        }

        // 빈도수를 기준으로 각 엘리먼트를 저장할 해시맵 선언
        Map<Integer, List<Integer>> buckets = new HashMap<>();
        // 각 엘리먼트를 반복하며 이번에는 빈도수를 키로, 엘리먼트를 값으로 저장
        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            // 빈도수에 해당하는 엘리먼트가 존재하지 않으면 빈 리스트 생성
            List<Integer> keys = buckets.getOrDefault(frequency, new ArrayList<>());
            // 저장할 값에 엘리먼트 추가
            keys.add(key);
            // 빈도수를 키로, 엘리먼트를 값으로 저장
            buckets.put(frequency, keys);
        }

        // 결과로 리턴할 변수 선언
        int[] answer = new int[k];
        int idx = 0;
        // 전체 엘리먼트 수에서 하나씩 내려가며 해당하는 빈도의 엘리먼트 추출
        for (int frequency = nums.length; (frequency >= 0 && idx < k); frequency--) {
            // 해당 빈도에 값이 존재한다면 엘리먼트를 결과 변수에 삽입
            if (buckets.get(frequency) != null) {
                // 해당 빈도에 여러 엘ㄹ리먼트가 있을 수 있으므로 반복하여 모두 삽입
                for (int key : buckets.get(frequency)) {
                    answer[idx++] = key;
                }
            }
        }

        return answer;
    }
}
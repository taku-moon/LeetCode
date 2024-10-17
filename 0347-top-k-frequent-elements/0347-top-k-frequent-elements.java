class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 숫자의 빈도수를 카운트하는 map
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 빈도수를 기준으로 숫자를 정렬하는 PriorityQueue
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o2.getValue() - o1.getValue();    // 빈도수가 높은 순으로 정렬 = 내림차순
                }
            }
        );
        pq.addAll(map.entrySet());

        // 상위 k개의 빈도수를 가진 숫자를 추출
        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = pq.poll().getKey();
        }

        return answer;
    }
}
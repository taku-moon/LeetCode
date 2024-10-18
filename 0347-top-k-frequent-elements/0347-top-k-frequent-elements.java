class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 숫자의 빈도수를 카운트하는 map
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 빈도수를 기준으로 숫자를 정렬하는 PriorityQueue
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        // 우선순위 큐에 각 엘리먼트와 빈도수 삽입
        for (int key : map.keySet()) {
            pq.add(new int[]{key, map.get(key)});
        }

        // 상위 k개의 빈도수를 가진 숫자를 추출
        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = pq.poll()[0];
        }

        return answer;
    }
}
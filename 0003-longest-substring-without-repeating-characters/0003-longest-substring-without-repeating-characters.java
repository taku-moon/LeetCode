class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();    // Key = 문자, Value = 인덱스

        int start = 0;
        int end = 0;
        int maxLen = 0;

        // 문자열을 문자 단위로 반복
        for (char c : s.toCharArray()) {
            // 이미 등장했던 문자이고, 슬라이딩 윈도우의 안쪽에 있다면 start 위치 업데이트
            if (map.containsKey(c) && start <= map.get(c)) {
                start = map.get(c) + 1;
            } else {    // 최대 부분 문자열 길이 업데이트
                maxLen = Math.max(maxLen, end - start + 1);
            }

            // 문자 및 인덱스 삽입
            map.put(c, end++);
        }

        return maxLen;
    }
}
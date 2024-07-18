class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // 문제의 조건에 맞게 전처리 작업 후 문자열을 단어 배열로 저장
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");
        // String 배열인 금지어 목록을 비교 메서드 contains()를 제공하는 Set으로 바꾸기
        Set<String> ban = new HashSet<>(Arrays.asList(banned));

        // 단어(Key) + 단어별 등장 횟수(Value) 저장
        Map<String, Integer> map = new HashMap<>();

        // 단어가 금지어 리스트에 없는 단어이면 map에 추가 및 등장 횟수 증가
        for (String word : words) {
            if (!ban.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        // map에 저장된 데이터(entrySet) 중에서 등장 횟수(value)가 가장 많은 데이터의 단어(key) 반환
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
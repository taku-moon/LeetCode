class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Key(단어를 이루고 있는 문자)
        // Value(key가 동일한 단어들의 목록)
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // String 타입 단어 str을 문자 배열 char[]로 쪼개기
            char[] tmp = str.toCharArray();
            // 문자 배열을 정렬하고
            Arrays.sort(tmp);
            // map의 key로 저장할 수 있게 String 타입으로 바꾸기
            String key = String.valueOf(tmp);

            // 해당 key가 map에 존재하지 않을 때만 new ArrayList<>()
            // 해당 key가 map에 존재한다면 다음 구문은 실행 x
            map.putIfAbsent(key, new ArrayList<>());
            // key에 해당하는 ArrayList를 가져와 단어 str 추가
            map.get(key).add(str);
        }
        
        // map의 value로 저장된 모든 ArrayList를 결과로 모으기
        List<List<String>> result = new ArrayList<>(map.values());
        // 결과로 모은 list들은 단어가 정렬된 형태로 반환되어야 함
        for (List<String> list : result) {
            list.sort(null);
        }

        return result;
    }
}
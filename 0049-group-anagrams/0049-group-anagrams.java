class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String key = String.valueOf(tmp);

            // 만약 기존에 없던 키라면 빈 리스트를 삽입
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            // 키에 해당히는 리스트에 추가
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}